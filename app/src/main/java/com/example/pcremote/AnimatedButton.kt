package com.example.pcremote

import android.R.attr.shape
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


@Composable
fun PressedButton (
    modifier: Modifier = Modifier,
    backColor: Color = MaterialTheme.colorScheme.primary,
    frontColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    onClick: () -> Unit,
    content: @Composable () -> Unit,

    ) {

    val shape = RoundedCornerShape(16.dp)
    var pressed by remember { mutableStateOf(false) }
    val offsetY by animateDpAsState(
        targetValue = if (pressed) 5.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 100
        ),
        label = "buttonOffset"
    )

    Box(
        modifier = modifier
    ) {
        // нижний слой
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(y = 5.dp)
                .background(
                    color = backColor,
                    RoundedCornerShape(30.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(30.dp),
                )

        )
        // верхний слой
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(y = offsetY)
                .background(
                    color = frontColor,
                    RoundedCornerShape(30.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(30.dp),
                )
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            pressed = true

                            try {
                                awaitRelease()
                            } finally {
                                pressed = false
                            }

                            onClick()
                        }
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}