package com.example.pcremote

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.KeyboardDoubleArrowLeft
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeyBoard(OnCommand: (String) -> Unit = {}) {
    val tcpManager = TcpClientManager("192.168.1.106", 5006)

    val scope = rememberCoroutineScope()

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Button(
        onClick = { showBottomSheet = true }
    ) {
        Text("Keyboard")
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            sheetState = sheetState,
            onDismissRequest = { showBottomSheet = false }
        ) {
            KeyBoardLayout()
        }
    }
}

@Preview
@Composable
fun KeyBoardLayout() {
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
            Column(modifier = Modifier.weight(1f)) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    Modifier.height(140.dp).fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)) {

                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = null
                    )

                }
            }
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                    ){
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = null
                    )
                }

                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(fontSize = 8.sp,text = "Выделить")

                }

                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ){
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    Modifier.height(140.dp).fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp)) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null
                    )
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(text = "Выделить все", fontSize = 6.sp)
                }
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Скопировать", fontSize = 6.sp)
                }
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Вставить", fontSize = 6.sp)
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(modifier = Modifier.weight(1.5f)) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                    ){
                    Icon(
                        imageVector = Icons.Filled.KeyboardDoubleArrowLeft,
                        contentDescription = null
                    )
                }
            }

            Column(modifier = Modifier.weight(1.5f)) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                    ){
                    Icon(
                        imageVector = Icons.Filled.KeyboardDoubleArrowRight,
                        contentDescription = null
                    )
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Button(onClick = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Backspace,
                        contentDescription = null
                    )
                }
            }
        }
    }
}