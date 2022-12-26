package utility

sealed class ScreenState<out T> {
    object Loading : ScreenState<Nothing>() // 1
    data class Content<T>(val data: T) : ScreenState<T>() // 2
    data class Error(val error: Throwable) : ScreenState<Nothing>() // 3
}
