package com.studio.azhar.kotlinmpv.UI.InputData

import com.studio.azhar.kotlinmpv.API.ApiConfig
import com.studio.azhar.kotlinmpv.API.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputDataPresenter(private val view: InputDataView) {
    fun inputData(nama: String?, email: String?){
        view.showLoading()

        val config = ApiConfig.config()
        val call = config.inputData(nama, email)
        call.enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                when(response.code()){
                    201->{
                        view.onSuccess(response.body()?.message)
                    }
                    else->{
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