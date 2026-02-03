package com.codeturtle.subway_kiosk.launchscreen.presentation

import com.codeturtle.subway_kiosk.common.utils.UiText

data class LaunchScreenUIState(
    val eloConnection: UiText? = null,
    val isEloConnectionVisible: Boolean = true,
    val restaurantsText: UiText? = null,
    val isRestaurantsVisible: Boolean = true,
    val establishingScannerText: UiText? = null,
    val isEstablishingScannerVisible: Boolean = true,
    val connectionPaymentText: UiText? = null,
    val isConnectionPaymentVisible: Boolean = true,
    val isSyncInitializingVisible: Boolean = true,
    val isContinueAnywayVisible: Boolean = true,
)