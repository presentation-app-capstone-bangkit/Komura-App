package com.example.komura.AllPage.pagemain.learningPath.moduleLearningPath

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageLearningPath2() {
    val createContext = LocalContext.current
    Scaffold (
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color(0xff005e90),
                        modifier = Modifier
                            .clickable {
                                val intent = (createContext as? android.app.Activity)
                                intent?.finish()
                            }
                            .padding(start = 10.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        content = {
            Column (
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
                               text = "Ten Tips to Stop Using Vocal Fillers",
                               color = Color(0xff005e90),
                               fontSize = 16.sp,
                           )
                           Spacer(modifier = Modifier.padding(10.dp))
                           ParagrafLP2(
                               title = "1. Be Patient",
                               desc = "Be patient and forgiving with yourself. Eliminating vocal fillers entirely is unachievable—and not even desirable. Expect that you will still use a few filler words in your speech. If you are someone who relies on crutch words and filler wounds a lot, consider your objective to be to eradicate the majority of them, not to completely obliterate them."
                           )
                           ParagrafLP2(
                               title = "2. Awareness",
                               desc = "If you have trouble separating your ego from critique, creating a space for self awareness can be challenging. However, it’s worth it. Really and truly seeing yourself and how you communicate requires putting on an analyst’s hat and looking at your own communication habits objectively.\n" +
                                       "Often we are so hard on ourselves that all we see is the mistakes. Take the time to see both what you did well – where the cadence of your words moves fluidly (and you know will inspire your audience) and where you need improvement – where you stumbled and used ums and ahhs."
                           )
                           ParagrafLP2(
                               title = "3. Focus on Your Audience",
                               desc = "o understand your audience you have to listen…really listen.\n" +
                                       "Strategically create your messaging, understanding what will help influence/persuade your audience because thinking solely focussed on yourself leads to presentation nerves and anxiety and gives the ums and ahhs an opportunity to take hold.\n" +
                                       "When you focus on the needs of your audience and deliver a message to be of service, it will take the pressure off of you and stop your use of vocal fillers in its tracks."
                           )
                           ParagrafLP2(
                               title = "4. Rehearse",
                               desc = "I’ve never had a client circle back after a speech or presentation telling me they wished they had practiced less.\n" +
                                       "Knowing what you’re about to say next reduces vocal fillers. Enlist a colleague or professional and rehearse your presentation or speech so they can provide real time feedback. With caution though.\n" +
                                       "Ensure that those you ask to help you have the experience to provide valuable feedback."
                           )
                           ParagrafLP2(
                               title = "5. Audio or Video Recordings",
                               desc = "Listen to an audio or video recording of yourself to identify when you tend to overuse vocal fillers. Try to get to the bottom of your own habits. Where my clients often get stuck is not in the recording of themselves but actually watching or listening to the recording. This is where you need to humbly and objectively step back to gain valuable insight.\n" +
                                       "Loom is a terrific software tool to record your practices. It’s an easy software to learn that provides an area for comments. My clients first critique their recordings using the Loom platform and then send the recording to me for my feedback.\n" +
                                       "Watching and listening to a recording of yourself provides insight that practicing in the theatre of your mind can’t.\n" +
                                       "Now that you’ve identified where you’re using too many filler words (by analyzing your recorded practices) you’ve built some awareness of where you’re getting tripped up. With this awareness and when you arrive at the challenging spots, slow your pace down and take a deep, belly breath."
                           )
                           ParagrafLP2(
                               title = "6. Replace Your Filler Word with A Silent Pause",
                               desc = "Clients often tell me how difficult this is because they feel like the time to take a deep breath is long. If you’re standing in front of an audience sharing your ideas, it does seem like a long time. The time seems protracted. For the audience it is simply a second or two. A welcomed one, giving them time to distill your messaging.\n" +
                                       "When you feel an um or an ahh about to leave your lips, stop yourself. Take a breath to gather your thoughts and then continue with your next words/thoughts. This technique takes a bit of practice to get comfortable with the silence. It’s worth it because it will move you from a C-level speaker to one who appears polished."
                           )
                           ParagrafLP2(
                               title = "7. Have a Drink of Water",
                               desc = "Another way to tame your ums and ahs is with a sip of water. Make sure to have water close at hand and if you find yourself struggling for your next words take a drink or two, not only to quench your thirst (lubricate dry mouth) but also quench your mind.\n" +
                                       "The few seconds it takes to drink will give you space to gather your thoughts."
                           )
                           ParagrafLP2(
                               title = "8. Refer to Your Notes",
                               desc = "Similar to taking a sip of water to bide some time, referring to your notes does the same. No matter the length of your message it’s natural to gather your thoughts.\n" +
                                       "Referring to your notes is a great foil for pausing and regulating your need for vocal fillers."
                           )
                           ParagrafLP2(
                               title = "9. Plan Your Transitions",
                               desc = "Although I’m not a fan of memorizing presentations, it is sound practice to chunk out your content and know when you will be transitioning from concept to concept.\n" +
                                       "When you plan out your transitions beforehand, you’ll be able to smoothly move from one idea to the next and won’t rely on fillers."
                           )
                           ParagrafLP2(
                               title = "10. Calm Yourself",
                               desc = "Although many people will tell you they have a fear of public speaking, what is actually at the core is their fear of anxiety or nerves taking over.\n" +
                                       "Nerves and anxiety do exacerbate your need to rely on filler phrasing. Being in a state of angst while presenting in front of an audience will have your heart beating fast and have you lose your train of thought.\n" +
                                       "\n" +
                                       "Many techniques that seem too simple to work actually do work. It’s a matter of stopping yourself when you feel anxious, grappling for the right word, to implement your anxiety/nerve regulating techniques.\n" +
                                       "\n" +
                                       "Nerve busting techniques do require practice before your live event so that you know how and when to use them as well as being able to execute good technique.\n" +
                                       "\n" +
                                       "Taking a deep breath is the top go-to anxiety reducing technique I use myself and recommend to my clients. Yes, as simple as breathing. It’s actually not. You need to catch yourself and be aware when your emotions are getting the better of you and your anxiety is climbing. And when you do, take a deep breath.\n" +
                                       "\n" +
                                       "Not a deep breath high up in your chest (which is a common mistake), but a deep breath way down low in your belly. It’s crucial, too, that your exhale is longer than your inhale. It’s on the exhalation that your heart rate will slow.\n" +
                                       "\n" +
                                       "I have been the guinea pig myself using a number of anxiety quelling techniques that I have researched. I use my smartwatch to monitor my heart rate which drops during execution. Not only do I prove to myself the techniques do work but that substantiation also gives me confidence they will work when I’m live on stage. My clients will tell you the same."
                           )
                           Spacer(modifier = Modifier.padding(100.dp))
                       }
                   )
                }
            )
        }
    )
}

@Composable
fun ParagrafLP2(title: String, desc: String) {
    Text(
        text = title,
        color = Color(0xff005e90),
        modifier = Modifier.padding(start = 20.dp, bottom = 10.dp),
        fontWeight = FontWeight.Light

    )
    Text(
        text = desc,
        modifier = Modifier.padding(start = 35.dp, end = 35.dp, bottom = 10.dp),
        fontWeight = FontWeight.Light
    )
}

@Preview
@Composable
private fun PageLearningPath2Prev() {
    PageLearningPath2()
}

@Preview(device = Devices.TABLET)
@Composable
private fun PageLearningPath2PrevTablet() {
    PageLearningPath2()
}