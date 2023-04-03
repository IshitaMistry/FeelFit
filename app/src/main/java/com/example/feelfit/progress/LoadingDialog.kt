package com.example.feelfit.progress

import android.app.AlertDialog
import com.example.feelfit.Credentials.Login
import com.example.feelfit.R

class LoadingDialog(val login: Login) {
    private lateinit var isDialog: AlertDialog
    fun startLoading(){
//        setView()
        val inflater = login.layoutInflater
        val dialogView = inflater.inflate(R.layout.loading_item,null)
//        setDialog()
        val builder = AlertDialog.Builder(login)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isDialog = builder.create()
        isDialog.show()
    }
    fun isDismiss(){
        isDialog.dismiss()
    }
}