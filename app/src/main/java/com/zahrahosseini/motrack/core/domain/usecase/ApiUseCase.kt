package com.zahrahosseini.motrack.core.domain.usecase

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zahrahosseini.motrack.core.domain.entity.GeneralError
import com.zahrahosseini.motrack.core.utils.network.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class ApiUseCase<in P, R>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(parameters: P): ApiResult<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let {
                    if (it.isSuccessful) {
                        ApiResult.Success(it.body()!!)

                    } else {
                        val gson = Gson()
                        val type = object : TypeToken<GeneralError>() {}.type
                        val errorResponse: GeneralError? =
                            gson.fromJson(it.errorBody()!!.charStream(), type)

                        if (errorResponse?.errors == null) {
                            ApiResult.Error(Exception("Unknown Error"))
                        } else if (it.code() == 401 || it.code() == 404) {

                            ApiResult.Error(Exception("known Error"))

                        } else {
                            ApiResult.ServerError(errorResponse)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            ApiResult.Error(e)
        }
    }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: P): Response<R>
}
