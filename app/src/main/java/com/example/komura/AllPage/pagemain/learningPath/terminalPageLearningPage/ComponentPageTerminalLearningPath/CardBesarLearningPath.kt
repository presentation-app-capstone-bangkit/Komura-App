package com.example.komura.AllPage.pagemain.learningPath.terminalPageLearningPage.ComponentPageTerminalLearningPath

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.komura.R

@Composable
fun CardBesarLearningPath(
    painter: Painter,
    title: String,
    onClick: () -> Unit = {}
) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(234.dp).clickable {
                onClick()
            },
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(width = 1.dp, color = Color(0xffd1d1d1)),
        content = {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Text(
                text = title,
                modifier = Modifier.padding(start = 10.dp, top = 15.dp),
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )
        }
    )
}

@Preview
@Composable
private fun CardBesarLearningPathPrev() {
    CardBesarLearningPath(
        painter = painterResource(R.drawable.image30),
        title = "Why Do We Use Vocal Filler ?"
    )
}