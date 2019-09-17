package com.studio.azhar.kotlinmpv.Util

import android.app.AlertDialog
import android.content.Context
import com.studio.azhar.kotlinmpv.R
import dmax.dialog.SpotsDialog

class DialogLoading {
    companion object{

        private lateinit var dialog: AlertDialog

        fun getDialog(context: Context?): AlertDialog{
            dialog = SpotsDialog.Builder()
                .setContext(context)
                .setMessage("Mohon tunggu")
                .setTheme(R.style.Custom)
                .setCancelable(false)
                .build()

            return dialog
        }
    }
}