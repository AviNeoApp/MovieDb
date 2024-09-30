package com.example.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseUseCase<in Params, out Result> {

    protected abstract suspend fun execute(params: Params): Flow<Result>

    operator fun invoke(params: Params): Flow<Result> {
        return flow {
            emitAll(execute(params))
        }.flowOn(dispatcher)
    }

    protected abstract val dispatcher: CoroutineDispatcher
}