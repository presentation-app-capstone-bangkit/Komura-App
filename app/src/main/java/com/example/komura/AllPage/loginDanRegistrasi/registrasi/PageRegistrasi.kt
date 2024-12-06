package com.example.komura.AllPage.loginDanRegistrasi.registrasi

import android.util.Log
import android.widget.Toast
import androidx.activity.compose.BackHandler
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.komura.R
import com.example.komura.api.ApiViewModel
import com.example.komura.api.RegisterState
import com.example.komura.menyalaBase.AuthRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageRegistrasi(navController: NavController) {
    val viewModel : ApiViewModel = viewModel()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val registerState = viewModel.registerState
    var nameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(registerState) {
        if (registerState is RegisterState.Success) {
            isLoading = false
            navController.navigate("login") {
                popUpTo("Registrasi") { inclusive = true }
            }
            Toast.makeText(context, registerState.message, Toast.LENGTH_SHORT).show()
        } else if (registerState is RegisterState.Error) {
            isLoading = false
            Toast.makeText(context, registerState.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    fun validateName(value: String) {
        name = value
        nameError = if (value.isBlank()) "Full Name is required" else null
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
            text = "Create an account",
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row {
            Text(text = "Already have an account? ", fontWeight = FontWeight.Light)
            Text(text = "Login", color = Color(0xff00a6ff), fontWeight = FontWeight.Light)
        }
        Spacer(modifier = Modifier.height(40.dp))

        Column(
            content = {
                TextField(
                    value = name,
                    onValueChange = { validateName(it) },
                    placeholder = { Text(text = "Full Name") },
                    isError = nameError != null,
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        containerColor = Color(0xffe6e6e6)
                    ),
                    modifier = Modifier
                        .width(400.dp),
                    shape = RoundedCornerShape(10.dp)
                )
                nameError?.let {
                    Text(text = it, color = Color.Red, fontSize = 12.sp, modifier = Modifier.padding(start = 8.dp))
                }

                Spacer(modifier = Modifier.height(20.dp))

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
                    Text(text = it, color = Color.Red, fontSize = 12.sp, modifier = Modifier.padding(start = 8.dp))
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
                    Text(text = it, color = Color.Red, fontSize = 12.sp, modifier = Modifier.padding(start = 8.dp))
                }
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(400.dp),
            onClick = {
                validateName(name)
                validateEmail(email)
                validatePassword(password)

                if (nameError == null && emailError == null && passwordError == null) {
                    isLoading = true
                    viewModel.registerUser(name, email, password)


//                    AuthRepository.register(
//                        name = name,
//                        email = email,
//                        password = password,
//                        onSuccess = {
//                            isLoading = false
//                            navController.navigate("login")
//                        },
//                        onError = { error ->
//                            isLoading = false
//                            emailError = error
//                        }
//                    )
                }
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff00a6ff))
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = Color.White
                )
            } else {
                Text(text = "Continue")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun PageRegistrasiPrev() {
    PageRegistrasi(rememberNavController())
}