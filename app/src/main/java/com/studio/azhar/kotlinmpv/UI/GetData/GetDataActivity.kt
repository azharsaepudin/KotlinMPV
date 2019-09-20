package com.studio.azhar.kotlinmpv.UI.GetData

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.studio.azhar.kotlinmpv.Adapters.AdapterListMahasiswa
import com.studio.azhar.kotlinmpv.Base.BaseActivity
import com.studio.azhar.kotlinmpv.Model.ModelMahasiswa
import com.studio.azhar.kotlinmpv.R
import com.studio.azhar.kotlinmpv.UI.DeleteData.DeleteDataActivity
import com.studio.azhar.kotlinmpv.UI.InputData.InputDataActivity
import com.studio.azhar.kotlinmpv.UI.UpdateData.UpdateDataActivity
import kotlinx.android.synthetic.main.activity_get_data.*
import org.jetbrains.anko.startActivity
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menu_Update -> {
                val intent = Intent(this, UpdateDataActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_Delete -> {
                val intent = Intent(this, DeleteDataActivity::class.java)
                startActivity(intent)
                true
            }

            R.id.menu_Input->{
                val intent = Intent(this, InputDataActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
