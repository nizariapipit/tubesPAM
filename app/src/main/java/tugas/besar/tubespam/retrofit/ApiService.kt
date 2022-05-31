package tugas.besar.tubespam.retrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Headers("Authorization: Bearer 563492ad6f917000010000019a72c8387a094d11809956043350720c")
    //@GET("/v1/search")
    @GET("/v1/search")
    fun searchQueryGet(
        @Query("query") query: String
    ): Call<ResponsePexels>
}