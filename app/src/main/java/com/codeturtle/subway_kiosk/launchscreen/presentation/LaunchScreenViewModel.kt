package com.codeturtle.subway_kiosk.launchscreen.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LaunchScreenViewModel {

    private val _uiState = MutableStateFlow(LaunchScreenUIState())
    val uiState: StateFlow<LaunchScreenUIState> = _uiState


}