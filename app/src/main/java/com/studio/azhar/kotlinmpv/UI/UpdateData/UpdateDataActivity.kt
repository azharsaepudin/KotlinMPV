package com.studio.azhar.kotlinmpv.UI.UpdateData

import com.studio.azhar.kotlinmpv.Base.BaseActivity
import com.studio.azhar.kotlinmpv.R
import com.studio.azhar.kotlinmpv.Util.DialogLoading
import kotlinx.android.synthetic.main.activity_update_data.*
import kotlinx.android.synthetic.main.activity_update_data.edt_Nama
import org.jetbrains.anko.longToast

class UpdateDataActivity : BaseActivity(), UpdateDataView {


    private lateinit var updateDataPresenter: UpdateDataPresenter
    private lateinit var alertDialog: android.app.AlertDialog

    override fun contentView(): Int {
        return R.layout.activity_update_data
    }

    override fun onCreated() {
        updateDataPresenter = UpdateDataPresenter(this)
        alertDialog = DialogLoading.getDialog(this)

        btn_Update.setOnClickListener {
            update()
        }

    }

    private fun update(){
        val id = edt_Id.text.toString()
        val nama = edt_Nama.text.toString()

        updateDataPresenter.updateData(id,nama)
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
