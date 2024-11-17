package com.example.komura.AllPage.loginDanRegistrasi.registrasi.ComponentRegistrasi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardRegistrasi(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password1 by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }

    Card(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                )
            )
            .fillMaxSize(),
        content = {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {

                    Text(
                        text = "Register",
                        fontSize = 30.sp
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Column(
                        modifier = Modifier.width(500.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {

                            CustomRegistrasiTextField(
                                value = name,
                                onValueChange = { newName ->
                                    name = newName
                                },
                                label = "Name",
                                placeholder = "Your Name",
                                modifier = Modifier.width(300.dp)
                            )

                            CustomRegistrasiTextField(
                                value = email,
                                onValueChange = { newEmail ->
                                    email = newEmail
                                },
                                label = "Email",
                                placeholder = "ExempleEmail@gmail.com",
                                modifier = Modifier.width(300.dp)
                            )

                            CustomRegistrasiPasswordTextField(
                                value = password1,
                                onValueChange = { newPassword1 ->
                                    password1 = newPassword1
                                },
                                label = "Password",
                                placeholder = "Input Your Password",
                                modifier = Modifier.width(300.dp)
                            )

                            CustomRegistrasiPasswordTextField(
                                value = password2,
                                onValueChange = { newPassword2 ->
                                    password2 = newPassword2
                                },
                                label = "Confirm Password",
                                placeholder = "Enter your password",
                                modifier = Modifier.width(300.dp)
                            )

                        }
                    )
                    Spacer(modifier = Modifier.height(90.dp))


                    Button(
                        modifier = Modifier
                            .width(310.dp)
                            .height(60.dp),
                        onClick = {},
                        shape = RoundedCornerShape(10.dp),
                        content = { Text(text = "Create Account", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Light) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff757575),
                        )
                    )
                }
            )
        },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFC5C5C5)
        )
    )
}

@Preview(showBackground = false)
@Composable
private fun CardRegistrasiPreview() {
    CardRegistrasi()
}