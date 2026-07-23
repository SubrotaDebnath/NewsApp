package subrota.shuvro.newsapp.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import subrota.shuvro.newsapp.domain.usecases.AppEntryUseCases
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    val appEntryUseCases: AppEntryUseCases,
) : ViewModel() {
    // Public
    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }


    // Private
    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}

