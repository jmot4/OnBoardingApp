package com.example.onboardingapp.onBoardViews
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
@Composable
fun LoaderData(modifier: Modifier, image:Int){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(image))
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )
}