package com.codeturtle.subway_kiosk.launchscreen.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LaunchScreenViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(LaunchScreenUIState())
    val uiState: StateFlow<LaunchScreenUIState> = _uiState

    fun onEvent(uiEvent: LaunchScreenUIEvent){
        when(uiEvent){
            LaunchScreenUIEvent.EloConnectionClicked -> {}
            LaunchScreenUIEvent.FetchingContentClicked -> {}
            LaunchScreenUIEvent.PaymentConnectionClicked -> {}
            LaunchScreenUIEvent.ScannerConnectionClicked -> {}
            LaunchScreenUIEvent.ContinueAnywayClicked -> {}
        }
    }

}