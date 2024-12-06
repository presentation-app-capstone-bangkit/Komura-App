package com.example.komura.AllPage.loginDanRegistrasi.login

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.komura.AllPage.pagemain.MainActivity
import com.example.komura.R
import com.example.komura.menyalaBase.AuthRepository.login

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageLogin(onBack: () -> Unit, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    val createContext = LocalContext.current

    BackHandler {
        navController.navigate("TerminalLoginAndRegister") {
            popUpTo("Login") { inclusive = true } // Bersihkan stack navigasi
        }
    }

    fun validateEmail(value: String) {
        email = value
        emailError = when {
            value.isBlank() -> "Email is required"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches() -> "Invalid email format"
            else -> null
        }
    }

    fun validatePassword(value: String) {
        password = value
        passwordError = when {
            value.isBlank() -> "Password is required"
            value.length < 8 -> "Password must be at least 8 characters"
            else -> null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome Back",
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium
        )
        Row(
            content = {
                Text(
                    text = "Don`t have an account? ",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = "Sign Up",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xff0051ff),
                    modifier = Modifier.clickable {

                    }
                )
            }
        )
        Spacer(modifier = Modifier.height(40.dp))

        Column {
            TextField(
                value = email,
                onValueChange = { validateEmail(it) },
                placeholder = { Text(text = "Email Address") },
                isError = emailError != null,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    containerColor = Color(0xffe6e6e6)
                ),
                modifier = Modifier.width(400.dp),
                shape = RoundedCornerShape(10.dp)
            )
            emailError?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = password,
                onValueChange = { validatePassword(it) },
                placeholder = { Text(text = "Password") },
                isError = passwordError != null,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        R.drawable.show_password
                    else R.drawable.hide_password

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(image),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    containerColor = Color(0xffe6e6e6)
                ),
                modifier = Modifier.width(400.dp),
                shape = RoundedCornerShape(10.dp)
            )
            passwordError?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(400.dp),
            onClick = {
                validateEmail(email)
                validatePassword(password)

                if (emailError == null && passwordError == null) {
                    isLoading = true

                    login(
                        email = email,
                        password = password,
                        onSuccess = {
                            isLoading = false
                            val intent = Intent(createContext, MainActivity::class.java)
                            createContext.startActivity(intent)
                            onBack()
                        },
                        onError = { error ->
                            isLoading = false
                            emailError = error
                        }
                    )
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff00a6ff))
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            } else {
                Text(text = "Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PageLoginPrev() {
    PageLogin(onBack = {}, rememberNavController())
}







