package com.studio.azhar.kotlinmpv.Base

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onFiled(message: String?)
    fun onError(message: String?)

}