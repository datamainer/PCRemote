package com.example.pcremote // Убедитесь, что пакет совпадает с вашим

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavBackStackEntry

// Задаем единую скорость для всех анимаций (в миллисекундах)
private const val ANIMATION_DURATION = 300

// Экран выезжает справа налево (для перехода вперед)
fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInRight(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { it },
        animationSpec = tween(ANIMATION_DURATION)
    ) + fadeIn(animationSpec = tween(ANIMATION_DURATION))
}

// Текущий экран уезжает влево (при переходе вперед)
fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutLeft(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { -it },
        animationSpec = tween(ANIMATION_DURATION)
    ) + fadeOut(animationSpec = tween(ANIMATION_DURATION))
}

// Предыдущий экран возвращается слева направо (при нажатии "Назад")
fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInLeft(): EnterTransition {
    return slideInHorizontally(
        initialOffsetX = { -it },
        animationSpec = tween(ANIMATION_DURATION)
    ) + fadeIn(animationSpec = tween(ANIMATION_DURATION))
}

// Текущий экран уезжает вправо (при нажатии "Назад")
fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutRight(): ExitTransition {
    return slideOutHorizontally(
        targetOffsetX = { it },
        animationSpec = tween(ANIMATION_DURATION)
    ) + fadeOut(animationSpec = tween(ANIMATION_DURATION))
}

// Простой Fade (растворение) для экранов, где выезд не нужен
fun defaultFadeIn(): EnterTransition = fadeIn(animationSpec = tween(ANIMATION_DURATION))
fun defaultFadeOut(): ExitTransition = fadeOut(animationSpec = tween(ANIMATION_DURATION))