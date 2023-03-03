package com.maroctrix.littlelemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.maroctrix.littlelemon.R
import com.maroctrix.littlelemon.ui.theme.Peach

@Composable
fun ShowEmptyItemsAnimation(emptyText: String = stringResource(id = R.string.empty_text)) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.sad_empty_box))
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .size(148.dp),
            alignment = Alignment.TopCenter
        )
        Text(
            text = emptyText,
            textAlign = TextAlign.Center,
            color = Peach,
            fontWeight = FontWeight.Bold
        )
    }
}