package com.example.komura.AllPage.pagemain.setting

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.komura.AllPage.loginDanRegistrasi.NavigasiActivityLoginAndRegistrasi
import com.example.komura.menyalaBase.AuthRepository.logout

@Composable
fun MoreVertMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    val createContext = LocalContext.current
    var showLogoutDialog by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = !expanded }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More Options"
        )
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        content = {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                },
                text = {
                    Text("Change Password")
                }
            )
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    showLogoutDialog = true
                },
                text = {
                    Text("Log Out")
                }
            )
        }
    )


    if (showLogoutDialog) {
        LogoutDialog(
            showDialog = showLogoutDialog,
            onConfirm = {
                logout(
                    onSuccess = {
                        val intent = Intent(createContext, NavigasiActivityLoginAndRegistrasi::class.java)
                        createContext.startActivity(intent)
                        Log.d("Auth", "Logout berhasil")
                        (createContext as? Activity)?.finishAffinity()
                    },
                    onError = { errorMessage ->
                        Log.e("Auth", errorMessage)
                    }
                )
                showLogoutDialog = false
            },
            onDismiss = {
                showLogoutDialog = false
            }
        )
    }
}