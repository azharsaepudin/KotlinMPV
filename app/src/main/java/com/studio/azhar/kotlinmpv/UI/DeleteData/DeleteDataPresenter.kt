package com.studio.azhar.kotlinmpv.UI.DeleteData

import com.studio.azhar.kotlinmpv.API.ApiConfig
import com.studio.azhar.kotlinmpv.API.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteDataPresenter(private val view: DeleteDataView) {

    fun deleteData(id: String?){
        view.showLoading()

        val config = ApiConfig.config()
        val call = config.deleteData(id)
        call.enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                when(response.code()){
                    200->{
                        view.onSuccess(response.body()?.message)
                    }else ->{
                    view.onFiled(response.message())
                }
                }

                view.hideLoading()
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                view.onError(t.message)
                view.hideLoading()
            }
        })
    }

}