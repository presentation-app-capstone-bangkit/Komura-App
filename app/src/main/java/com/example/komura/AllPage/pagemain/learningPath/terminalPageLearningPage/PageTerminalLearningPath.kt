package com.example.komura.AllPage.pagemain.learningPath.terminalPageLearningPage

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.komura.AllPage.pageSupport.ActivityLearningPath1
import com.example.komura.AllPage.pageSupport.ActivityLearningPath2
import com.example.komura.AllPage.pagemain.learningPath.terminalPageLearningPage.ComponentPageTerminalLearningPath.CardBesarLearningPath
import com.example.komura.R

@Composable
fun PageTerminalLearningPath(navController: NavController) {
    val createContext = LocalContext.current
    Column(
        content = {
            Spacer(modifier = Modifier.padding(10.dp))
            CardBesarLearningPath(
                painter = painterResource(R.drawable.image30),
                title = "Why Do We Use Vocal Filler ?",
                onClick = {
                    val intent = Intent(createContext, ActivityLearningPath1::class.java)
                    createContext.startActivity(intent)
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            CardBesarLearningPath(
                painter = painterResource(R.drawable.image31),
                title = "Ten Tips to Stop Using Vocal Fillers",
                onClick = {
                    val intent = Intent(createContext, ActivityLearningPath2::class.java)
                    createContext.startActivity(intent)
                }
            )
        }
    )
}


@Preview
@Composable
private fun PageTerminalLearningPathPrev() {
    PageTerminalLearningPath(rememberNavController())

}