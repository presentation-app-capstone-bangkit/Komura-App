package com.example.komura.menyalaBase

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore

object AuthRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    @SuppressLint("StaticFieldLeak")
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

//    fun register(
//        name: String,
//        email: String,
//        password: String,
//        onSuccess: () -> Unit,
//        onError: (String) -> Unit
//    ) {
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            onError("Format email tidak valid.")
//            return
//        }
//
//        if (password.length < 6) {
//            onError("Password terlalu pendek. Minimal 6 karakter.")
//            return
//        }
//
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    val userId = auth.currentUser?.uid
//                    if (userId != null) {
//                        val userData = hashMapOf(
//                            "email" to email,
//                            "userName" to name
//                        )
//
//                        firestore.collection("users").document(userId)
//                            .set(userData)
//                            .addOnSuccessListener {
//                                onSuccess()
//                            }
//                            .addOnFailureListener { e ->
//                                onError("Gagal menyimpan data pengguna: ${e.message}")
//                            }
//                    } else {
//                        onError("Registrasi gagal. User ID tidak ditemukan.")
//                    }
//                } else {
//                    val exception = task.exception
//                    val errorMessage = when (exception) {
//                        is FirebaseAuthUserCollisionException -> "Email sudah terdaftar. Silakan gunakan email lain."
//                        is FirebaseAuthWeakPasswordException -> "Password terlalu lemah. Silakan gunakan kombinasi yang lebih kuat."
//                        else -> exception?.message ?: "Registrasi gagal. Silakan coba lagi."
//                    }
//                    onError(errorMessage)
//                }
//            }
//    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Login", "Login berhasil")

                    onSuccess()
                } else {
                    val exception = task.exception
                    val errorMessage = when (exception) {
                        is FirebaseAuthInvalidCredentialsException -> "Password salah. Silakan coba lagi."
                        is FirebaseAuthInvalidUserException -> "Email tidak terdaftar."
                        else -> exception?.message ?: "Login gagal. Silakan coba lagi nanti."
                    }
                    onError(errorMessage)
                }
            }
    }

    fun logout(onSuccess: () -> Unit, onError: (String) -> Unit) {
        try {
            auth.signOut()
            onSuccess()
        } catch (e: Exception) {
            onError("Terjadi kesalahan saat logout: ${e.message}")
        }
    }
}