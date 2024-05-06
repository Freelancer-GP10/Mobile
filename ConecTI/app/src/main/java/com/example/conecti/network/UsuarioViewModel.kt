import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.conecti.CadastroFrellaTres
import com.example.conecti.Login
import com.example.conecti.network.Service
import com.example.conecti.network.Service.UsuarioCriacaoDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UsuarioViewModel(private val context: Context) : ViewModel() {
    private val apiService = RetrofitClient.connection(context)
    private val sharedPrefManager = SharedPrefManager(context)
    var erroApi = MutableLiveData("")
    var erroAutenticacao = MutableLiveData<String>()

    fun criarUsuario(usuarioCriacaoDto: UsuarioCriacaoDto) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.criarUsuario(usuarioCriacaoDto)
                if (response.isSuccessful) {
                    val intent = Intent(context, Login::class.java)
                    context.startActivity(intent)
                    println(intent)
                    println("Usuário criado com sucesso")
                } else {
                    erroApi.postValue(response.errorBody()?.string() ?: "")
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
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