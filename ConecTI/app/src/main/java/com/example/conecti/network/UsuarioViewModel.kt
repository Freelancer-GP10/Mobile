import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conecti.RetrofitClient.BASE_URL
import com.example.conecti.RetrofitClient.connection
import com.example.conecti.network.Service
import com.example.conecti.network.Service.UsuarioCriacaoDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class UsuarioViewModel(private val context: Context) : ViewModel() {
    private val apiService = connection()
    var erroApi = MutableLiveData("")



    fun criarUsuario(usuarioCriacaoDto: UsuarioCriacaoDto) {
        apiService.criarUsuario(usuarioCriacaoDto).enqueue(object :
            Callback<Service.UsuarioResponse> {
            override fun onResponse(call: Call<Service.UsuarioResponse>, response: Response<Service.UsuarioResponse>) {
                if (response.isSuccessful) {
                    println("Usuário criado com sucesso")
                } else {
                    println("Erro ao criar usuário: ${response.errorBody()?.string()}")
                    erroApi.postValue("Erro ao criar usuário: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Service.UsuarioResponse>, t: Throwable) {
                println("Falha ao criar usuário: ${t.message}")
                erroApi.postValue("Falha ao criar usuário: ${t.message}")
            }
        })
    }

    fun loginUsuario(usuarioLoginDto: Service.UsuarioLoginDto) {
        apiService.login(usuarioLoginDto).enqueue(object :
            Callback<Service.UsuarioTokenDto> {
            override fun onResponse(call: Call<Service.UsuarioTokenDto>, response: Response<Service.UsuarioTokenDto>) {
                if (response.isSuccessful) {
                    val token = response.body()?.token
                    if (token != null) {
                        viewModelScope.launch {
                            saveToken(token)
                        }
                    }
                } else {
                    println("Erro ao fazer login: ${response.errorBody()?.string()}")
                    erroApi.postValue("Erro ao fazer login: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Service.UsuarioTokenDto>, t: Throwable) {
                println("Falha ao fazer login: ${t.message}")
                erroApi.postValue("Falha ao fazer login: ${t.message}")
            }
        })
    }


    private suspend fun saveToken(token: String) {
        context.tokenUsuario.edit { settings ->
            settings[stringPreferencesKey("token")] = token
        }
    }



}
