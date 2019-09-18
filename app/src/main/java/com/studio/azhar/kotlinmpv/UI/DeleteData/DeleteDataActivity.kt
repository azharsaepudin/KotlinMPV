package com.studio.azhar.kotlinmpv.UI.DeleteData

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.studio.azhar.kotlinmpv.Base.BaseActivity
import com.studio.azhar.kotlinmpv.Base.BaseView
import com.studio.azhar.kotlinmpv.R
import com.studio.azhar.kotlinmpv.Util.DialogLoading
import kotlinx.android.synthetic.main.activity_delete.*
import org.jetbrains.anko.longToast

class DeleteDataActivity : BaseActivity(), DeleteDataView{



    private lateinit var deleteDataPresenter: DeleteDataPresenter
    private lateinit var alertDialog: android.app.AlertDialog

    override fun contentView(): Int {

        return R.layout.activity_delete
    }

    override fun onCreated() {
        deleteDataPresenter = DeleteDataPresenter(this)
        alertDialog = DialogLoading.getDialog(this)


        btn_Delete.setOnClickListener {
            deleteData()
        }
    }

    private fun deleteData(){
        val id = edt_Id.text.toString()

        deleteDataPresenter.deleteData(id)
    }

    override fun onSuccess(message: String?) {
        longToast(message.toString())
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onFiled(message: String?) {
        longToast(message.toString())
    }

    override fun onError(message: String?) {

    }
}
