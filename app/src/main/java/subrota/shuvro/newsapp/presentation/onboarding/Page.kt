package subrota.shuvro.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import subrota.shuvro.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val imageId: Int,
)
 val pages = listOf<Page>(
     Page(
         title = "Lorem Ipsum is simply dummy",
         description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
         imageId = R.drawable.onboarding1
     ),
     Page(
         title = "Lorem Ipsum is simply dummy",
         description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
         imageId = R.drawable.onboarding2
     ),
     Page(
         title = "Lorem Ipsum is simply dummy",
         description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
         imageId = R.drawable.onboarding3
     )
 )