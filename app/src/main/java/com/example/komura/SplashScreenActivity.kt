package com.example.komura

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.komura.AllPage.loginDanRegistrasi.NavigasiActivityLoginAndRegistrasi
import com.example.komura.AllPage.pagemain.MainActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaunchedEffect(Unit) {
                val isUserLoggedIn = FirebaseAuth.getInstance().currentUser != null
                Log.e("User Status", if (isUserLoggedIn) "Logged In" else "Not Logged In")
                delay(3000)

                val targetActivity = if (isUserLoggedIn) MainActivity::class.java
                else NavigasiActivityLoginAndRegistrasi::class.java

                startActivity(Intent(this@SplashScreenActivity, targetActivity))
                finish()
            }

            ConstraintLayout(
                content = {
                    val (logo, text) = createRefs()
                    Image(
                        painter = painterResource(id = R.drawable.splashscreen),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize()
                    )
                    Image(
                        painter = painterResource(R.drawable.logokomura),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(100.dp)
                            .constrainAs(
                                ref = logo,
                                constrainBlock = {
                                    top.linkTo(parent.top)
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }
                            )
                    )
                    Image(
                        painter = painterResource(R.drawable.crtkomura),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(30.dp)
                            .fillMaxWidth()
                            .height(10.dp)
                            .constrainAs(
                                ref = text,
                                constrainBlock = {
                                    bottom.linkTo(parent.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }
                            )
                    )
                }
            )
        }
    }
}