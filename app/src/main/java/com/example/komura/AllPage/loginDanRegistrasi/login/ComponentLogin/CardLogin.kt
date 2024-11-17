package com.example.komura.AllPage.loginDanRegistrasi.registrasi.ComponentRegistrasi

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.komura.R

@Composable
fun CardLogin(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password1 by remember { mutableStateOf("") }

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
                    .fillMaxSize()
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {

                    Text(
                        text = "Log-In",
                        fontSize = 30.sp
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Column(
                        modifier = Modifier.width(500.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        content = {

                            CustomLoginTextField(
                                value = email,
                                onValueChange = { newEmail ->
                                    email = newEmail
                                },
                                label = "Email",
                                placeholder = "ExempleEmail@gmail.com",
                                modifier = Modifier.width(300.dp)
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            CustomLoginPasswordTextField(
                                value = password1,
                                onValueChange = { newPassword1 ->
                                    password1 = newPassword1
                                },
                                label = "Password",
                                placeholder = "Input Your Password",
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
                        content = {
                            Text(
                                text = "PROCEED",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff757575),
                        )
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    Text(
                        text = "Or Log-in With",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light
                    )
                    Spacer(modifier = Modifier.height(50.dp))

                    Row(
                        content = {
                            Image(
                                painter = painterResource(R.drawable.logogoogle),
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Image(
                                painter = painterResource(R.drawable.logofacebook),
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            Image(
                                painter = painterResource(R.drawable.logotritter),
                                contentDescription = null,
                                modifier = Modifier.size(60.dp)
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        content = {
                            Text(text = "Newbie? ", fontWeight = FontWeight.Light)
                            Text(text = "Create Account", color = Color(0xff004dff), fontWeight = FontWeight.Light)
                        }
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
private fun CardLoginPreview() {
    CardLogin()
}