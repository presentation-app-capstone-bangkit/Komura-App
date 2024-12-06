package com.example.komura.AllPage.pagemain.audioSpeech

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.komura.AllPage.pagemain.audioSpeech.ui.theme.KomuraTheme
import com.example.komura.api.ApiViewModel
import com.example.komura.api.RegisterState

class testActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KomuraTheme {
                RegisterScreen()
            }
        }
    }
}

@Composable
fun RegisterScreen(viewModel: ApiViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val registerState = viewModel.registerState

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(value = username, onValueChange = { username = it }, label = { Text("Username") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())

        Button(onClick = {
            viewModel.registerUser(username, email, password)
        }) {
            Text("Register")
        }

        when (registerState) {
            is RegisterState.Success -> {
                Toast.makeText(context, registerState.message, Toast.LENGTH_SHORT).show()
                Log.d("RegisterScreen", "Registration Successful: ${registerState.message}")
            }
            is RegisterState.Error -> {
                Toast.makeText(context, registerState.errorMessage, Toast.LENGTH_SHORT).show()
                Log.e("RegisterScreen", "Registration Error: ${registerState.errorMessage}")
            }
            null -> {}
        }
    }
}