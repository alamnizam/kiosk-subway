package com.codeturtle.subway_kiosk.launchscreen.presentation

data class LaunchScreenUIState(
    val eloConnectionVisibility: Int = -1,
    val restaurantsText: String = "",
    val establishingScannerText: String = "",
    val establishingScannerVisibility: Int = -1,
    val connectionPaymentText: String = "",
    val connectionPaymentVisibility: String = "",
    val continueAnywayVisibility: Int = -1,
)