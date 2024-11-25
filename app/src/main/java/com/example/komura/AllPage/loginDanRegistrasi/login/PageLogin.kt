package com.example.komura.AllPage.loginDanRegistrasi.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.komura.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageLogin() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                text = "Welcome back",
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                content = {
                    Text(
                        text = " Don`t have an account ",
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = "Sign Up",
                        color = Color(0xff00a6ff),
                        fontWeight = FontWeight.Light
                    )
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier.height(170.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                content = {
                    TextField(
                        value = email,
                        onValueChange = { newEmail ->
                            email = newEmail
                        },
                        placeholder = { Text(text = "Email Address") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions.Default,
                        singleLine = true,
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

                    TextField(
                        value = password,
                        onValueChange = { newPass ->
                            password = newPass
                        },
                        placeholder = { Text(text = "Password") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions.Default,
                        singleLine = true,
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
                    Text(
                        text = "Recovery Password",
                        textAlign = TextAlign.End,
                        color = Color.Gray,
                        modifier = Modifier.width(400.dp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                modifier = Modifier
                    .height(60.dp)
                    .width(400.dp),
                onClick = {  },
                content = {
                    Text(text = "Login")
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff00a6ff)
                )
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PageLoginPrev() {
    PageLogin()
}







