package com.example.komura.AllPage.loginDanRegistrasi.terminalLoginAndRegister

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.komura.R

@Composable
fun TerminalLoginAndRegister(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.TopCenter,
        content = {
            Image(
                painter = painterResource(R.drawable.bgaipresentasi),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(650.dp).offset(y = -50.dp)
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Spacer(modifier = Modifier.height(110.dp))
                    Image(
                        painter = painterResource(R.drawable.aipresent),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.height(300.dp).fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(130.dp))
                    Text(
                        text = "Elevate Your Confidance on\nPublic Speaking",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Boost your confidence with Komura your\npersonal speech coach! It analyzes your\nfiller words, articulation, and speed,\ngiving you instant feedback to help you\nspeak more clearly and confidently.",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Row (
                        content = {
                            Button(
                                onClick = {
                                    navController.navigate("Registrasi")
                                },
                                content = {
                                    Text(text = "Register")
                                },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.width(140.dp).height(50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff00a6ff)
                                )
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            OutlinedButton(
                                onClick = {
                                    navController.navigate("Login")
                                },
                                content = { Text(text = "Sing in") },
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.width(140.dp).height(50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color(0xff00a6ff),
                                    containerColor = Color.White
                                ),
                                border = BorderStroke(1.dp, Color(0xff00a6ff))
                            )
                        }
                    )

                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun TerminalLoginAndRegisterPrev() {
    TerminalLoginAndRegister(rememberNavController())
}