package com.example.komura.AllPage.loginDanRegistrasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                NavHost(
                    navController = navController,
                    startDestination = "TerminalLoginAndRegister"
                ) {
                    composable("TerminalLoginAndRegister") {
                        TerminalLoginAndRegister(
                            navController = navController
                        )
                    }
                    composable("Login") {
                        PageLogin(onBack = {finish()}, navController = navController)
                    }
                    composable("Registrasi") {
                        PageRegistrasi(
                            navController = navController
                        )
                    }
                }
        }
    }
}
