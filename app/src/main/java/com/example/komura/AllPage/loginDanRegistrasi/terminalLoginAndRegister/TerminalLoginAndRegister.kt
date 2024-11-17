package com.example.komura.AllPage.loginDanRegistrasi.terminalLoginAndRegister

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.komura.R

@Composable
fun TerminalLoginAndRegister() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Spacer(modifier = Modifier.height(70.dp))
            Box(
                contentAlignment = Alignment.Center,
                content = {
                    Image(
                        painter = painterResource(R.drawable.circle),
                        contentDescription = null,
                        modifier = Modifier.size(270.dp)
                    )
                    Text(text = "LOGO/IMG", fontSize = 20.sp)
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "KOMURA", fontSize = 40.sp)
            Text(
                text = "This app boots confidance in public \nspeaking.",
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(50.dp))
            Button(
                modifier = Modifier
                    .width(310.dp)
                    .height(60.dp),
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                content = {
                    Text(
                        text = "Log-In",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffbfbfbf),
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier
                    .width(310.dp)
                    .height(60.dp),
                onClick = {},
                shape = RoundedCornerShape(10.dp),
                content = {
                    Text(
                        text = "Sing-Up",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Light
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffbdbdbd),
                )
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun TerminalLoginAndRegisterPrev() {
    TerminalLoginAndRegister()
}