package com.studio.azhar.kotlinmpv.UI.GetData

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.studio.azhar.kotlinmpv.Adapters.AdapterListMahasiswa
import com.studio.azhar.kotlinmpv.Base.BaseActivity
import com.studio.azhar.kotlinmpv.Model.ModelMahasiswa
import com.studio.azhar.kotlinmpv.R
import kotlinx.android.synthetic.main.activity_get_data.*
import org.jetbrains.anko.toast

class GetDataActivity : BaseActivity(), GetDataView {


    private lateinit var getDataPresenter: GetDataPresenter
    private var lisMahasiswa: MutableList<ModelMahasiswa> = mutableListOf()
    private lateinit var adapterListMahasiswa: AdapterListMahasiswa

    override fun contentView(): Int {
        return R.layout.activity_get_data
    }

    override fun onCreated() {
    getDataPresenter = GetDataPresenter(this)


        loadData()
    }

    private fun loadData(){
        getDataPresenter.getData()

        adapterListMahasiswa = AdapterListMahasiswa(this, lisMahasiswa){

        }


        rv_Getmhs.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_Getmhs.adapter = adapterListMahasiswa

    }

    override fun onSuccess(list: List<ModelMahasiswa>?) {
        lisMahasiswa.clear()
        list?.let {
            lisMahasiswa.addAll(it)
        }
        adapterListMahasiswa.notifyDataSetChanged()
    }
    override fun onEmpty() {
       toast("onEmpty")
    }
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onFiled(message: String?) {

    }

    override fun onError(message: String?) {

    }


}
