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
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.codeturtle.subway_kiosk.R

@Composable
fun LaunchScreen(
    innerPadding: PaddingValues,
) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    paddingValues = PaddingValues(horizontal = 10.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            )
        ) {
            ProcessingUI()
        }
    }
}

@Composable
fun ProcessingUI() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.cookie_animation)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LottieAnimation(
                modifier = Modifier.size(250.dp),
                composition = composition,
                progress = { progress }
            )
            Spacer(Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .clickable {  },
                text = buildAnnotatedString {
                    append(stringResource(R.string.establishing_elo_connection))
                    append(" ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append(stringResource(R.string.retry))
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.restaurant),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .clickable {  },
                text = buildAnnotatedString {
                    append(stringResource(R.string.scanner_initializing))
                    append(" ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append(stringResource(R.string.retry))
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(10.dp))
            Text(
                modifier = Modifier
                    .clickable {  },
                text = buildAnnotatedString {
                    append(stringResource(R.string.payment_initializing))
                    append(" ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append(stringResource(R.string.retry))
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(30.dp))
            Text(
                modifier = Modifier
                    .clickable {  },
                text = buildAnnotatedString {
                    append(stringResource(R.string.sync_initializing))
                    append(" ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append(stringResource(R.string.retry))
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(30.dp))
            Text(
                modifier = Modifier
                    .clickable {  },
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append(stringResource(R.string.continue_anyway))
                    }
                },
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 800, heightDp = 1280)
@Composable
fun LaunchScreenPreview() {
    LaunchScreen(
        innerPadding = PaddingValues(0.dp),
    )
}