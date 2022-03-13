package com.luthtan.projectui.base.util

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.luthtan.projectui.R

object AlertHelper {

    fun showAlert(context: Context, action: DialogInterface.OnClickListener): AlertDialog = MaterialAlertDialogBuilder(context, R.style.AlertDialogTheme)
            .setTitle("Delete Item")
            .setMessage("Are you sure to delete this item?")
            .setPositiveButton("Yes", action)
            .setNegativeButton("No") { p0, p1 -> p0.dismiss() }
            .show()
}