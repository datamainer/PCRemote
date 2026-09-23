package com.example.pcremote

import android.R
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerOff
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.pcremote.R.drawable.spotify
import com.example.pcremote.R.drawable.chrome
import com.example.pcremote.R.drawable.steam


@Composable
fun MainScreenApp(
    onCommand: (String) -> Unit = {},
    onWakeClick: () -> Unit = {}
) {

    val haptic = LocalHapticFeedback.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer,
                RoundedCornerShape(35.dp))

    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            PressedButton(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .padding(5.dp),
//                frontColor = Color(0xFF447BD4),
//                backColor = Color(0xFF052D6E),
                onClick = {
                    onCommand("Steam")
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                }

            ) {
//                Text("Steam", color = Color.Black)
                Icon(
                    painter = painterResource(id = steam),
                    contentDescription = "Steam Logo",
                    modifier = Modifier.size(48.dp),
                    tint = Color.Unspecified
                )
            }

            PressedButton(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .padding(5.dp),
//                frontColor = Color(0xFF159F3F),
//                backColor = Color(0xFF076A25),
                onClick = {
                    onCommand("Spotify")
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                }

            ) {
//                Text("Spotify", color = Color.Black)
                Icon(
                    painter = painterResource(id = spotify),
                    contentDescription = "Spotify Logo",
                    modifier = Modifier.size(48.dp),
                    tint = Color.Unspecified
                )
            }

            PressedButton(
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)
                    .padding(5.dp),
//                frontColor = Color(0xFFD7B21D),
//                backColor = Color(0xFF8F740A),
                onClick = {
                    onCommand("Chrome")
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                }

            ) {
//                Text("Chrome", color = Color.Black)
                Icon(
                    painter = painterResource(id = chrome),
                    contentDescription = "Chrome Logo",
                    modifier = Modifier.size(48.dp),
                    tint = Color.Unspecified
                )
            }

        }
    }

}