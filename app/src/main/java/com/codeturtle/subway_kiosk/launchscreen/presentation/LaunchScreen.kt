package com.codeturtle.subway_kiosk.launchscreen.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.codeturtle.subway_kiosk.R

@Composable
fun LaunchScreen(
    viewModel: LaunchScreenViewModel = hiltViewModel<LaunchScreenViewModel>(),
    innerPadding: PaddingValues,
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    ProcessingUI(
        innerPadding = innerPadding,
        uiState = uiState.value,
        uiEvent = {
            viewModel.onEvent(it)
        }
    )
}

@Composable
fun ProcessingUI(
    innerPadding: PaddingValues,
    uiState: LaunchScreenUIState,
    uiEvent: (LaunchScreenUIEvent) -> Unit
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.cookie_animation))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = Modifier.padding(innerPadding).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                LottieAnimation(
                    modifier = Modifier.size(250.dp),
                    composition = composition,
                    progress = { progress }
                )

                StatusItemsList(uiState, uiEvent)
            }
        }
    }
}

@Composable
private fun RetryableText(messageRes: Int, onClick: () -> Unit) {
    Text(
        modifier = Modifier.clickable(onClick = onClick),
        text = buildAnnotatedString {
            append(stringResource(messageRes))
            append(" ")
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append(stringResource(R.string.retry))
            }
        },
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
private fun StatusItemsList(
    uiState: LaunchScreenUIState,
    uiEvent: (LaunchScreenUIEvent) -> Unit
) {
    data class StatusItem(
        val isVisible: Boolean,
        val topSpacing: Int = 10,
        val bottomSpacing: Int = 10,
        val content: @Composable () -> Unit
    )

    val statusItems = listOf(
        StatusItem(
            isVisible = uiState.isEloConnectionVisible,
            content = {
                RetryableText(
                    messageRes = R.string.establishing_elo_connection,
                    onClick = { uiEvent(LaunchScreenUIEvent.EloConnectionClicked) }
                )
            }
        ),
        StatusItem(
            isVisible = uiState.isRestaurantsVisible,
            topSpacing = 0,
            bottomSpacing = 0,
            content = {
                Text(
                    text = stringResource(R.string.restaurant),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        ),
        StatusItem(
            isVisible = uiState.isEstablishingScannerVisible,
            content = {
                RetryableText(
                    messageRes = R.string.scanner_initializing,
                    onClick = { uiEvent(LaunchScreenUIEvent.ScannerConnectionClicked) }
                )
            }
        ),
        StatusItem(
            isVisible = uiState.isConnectionPaymentVisible,
            topSpacing = 0,
            bottomSpacing = 30,
            content = {
                RetryableText(
                    messageRes = R.string.payment_initializing,
                    onClick = { uiEvent(LaunchScreenUIEvent.PaymentConnectionClicked) }
                )
            }
        ),
        StatusItem(
            isVisible = uiState.isSyncInitializingVisible,
            topSpacing = 0,
            bottomSpacing = 30,
            content = {
                RetryableText(
                    messageRes = R.string.sync_initializing,
                    onClick = { uiEvent(LaunchScreenUIEvent.FetchingContentClicked) }
                )
            }
        ),
        StatusItem(
            isVisible = uiState.isContinueAnywayVisible,
            topSpacing = 0,
            bottomSpacing = 0,
            content = {
                Text(
                    modifier = Modifier.clickable { uiEvent(LaunchScreenUIEvent.ContinueAnywayClicked) },
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append(stringResource(R.string.continue_anyway))
                        }
                    },
                    style = MaterialTheme.typography.titleLarge
                )
            }
        )
    )

    statusItems.forEach { item ->
        if (item.isVisible) {
            if (item.topSpacing > 0) {
                Spacer(Modifier.height(item.topSpacing.dp))
            }
            item.content()
            if (item.bottomSpacing > 0) {
                Spacer(Modifier.height(item.bottomSpacing.dp))
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 800, heightDp = 1280)
@Composable
fun LaunchScreenPreview() {
    ProcessingUI(
        innerPadding = PaddingValues(),
        uiState = LaunchScreenUIState(),
        uiEvent = {}
    )
}