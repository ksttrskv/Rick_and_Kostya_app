package com.example.rickandkostya.core.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

sealed interface ApiResult<out T> {

    data object Loading : ApiResult<Nothing>

    data class Error(val error:  String?) : ApiResult<Nothing>

    data class Success<T>(val data: T) : ApiResult<T>
}

fun <T> toResultFlow(call: suspend () -> Response<T>?) : Flow<ApiResult<T?>> {
    return flow {
        emit(ApiResult.Loading)
        val responseResult = call()
        responseResult?.let {
            try {
                if (responseResult.isSuccessful && responseResult.body() != null) {
                    emit(ApiResult.Success(responseResult.body()))
                } else {
                    emit(ApiResult.Error(error =responseResult.message()))
                }
            } catch (e: Exception){
                emit(ApiResult.Error(error =responseResult.message()))
            }
        }
    }.flowOn(Dispatchers.IO)
}