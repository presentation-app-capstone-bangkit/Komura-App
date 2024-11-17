package com.example.komura.AllPage.loginDanRegistrasi.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.komura.AllPage.loginDanRegistrasi.registrasi.ComponentRegistrasi.CardLogin
import com.example.komura.R

@Composable
fun PageLogin() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        content = {
            val (cardRegistrasi, row) = createRefs()
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(row) {
                        top.linkTo(parent.top)
                    }
                   .height(250.dp),
                content = {
                    val (text, logo) = createRefs()
                    Column(
                        modifier = Modifier
                            .constrainAs(text) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                            .offset(y = (-10).dp, x = (-100).dp),
                        content = {
                            Text(text = "KOMURA", fontSize = 28.sp)
                            Text(
                                text = "This app boots \nconfidance in public \nspeaking.",
                                fontWeight = FontWeight.Light
                            )
                        }
                    )

                    Box(
                        modifier = Modifier
                            .offset(x = 60.dp, y = 15.dp)
                            .size(250.dp)
                            .constrainAs(logo) {
                                end.linkTo(parent.end)
                            },
                        contentAlignment = Alignment.Center,
                        content = {
                            Icon(
                                painter = painterResource(R.drawable.circle),
                                contentDescription = null,
                                tint = Color(0xff9a9a9a),
                                modifier = Modifier
                                    .size(250.dp)
                            )
                            Text(text = "LOGO/IMG")
                        }
                    )

                }
            )
            CardLogin(
                modifier = Modifier
                    .height(650.dp)
                    .constrainAs(cardRegistrasi) {
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PageLoginPrev() {
    PageLogin()
}







