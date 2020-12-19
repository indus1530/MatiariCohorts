package edu.aku.hassannaqvi.matiari_cohorts.repository

enum class ResponseStatus {
    SUCCESS,
    ERROR,
    LOADING
}

data class ResponseStatusCallbacks<out T>(
        val status: ResponseStatus,
        val data: T?,
        val message: String?
) {
    companion object {
        fun <T> success(data: T, message: String? = null): ResponseStatusCallbacks<T> =
                ResponseStatusCallbacks(status = ResponseStatus.SUCCESS, data = data, message = message)

        fun <T> error(data: T?, message: String): ResponseStatusCallbacks<T> =
                ResponseStatusCallbacks(status = ResponseStatus.ERROR, data = data, message = message)

        fun <T> loading(data: T?): ResponseStatusCallbacks<T> =
                ResponseStatusCallbacks(status = ResponseStatus.LOADING, data = data, message = null)
    }
}

data class ProgressResponseStatusCallbacks<out T>(
        val status: ResponseStatus
) {
    companion object {
        fun <T> success(): ProgressResponseStatusCallbacks<T> =
                ProgressResponseStatusCallbacks(status = ResponseStatus.SUCCESS)

        fun <T> error(): ProgressResponseStatusCallbacks<T> =
                ProgressResponseStatusCallbacks(status = ResponseStatus.ERROR)

        fun <T> loading(): ProgressResponseStatusCallbacks<T> =
                ProgressResponseStatusCallbacks(status = ResponseStatus.LOADING)
    }
}

