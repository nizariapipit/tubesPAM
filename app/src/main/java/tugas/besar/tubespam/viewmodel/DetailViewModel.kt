package tugas.besar.tubespam.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import tugas.besar.tubespam.retrofit.Detail
import tugas.besar.tubespam.retrofit.Src

class DetailViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isloading : LiveData<Boolean> = _isLoading

//    val _detailPhotos = MutableLiveData<Detail>()
    val detailPhotos = MutableLiveData<Detail>()

    fun setDetailPhotos(photosData : String) {
        _isLoading.value = true
        val asyncClient = AsyncHttpClient()
        asyncClient.addHeader("Authorization", "Bearer 563492ad6f917000010000019a72c8387a094d11809956043350720c")
        asyncClient.addHeader("User-Agent", "request")
        asyncClient.get(photosData, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                Log.d(TAG, result)
                try {
                    val jsonObject = JSONObject(result)
                    val ava = jsonObject.getString("url").replace("url", "tiny")
                    val fotografer = jsonObject.getString("photographer")
                    val id_fotografer = jsonObject.getString("photographer_id")
                    val alt = jsonObject.getString("alt")

                    val newInstance = Detail(ava, fotografer, id_fotografer, alt)
                    detailPhotos.postValue(newInstance)
  //                  _isLoading.value = false
                }
                catch (e: Exception){
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?,
            ) {
                when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Log.d("onFailure: ", error?.message.toString())
            }

        })
    }

    fun getDetailPhotos(): LiveData<Detail>{
        return  detailPhotos
    }

    companion object {
        private val TAG = DetailViewModel::class.java.simpleName
    }
}