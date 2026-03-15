package com.example.pcremote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardBackspace
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.PowerOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun keyboard() {
    val haptic = LocalHapticFeedback.current
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Column(

            ) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    Modifier.height(140.dp),
                    shape = RoundedCornerShape(10.dp)) {

                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = null
                    )

                }
            }
            Column() {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },  
                    shape = RoundedCornerShape(10.dp)) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = null
                    )
                }

                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp)) {
                    Text(fontSize = 10.sp,text = "Выделить")

                }

                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp)) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
            Column() {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    Modifier.height(140.dp),
                    shape = RoundedCornerShape(10.dp)) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null
                    )
                }
            }
            Column() {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp)
                    ){

                }
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Button(onClick = {
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            },
                shape = RoundedCornerShape(10.dp)) { }
            Button(onClick = {
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            },
                shape = RoundedCornerShape(10.dp)) { }
            Button(onClick = {
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            },
                shape = RoundedCornerShape(10.dp)) { }
        }
    }
}