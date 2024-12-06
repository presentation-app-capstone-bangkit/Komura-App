package com.example.komura.AllPage.pagemain.setting

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun LogoutDialog(
    showDialog: Boolean,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Konfirmasi Logout")
            },
            text = {
                Text(text = "Apakah kamu yakin ingin Log Out?")
            },
            confirmButton = {
                Button(onClick = onConfirm) {
                    Text("Ya")
                }
            },
            dismissButton = {
                Button(onClick = onDismiss) {
                    Text("Batal")
                }
            }
        )
    }
}