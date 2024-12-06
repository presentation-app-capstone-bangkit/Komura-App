package com.example.komura.AllPage.pagemain.setting

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.komura.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageSetting(finish: () -> Unit) {
//    val currentUser = FirebaseAuth.getInstance().currentUser
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("MartinKelvin@gmail.com") }
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()

//    Log.e("get username:",currentUser.toString())
//    Log.e("get username:",currentUser?.uid.toString())
//    Log.e("get username:",currentUser?.displayName.toString())


    LaunchedEffect(Unit) {
        val userId = auth.currentUser?.uid
        if (userId != null) {
            db.collection("users").document(userId).get()
                .addOnSuccessListener { document ->
                    nama = document.getString("username") ?: "Username tidak ditemukan"
                    email = document.getString("email") ?: "Email tidak ditemukan"
                }
                .addOnFailureListener {
                    nama = "Gagal memuat username"
                    email = "Gagal memuat email"
                }
        } else {
            nama = "User belum login"
            email = "User belum login"
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton (
                        onClick = {
                            finish()
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(R.drawable.pencil_edit),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {

                            }
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    MoreVertMenuExample()
                }
            )
        },
        content = {

            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(40.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Image(
                        painter = painterResource(R.drawable.martin3),
                        contentDescription = null,
                        modifier = Modifier
                            .size(200.dp)
                            .shadow(
                                elevation = 10.dp,
                                ambientColor = Color(0xff00a6ff),
                                spotColor = Color(0xff00a6ff),
                                shape = CircleShape
                            )
                    )
                    Text(
                        text = "Edit Profile",
                        fontSize = 25.sp,
                        modifier = Modifier.padding(top = 40.dp, bottom = 20.dp)
                    )
                    Column(
                        content = {
                            Text(
                                text = "Your Name",
                                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                            )
                            TextField(
                                value = nama,
                                onValueChange = { newNama ->
                                    nama = newNama
                                },
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
                        }
                    )
                    Column(
                        content = {
                            Text(
                                text = "Your Email",
                                modifier = Modifier.padding(top = 10.dp, bottom = 5.dp)
                            )
                            TextField(
                                value = email,
                                onValueChange = { newEmail ->
                                    email = newEmail
                                },
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
                        }
                    )
                    Spacer(modifier = Modifier.height(60.dp))
                    Button(
                        onClick = {},
                        content = {
                            Text(text = "Change")
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff00a6ff)
                        )
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PageSettingPrev() {
    PageSetting(finish = {})
}