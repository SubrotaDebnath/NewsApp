package subrota.shuvro.newsapp.domain.usecases

import kotlinx.coroutines.flow.Flow
import subrota.shuvro.newsapp.domain.manager.LocalUserManager

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}