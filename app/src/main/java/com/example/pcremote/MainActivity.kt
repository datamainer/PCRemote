package com.example.pcremote
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Airplay
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.PowerOff
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import kotlinx.coroutines.launch
import androidx.compose.material3.Slider
import androidx.compose.runtime.*
import com.example.pcremote.ui.theme.PCRemoteTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ermohdamaan.justforpixel.justforpixelexpressivelab.core.components.sliders.ExpressiveWavySlider
import com.example.pcremote.ui.theme.MyColorTheme

class MainActivity : ComponentActivity() {

    val tcpManager = TcpClientManager("192.168.1.106", 5006)
    private val wolManager = WolManager()
    private val myMac = "10:FF:E0:A7:83:AB"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            PCRemoteTheme {
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()

                Scaffold(content = { innerPadding: PaddingValues ->

                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {

                        NavHost(
                            navController = navController,
                            startDestination = NavRoutes.Home.route,
                            modifier = Modifier.weight(1f)
                        ) {
                            composable(
                                route = NavRoutes.Home.route,
                                enterTransition = { slideInRight() },
                                exitTransition = { slideOutLeft() },
                                popEnterTransition = { slideInLeft() },
                                popExitTransition = { slideOutRight() }
                            ) {
                                HomeScreen()
                            }

                            composable(
                                route = NavRoutes.Control.route,
                                enterTransition = { slideInRight() },
                                exitTransition = { slideOutLeft() },
                                popEnterTransition = { slideInLeft() },
                                popExitTransition = { slideOutRight() }
                            ) {
                                ControllerScreen()
                            }

                            composable(
                                route = NavRoutes.Settings.route,
                                enterTransition = { defaultFadeIn() },
                                exitTransition = { defaultFadeOut() }
                            ) {
                                // SettingsScreen()
                            }

                            composable(
                                route = NavRoutes.ColorTheme.route,
                                enterTransition = { slideInRight() },
                                exitTransition = { slideOutLeft() },
                                popEnterTransition = { slideInLeft() },
                                popExitTransition = { slideOutRight() }
                            ) {
                                MyColorTheme()
                            }
                        }
                        BottomNavigationBar(navController = navController)
                    }

                }
                )
            }

        }
    }
}


@Preview
@Composable
fun HomeScreen(onCommand: (String) -> Unit = {}) {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val tcpManager = TcpClientManager("192.168.1.106", 5006)
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        ScreenName("PCRemoter")
        PcPowerManager(
            onCommand = { command ->
                scope.launch {
                    tcpManager.sendCommand(command)
                }
            }
        )

        MainScreenApp(onCommand = { command ->
            scope.launch {
                tcpManager.sendCommand(command)
            }
        })

        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {PartialBottomSheet()}
    }

}

@Preview
@Composable
fun ControllerScreen(onCommand: (String) -> Unit = {}) {
    val scope = rememberCoroutineScope()
    val tcpManager = TcpClientManager("192.168.1.106", 5006)
    Column(
        modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        
    ) {
        ScreenName("Controller")
        PcMediaController(
            onCommand = { command ->
                scope.launch {
                    tcpManager.sendCommand(command)
                }
            }
        )
        PcVolumeControl { volume ->
            scope.launch {
                tcpManager.sendCommand("VOLUME:$volume")
            }
        }
        PcTouchpad()
//        KeyBoard()

    }
}


@Composable
fun ScreenName(name: String){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
    ) {
        Text(
            text = "$name",
            fontSize = 65.sp,

            )
    }

}

@Composable
fun PcPowerManager(onCommand: (String) -> Unit = {},
                   onWakeClick: () -> Unit = {}){
    val haptic = LocalHapticFeedback.current
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        PressedButton(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .padding(5.dp),
            frontColor = Color(0xFFd31b2b),
            backColor = Color(0xFF88111b),
            onClick = {
                onCommand("poweroff")
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }

        ) {
            Icon(
                imageVector = Icons.Filled.PowerOff,
                contentDescription = null
            )
        }

        PressedButton(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .padding(5.dp),
            frontColor = Color(0xFF009999),
            backColor = Color(0xFF004444),
            onClick = {
                onWakeClick()
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        ) {
            Icon(
                imageVector = Icons.Filled.PowerSettingsNew,
                contentDescription = null
            )
        }
        }
    }

@Composable
fun PcMediaController(onCommand: (String) -> Unit = {}){
    val haptic = LocalHapticFeedback.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            PressedButton(
                modifier = Modifier
                    .weight(1f)
                    .height(110.dp)
                    .padding(5.dp),

                onClick = {
                    onCommand("backMedia")
                    haptic.performHapticFeedback(
                        HapticFeedbackType.LongPress
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = null
                )
            }

            PressedButton(
                modifier = Modifier
                    .weight(1.5f)
                    .height(110.dp)
                    .padding(5.dp),

                onClick = {
                    onCommand("stopMedia")
                    haptic.performHapticFeedback(
                        HapticFeedbackType.LongPress
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = null
                )
            }
            PressedButton(
                modifier = Modifier
                    .weight(1f)
                    .height(110.dp)
                    .padding(5.dp),

                onClick = {
                    onCommand("forwardMedia")
                    haptic.performHapticFeedback(
                        HapticFeedbackType.LongPress
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = null
                )
            }



        }

    }
}

@Composable
fun PcTouchpad() {

    val isPreview = androidx.compose.ui.platform.LocalInspectionMode.current
    val sender = if (isPreview) null else remember { UdpSender("192.168.1.106", 5005) }
    val haptic = LocalHapticFeedback.current


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(300.dp)
//                    .padding(10.dp)
                    .background(Color.DarkGray, RoundedCornerShape(16.dp))

                    .pointerInput(Unit) {
                        if (isPreview) return@pointerInput
                        detectTapGestures(
                            onTap = {
                                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                sender?.send("click:left")

                            },
                            onLongPress = {
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                sender?.send("click:right")
                            }
                        )
                    }

                    .pointerInput(Unit) {
                        if (isPreview) return@pointerInput
                        detectDragGestures { change, dragAmount ->
                            change.consume()
                            sender?.send("${dragAmount.x}:${dragAmount.y}")
                        }
                    }

            ) {}

            Box(
                modifier = Modifier
                    .weight(0.2f)
                    .height(300.dp)
//                    .padding(10.dp)
                    .background(Color.DarkGray, RoundedCornerShape(16.dp))
                    .pointerInput(Unit) {
                        detectDragGestures { _, dragAmount ->
                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                            sender?.send("scroll:${dragAmount.y}")
                        }
                    }
            ) {}
        }

        var selectedTab by remember { mutableIntStateOf(0) }


    }
}

@Composable
fun PcVolumeControl(onVolumeChange: (Float) -> Unit = {}) {
    var sliderPosition by remember { mutableStateOf(0.5f) }

    Column(modifier = Modifier.padding(16.dp)) {
//        Slider(
//            value = sliderPosition,
//            onValueChange = {
//                sliderPosition = it
//            },
//            onValueChangeFinished = {
//                onVolumeChange(sliderPosition)
//            },
//            valueRange = 0f..1f
//        )



        ExpressiveWavySlider(
            value = { sliderPosition },
            onValueChange = { sliderPosition = it },
            isPlaying = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChangeFinished = {
                onVolumeChange(sliderPosition)
            },
            valueRange = 0f..1f
        )
    }
}

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "Control",
            image = Icons.Filled.Airplay,
            route = "Control"
        ),
        BarItem(
            title = "Theme",
            image = Icons.Filled.ColorLens,
            route = "Theme"
        ),
//        BarItem(
//            title = "Settings",
//            image = Icons.Filled.Settings,
//            route = "Settings"
//        )
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // Считываем список элементов из вашего объекта NavBarItems
    val navItems = NavBarItems.BarItems

    // Определяем индекс активного экрана
    val selectedIndex = navItems.indexOfFirst { it.route == currentRoute }.let { index ->
        if (index == -1) 0 else index
    }

    ExpressiveFloatingBottomBar(
        items = navItems.map { BottomNavItem(it.title, it.image, it.route) },
        selectedIndex = selectedIndex,
        onTabSelected = { newIndex ->
            val targetRoute = navItems[newIndex].route
            if (currentRoute != targetRoute) {
                navController.navigate(targetRoute) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    )
}




data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Control : NavRoutes("Control")
    object Settings : NavRoutes("Settings")
    object ColorTheme : NavRoutes("Theme")
}

