package com.example.interviewproject.domain.use_case

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject
/*
class GetDataUseCase @Inject constructor(private val repository: RequestRepository) {
    fun executeGetRequestDetails(imdbId: String): Flow<Resource<RequestDetail>> = flow {
        try {
            emit(Resource.Loading())
            val requestDetail = repository.getRequestDetail(request = request)
            emit(Resource.Success(requestDetail.toRequestDetail()))
        }
        catch (e: IOError){
            emit(Resource.Error(message = "No internet connection."))
        }
        catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage?:"Error"))
        }
    }
}
*/