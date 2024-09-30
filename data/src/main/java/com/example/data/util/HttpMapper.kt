package com.example.data.util

import com.example.domain.error.DataError

fun mapHttpCodeToNetworkError(httpCode: Int): DataError.Network {
    return when (httpCode) {
        401 -> DataError.Network.UNAUTHORIZED
        404 -> DataError.Network.NOT_FOUND
        408 -> DataError.Network.REQUEST_TIMEOUT
        429 -> DataError.Network.TOO_MANY_REQUESTS
        413 -> DataError.Network.PAYLOAD_TOO_LARGE
        500 -> DataError.Network.SERVER_ERROR
        400 -> DataError.Network.SERIALIZATION
        520 -> DataError.Network.UNKNOWN
        0 -> DataError.Network.SOMETHING_WENT_WRONG
        else -> DataError.Network.UNKNOWN
    }
}