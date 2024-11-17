package com.example.komura.AllPage.pagemain.home.componentHome

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardStatikHome() {
    Card (
        modifier = Modifier.fillMaxWidth().height(300.dp),
        content = {

        },
        colors = CardDefaults.cardColors(
            Color(0xffb8b8b8)
        )
    )
}

@Preview
@Composable
private fun CardStatikHomePrev() {
    CardStatikHome()
}