package com.jgeun.core.model.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

sealed class ApiResult<out T> {
	data class Success<T>(val data: T) : ApiResult<T>()
	data class Error<T>(val exception: Exception) : ApiResult<T>()
}

fun <T> safeFlow(func: suspend () -> T): Flow<ApiResult<T>> = flow {
	try {
		emit(ApiResult.Success(func()))
	} catch (e: Exception) {
		emit(ApiResult.Error(e))
	}
}

fun <T1 : Any, T2 : Any, R : Any> ApiResult<T1>.zip(
	other: ApiResult<T2>,
	transform: (T1, T2) -> R
): ApiResult<R> {
	return when {
		this is ApiResult.Success && other is ApiResult.Success -> ApiResult.Success<R>(transform(this.data, other.data))
		this is ApiResult.Error -> ApiResult.Error(this.exception)
		other is ApiResult.Error -> ApiResult.Error(other.exception)
		else -> ApiResult.Error(Exception("No Result"))
	}
}