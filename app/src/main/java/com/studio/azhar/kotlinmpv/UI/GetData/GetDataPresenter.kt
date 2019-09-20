package com.studio.azhar.kotlinmpv.UI.GetData

import com.studio.azhar.kotlinmpv.API.ApiConfig
import com.studio.azhar.kotlinmpv.API.ApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetDataPresenter(private val view: GetDataView) {
    fun getData(){
        view.showLoading()

        val config = ApiConfig.config()
        val call = config.getData()
        call.enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                when(response.code()){
                    200->{
                        val dataMhs = response.body()?.dataMhs

                        if (dataMhs.isNullOrEmpty()){
                            view.onEmpty()
                        }else{
                            view.onSuccess(dataMhs)
                        }
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