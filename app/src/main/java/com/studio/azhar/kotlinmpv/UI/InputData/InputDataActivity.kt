package com.studio.azhar.kotlinmpv.UI.InputData

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.studio.azhar.kotlinmpv.Base.BaseActivity
import com.studio.azhar.kotlinmpv.R
import com.studio.azhar.kotlinmpv.Util.DialogLoading
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast

class InputDataActivity : BaseActivity(), InputDataView {


    private lateinit var inputDataPresenter: InputDataPresenter
    private lateinit var alertDialog: android.app.AlertDialog

    override fun contentView(): Int {
    return R.layout.activity_main
    }

    override fun onCreated() {
       inputDataPresenter = InputDataPresenter(this)
        alertDialog = DialogLoading.getDialog(this)

       btn_Input.setOnClickListener {
           inputData()
       }
    }


    private fun inputData(){
        val nama = edt_Nama.text
        val email = edt_Email.text

        inputDataPresenter.inputData(nama.toString(), email.toString())

        Toast.makeText(this, "hai", Toast.LENGTH_LONG).show()
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
