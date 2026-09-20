package com.example.pcremote.ui.theme

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyColorTheme(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {

        // --- Primary ---
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("primary", color = MaterialTheme.colorScheme.onPrimary)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onPrimary", color = MaterialTheme.colorScheme.primary)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("primaryContainer", color = MaterialTheme.colorScheme.onPrimaryContainer)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onPrimaryContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onPrimaryContainer", color = MaterialTheme.colorScheme.primaryContainer)
        }

// --- Secondary ---
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondary)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("secondary", color = MaterialTheme.colorScheme.onSecondary)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onSecondary)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onSecondary", color = MaterialTheme.colorScheme.secondary)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("secondaryContainer", color = MaterialTheme.colorScheme.onSecondaryContainer)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onSecondaryContainer", color = MaterialTheme.colorScheme.secondaryContainer)
        }

// --- Tertiary ---
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.tertiary)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("tertiary", color = MaterialTheme.colorScheme.onTertiary)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onTertiary)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onTertiary", color = MaterialTheme.colorScheme.tertiary)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("tertiaryContainer", color = MaterialTheme.colorScheme.onTertiaryContainer)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onTertiaryContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onTertiaryContainer", color = MaterialTheme.colorScheme.tertiaryContainer)
        }

// --- Error ---
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.error)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("error", color = MaterialTheme.colorScheme.onError)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onError)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onError", color = MaterialTheme.colorScheme.error)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.errorContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("errorContainer", color = MaterialTheme.colorScheme.onErrorContainer)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onErrorContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onErrorContainer", color = MaterialTheme.colorScheme.errorContainer)
        }

// --- Background & Surface ---
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("background", color = MaterialTheme.colorScheme.onBackground)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onBackground)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onBackground", color = MaterialTheme.colorScheme.background)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surface", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onSurface)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onSurface", color = MaterialTheme.colorScheme.surface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceVariant", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onSurfaceVariant)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("onSurfaceVariant", color = MaterialTheme.colorScheme.surfaceVariant)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceTint)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceTint", color = MaterialTheme.colorScheme.surface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.inverseSurface)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("inverseSurface", color = MaterialTheme.colorScheme.inverseOnSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("inverseOnSurface", color = MaterialTheme.colorScheme.inverseSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.inversePrimary)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("inversePrimary", color = MaterialTheme.colorScheme.primary)
        }

// --- Material 3 Expressive Containers (Surface Levels) ---
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceContainerLowest", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceContainerLow", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainer)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceContainer", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainerHigh)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceContainerHigh", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainerHighest)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceContainerHighest", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceBright)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceBright", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surfaceDim)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("surfaceDim", color = MaterialTheme.colorScheme.onSurface)
        }

// --- Outline & Scrim ---
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.outline)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("outline", color = MaterialTheme.colorScheme.surface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.outlineVariant)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("outlineVariant", color = MaterialTheme.colorScheme.onSurface)
        }

        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.scrim)
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text("scrim", color = MaterialTheme.colorScheme.surface)
        }

    }
}