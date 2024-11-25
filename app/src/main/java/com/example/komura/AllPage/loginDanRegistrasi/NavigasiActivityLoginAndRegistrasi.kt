package com.example.komura.AllPage.loginDanRegistrasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.komura.AllPage.loginDanRegistrasi.login.PageLogin
import com.example.komura.AllPage.loginDanRegistrasi.registrasi.PageRegistrasi
import com.example.komura.AllPage.loginDanRegistrasi.terminalLoginAndRegister.TerminalLoginAndRegister
import com.example.komura.ui.theme.KomuraTheme

class NavigasiActivityLoginAndRegistrasi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            KomuraTheme {
                NavHost(
                    navController = navController,
                    startDestination = "TerminalLoginAndRegister"
                ) {
                    composable("TerminalLoginAndRegister") {
                        TerminalLoginAndRegister(navController = navController)
                    }
                    composable("Login") {
                        PageLogin()
                    }
                    composable("Registrasi") {
                        PageRegistrasi(navController = navController)
                    }
                }
            }
        }
    }
}
