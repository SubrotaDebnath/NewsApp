package subrota.shuvro.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import subrota.shuvro.newsapp.domain.manager.LocalUserManager
import subrota.shuvro.newsapp.util.Constants
import subrota.shuvro.newsapp.util.Constants.USER_SETTINGS
import androidx.datastore.preferences.core.Preferences

class LocalUserManagerImpl(
    private val context: Context
): LocalUserManager {
    override suspend fun saveAppEntry() {
         context.datastore.edit {
            it[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.datastore.data.map {
            it[PreferencesKey.APP_ENTRY] ?: false
        }
    }
}


private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)
private object PreferencesKey {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}
