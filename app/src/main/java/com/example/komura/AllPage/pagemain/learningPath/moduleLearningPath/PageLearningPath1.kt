package com.example.komura.AllPage.pagemain.learningPath.moduleLearningPath

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.komura.AllPage.pagemain.MainActivity
import com.example.komura.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageLearningPath1(navController: NavController) {
    val createContext = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color(0xff005e90),
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clickable {
                                val intent = (createContext as? android.app.Activity)
                                intent?.finish()
                            }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .verticalScroll(state = rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Column(
                        modifier = Modifier
                            .width(380.dp)
                            .background(Color.White),

                        content = {
                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = "Why Do We Use Vocal Filler ?",
                                color = Color(0xff005e90)
                            )
                            Image(
                                painter = painterResource(R.drawable.img_why),
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillWidth
                            )
                            Text(
                                text = "Vocal fillers, or vocal disfluencies, are a break in fluid conversation. You might find yourself using filler words for a number of reasons:\n" +
                                        "  - Nervousness\n" +
                                        "  - Being unfocussed or distracted\n" +
                                        "  - When using unfamiliar concepts or words\n" +
                                        "  - If you’re talking too quickly.\n" +
                                        "\n" +
                                        "Your brain works in retrieval mode and offers out ums or ahs to fill the time until you regulate yourself or are able to retrieve the concepts and find that ‘just right’ word you’re trying to remember.\n" +
                                        "\n" +
                                        "Fillers are verbal crutches that give your brain an opportunity to gather your thoughts and get back on track.",
                                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                            )

                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = "Examples of Common Filler Words",
                                color = Color(0xff005e90)
                            )
                            Row(
                                content = {
                                    Text(
                                        text = "We’ve all heard them. We all \n" +
                                                "  - use them.\n" +
                                                "  - Um\n" +
                                                "  - Ah\n" +
                                                "  - Like\n" +
                                                "  - So\n" +
                                                "  - You know\n" +
                                                "  - Sorry\n" +
                                                "  - Actually\n" +
                                                "  - Okay\n" +
                                                "  - Right?\n" +
                                                "  - I mean.",
                                        modifier = Modifier.padding(start = 20.dp)
                                    )
                                    Image(
                                        painter = painterResource(R.drawable.img_filler),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 10.dp, top = 20.dp),
                                        contentScale = ContentScale.FillWidth
                                    )
                                }
                            )

                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = "When Is Using a Filler Word or Two Not a Problem?",
                                color = Color(0xff005e90)
                            )
                            Image(
                                painter = painterResource(R.drawable.img_book),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Text(
                                text = "Vocal dysfluency is not a problem when it’s infrequent and happens as often as it would in the natural rhythm of relaxed conversation.\n" +
                                        "\n" +
                                        "We expect to hear vocal fillers and would find it odd to not hear or use them in day-to-day conversation.\n" +
                                        "\n" +
                                        "There are very few people who are able to communicate without incorporating a few ums or ahhs.",
                                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                            )

                            Text(
                                modifier = Modifier.padding(10.dp),
                                text = "When Do Filler Words Become Problematic?",
                                color = Color(0xff005e90)
                            )
                            Image(
                                painter = painterResource(R.drawable.ing_kumpulan),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                contentScale = ContentScale.FillWidth
                            )
                            Text(
                                text = "Filler words only become a problem when they are used excessively, because overuse can make you appear unprepared and/or unrehearsed. Your credibility will suffer when you stall and try to articulate words that don’t flow easily off of your tongue.\n" +
                                        "\n" +
                                        "To be confident in your words, and how you deliver them, you have to be polished and at ease.\n" +
                                        "\n" +
                                        "Here are 10 tips to help you stop overusing vocal fillers. These are especially helpful if you’re practicing for an upcoming public speaking event.",
                                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                            )
                            Spacer(modifier = Modifier.padding(100.dp))
                        }
                    )
                }
            )
        }
    )
}

@Preview(device = Devices.TABLET)
@Composable
private fun PageLearningPath1Prev() {
    PageLearningPath1(rememberNavController())
}

@Preview()
@Composable
private fun PageLearningPath1PrevPhone() {
    PageLearningPath1(rememberNavController())
}