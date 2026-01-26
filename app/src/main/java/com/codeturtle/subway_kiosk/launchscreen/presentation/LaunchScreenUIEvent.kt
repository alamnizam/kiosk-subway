package com.codeturtle.subway_kiosk.launchscreen.presentation

sealed class LaunchScreenUIEvent {
    data object EloConnectionClicked : LaunchScreenUIEvent()
    data object ScannerConnectionClicked : LaunchScreenUIEvent()
    data object PaymentConnectionClicked : LaunchScreenUIEvent()
    data object FetchingContentClicked : LaunchScreenUIEvent()
    data object ContinueAnywayClicked : LaunchScreenUIEvent()
}