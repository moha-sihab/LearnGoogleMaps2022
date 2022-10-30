package com.sihabudin.learngooglemaps2022.widget

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sihabudin.learngooglemaps2022.databinding.DialogInfoBinding

class GeneralInfo(val context: Context) {
    private val binding = DialogInfoBinding.inflate(LayoutInflater.from(context))
    fun setUp(
        messageText: String,
        callback: (AppCompatButton, AlertDialog) -> Unit,
    ) {
        binding.apply {
            tvMessage.text = messageText
            val dialog = MaterialAlertDialogBuilder(context)
                .setView(binding.root)
                .setCancelable(false)
                .show()
            callback(btnUnderstand, dialog)
        }
    }
}