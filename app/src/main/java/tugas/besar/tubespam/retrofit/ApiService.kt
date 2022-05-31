package tugas.besar.tubespam.retrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Headers("Authorization: Bearer <token>")
    @GET("/v1/search")
    fun searchQueryGet(
        @Query("query") query: String
    ): Call<ResponsePexels>
}
