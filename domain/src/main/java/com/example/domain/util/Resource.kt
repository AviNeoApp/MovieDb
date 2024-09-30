package com.example.domain.util

import com.example.domain.error.RootError

sealed interface Resource<out D, out E : RootError> {
    data class Success<out D, out E : RootError>(val data: D) : Resource<D, E>
    data class Error<out D, out E : RootError>(val error: E) : Resource<D, E>

    companion object {
        fun <D, E : RootError> success(data: D): Success<D, E> {
            return Success(data)
        }

        fun <D, E : RootError> error(error: E): Error<D, E> {
            return Error(error)
        }
    }
}