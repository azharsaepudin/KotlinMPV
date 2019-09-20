package com.studio.azhar.kotlinmpv.UI.GetData

import com.studio.azhar.kotlinmpv.Base.BaseView
import com.studio.azhar.kotlinmpv.Model.ModelMahasiswa

interface GetDataView: BaseView {
    fun onSuccess(list: List<ModelMahasiswa>?)
    fun onEmpty()
}