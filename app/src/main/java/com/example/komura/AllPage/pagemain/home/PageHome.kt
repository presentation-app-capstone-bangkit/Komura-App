package com.example.komura.AllPage.pagemain.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.komura.AllPage.pagemain.home.componentHome.CardChatBot
import com.example.komura.AllPage.pagemain.home.componentHome.CardGesture
import com.example.komura.AllPage.pagemain.home.componentHome.CardStatikHome
import com.example.komura.AllPage.pagemain.home.componentHome.CardVoice

@Composable
fun PageHome() {
    Column (
        modifier = Modifier.fillMaxSize().padding(10.dp),
        content = {
            CardStatikHome()
            Spacer(modifier = Modifier.padding(5.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                content = {
                    Column (
                        content = {
                            CardVoice()
                            Spacer(modifier = Modifier.padding(5.dp))
                            CardChatBot()
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Column (
                        content = {
                            CardGesture()
                        }
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PageHomePrev() {
    PageHome()
}