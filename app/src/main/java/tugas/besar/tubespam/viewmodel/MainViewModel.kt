package tugas.besar.tubespam.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import tugas.besar.tubespam.retrofit.ApiConfig
import tugas.besar.tubespam.retrofit.Photos
import tugas.besar.tubespam.retrofit.ResponsePexels

class MainViewModel : ViewModel(){

    private val listPhoto = MutableLiveData<List<Photos>>()

    fun photoSet(query: String) {
        val asyncClient = ApiConfig.getApiService().searchQueryGet(query)
        asyncClient.enqueue(object : retrofit2.Callback<ResponsePexels> {
        //asyncClient.enqueue(object : Callback(<Response>) {
            override fun onResponse(
                call: Call<ResponsePexels>,
                response: Response<ResponsePexels>
            ) {
                if(response.isSuccessful) {
                    val listPhotos2 = ArrayList<Photos>()
                    val responseBody = response.body()
                    if (responseBody != null) {
                        val listItem = responseBody.photos
                        for (zero in listItem) {
                            val listAdapter = Photos(zero.ava, zero.fotografer, zero.id_fotografer, zero.alt)
                            listPhotos2.add(listAdapter)
                        }
                        listPhoto.postValue(listPhotos2)
                    }
                }
                else {
                    Log.e(TAG,"onFailure: ${response.message()}" )
                }
            }
            override fun onFailure(call: Call<ResponsePexels>, t: Throwable) {

            }
        })

    }

    fun photoGet(): LiveData<List<Photos>> {
        return listPhoto
    }
}