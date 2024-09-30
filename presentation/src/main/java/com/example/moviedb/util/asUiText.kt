package com.example.moviedb.util

import com.example.domain.error.DataError
import com.example.domain.util.Resource
import com.example.moviedb.R

fun DataError.asUiText(): UiText {
    return when (this) {
        DataError.Network.REQUEST_TIMEOUT -> UiText.StringResource(
            R.string.error_request_timeout
        )

        DataError.Network.TOO_MANY_REQUESTS -> UiText.StringResource(
            R.string.error_too_many_requests
        )

        DataError.Network.NO_INTERNET -> UiText.StringResource(
            R.string.error_no_internet
        )

        DataError.Network.PAYLOAD_TOO_LARGE -> UiText.StringResource(
            R.string.error_payload_too_large
        )

        DataError.Network.SERVER_ERROR -> UiText.StringResource(
            R.string.error_server_error
        )

        DataError.Network.SERIALIZATION -> UiText.StringResource(
            R.string.error_serialization
        )

        DataError.Network.UNKNOWN -> UiText.StringResource(
            R.string.error_unknown
        )

        DataError.Local.UNKNOWN -> UiText.StringResource(
            R.string.error_unknown
        )
        DataError.Network.UNAUTHORIZED -> UiText.StringResource(
            R.string.error_unauthorized
        )
        DataError.Network.NOT_FOUND -> UiText.StringResource(
            R.string.error_not_found
        )
        DataError.Unknown -> UiText.StringResource(
            R.string.error_unknown
        )

        DataError.Network.SOMETHING_WENT_WRONG -> UiText.StringResource(R.string.error_something_went_wrong)
    }
}

fun Resource.Error<*, DataError>.asErrorUiText(): UiText {
    return error.asUiText()
}