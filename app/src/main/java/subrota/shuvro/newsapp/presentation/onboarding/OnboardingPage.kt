package subrota.shuvro.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import subrota.shuvro.newsapp.R

data class OnboardingPage(
    val title: String,
    val description: String,
    @DrawableRes val imageId: Int,
)
 val pages = listOf<OnboardingPage>(
     OnboardingPage(
         title = "Lorem Ipsum is simply dummy",
         description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
         imageId = R.drawable.onboarding1
     ),
     OnboardingPage(
         title = "Lorem Ipsum is simply dummy",
         description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
         imageId = R.drawable.onboarding2
     ),
     OnboardingPage(
         title = "Lorem Ipsum is simply dummy",
         description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
         imageId = R.drawable.onboarding3
     )
 )