import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conecti.RetrofitClient.connection
import com.example.conecti.network.Service
import com.example.conecti.network.Service.UsuarioCriacaoDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class UsuarioViewModel() : ViewModel() {
    private val apiService = connection()
    var erroApi = MutableLiveData("")
    var erroAutenticacao = MutableLiveData<String>()



    fun criarUsuario(usuarioCriacaoDto: UsuarioCriacaoDto) {
        apiService.criarUsuario(usuarioCriacaoDto).enqueue(object :
            Callback<Service.UsuarioResponse> {
            override fun onResponse(call: Call<Service.UsuarioResponse>, response: Response<Service.UsuarioResponse>) {
                if (response.isSuccessful) {
                    val intent = Intent(context, Login::class.java)
                    context.startActivity(intent)
                    println(intent)
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

}

    fun login(usuarioLoginDto: Service.UsuarioLoginDto, onLoginSuccess: () -> Unit, onError: (String) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.login(usuarioLoginDto)
                if (response.isSuccessful) {
                    val usuarioTokenDto = response.body()
                    println("Login bem-sucedido")
                    // Salvar o token no SharedPreferences
                    usuarioTokenDto?.token?.let { token ->
                        sharedPrefManager.saveAuthToken(token)
                    }
                    // Chamar a função de sucesso
                    onLoginSuccess()
                } else {
                    // Chamar a função de erro
                    onError(response.errorBody()?.string() ?: "")
                }
            } catch (e: Exception) {
                // Chamar a função de erro
                onError(e.message ?: "Erro desconhecido")
            }
        }
    }

}

