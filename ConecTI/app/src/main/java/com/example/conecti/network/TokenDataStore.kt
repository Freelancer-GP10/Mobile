import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first

class TokenDataStore(private val context: Context) {
    private val dataStore: DataStore<Preferences> = context.createDataStore(name = "token_preferences")

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }
    }

     suspend fun getToken(): String? {
        val preferences = dataStore.data.first()
        return preferences[TOKEN_KEY]
    }

    companion object {
        private val TOKEN_KEY = stringPreferencesKey("token")
    }
}

private fun Context.createDataStore(name: String): DataStore<Preferences> {

    return createDataStore(
        name = name
    )
}
