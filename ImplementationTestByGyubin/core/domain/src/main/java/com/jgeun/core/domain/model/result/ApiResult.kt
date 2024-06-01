package com.jgeun.core.domain.model.result

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