package com.example.data.repository

import android.util.Log
import com.example.data.util.mapHttpCodeToNetworkError
import com.example.domain.error.DataError
import com.example.domain.error.RootError
import com.example.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

abstract class BaseRepository {
    inline fun <T,reified E: RootError> execute(block: () -> T): Resource<T, E> {
        return try {
            val result = block()
            Resource.success(result)
        } catch (ex: HttpException) {
            Log.e("execute::HttpException", ex.message.toString())
            Resource.Error(mapHttpCodeToNetworkError(ex.code()) as E)
        } catch (ex: UnknownHostException) {
            Log.e("execute::UnknownHostException", ex.message.toString())
            Resource.error(DataError.Network.SOMETHING_WENT_WRONG as E)
        } catch (ex: IOException) {
            Log.e("execute::IOException", ex.message.toString())
            Resource.error(DataError.Local.UNKNOWN as E)
        } catch (ex: Exception) {
            Log.e("execute::Exception", ex.message.toString())
            Resource.error(DataError.Unknown as E)
        }
    }

}