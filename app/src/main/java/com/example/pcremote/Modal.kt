package com.example.pcremote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartialBottomSheet(openApp: (String) -> Unit = {}) {
    val tcpManager = TcpClientManager("192.168.1.106", 5006)
    val haptic = LocalHapticFeedback.current
    val scope = rememberCoroutineScope()

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )

    Button(
        onClick = { showBottomSheet = true }
    ) {
        Text("Applications")
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxHeight(),
            sheetState = sheetState,
            onDismissRequest = { showBottomSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)

                ) {
                    Button(
                        onClick = {
                            scope.launch {
                                tcpManager.sendCommand("Spotify")
                            }
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        }
                    ) {
                        Text("Spotify")
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                tcpManager.sendCommand("Steam")
                            }
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        }
                    ) {
                        Text("Steam")
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                tcpManager.sendCommand("Minecraft")
                            }
                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        }
                    ) {
                        Text("Minecraft")
                    }
                }
            }
        }
    }
}