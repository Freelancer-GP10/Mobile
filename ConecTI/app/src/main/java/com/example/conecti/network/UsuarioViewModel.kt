import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.conecti.RetrofitClient.conection
import com.example.conecti.network.Service.UsuarioCriacaoDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class UsuarioViewModel() : ViewModel() {
    private val apiService = conection()
    var erroApi = MutableLiveData("")

    fun criarUsuario(usuarioCriacaoDto: UsuarioCriacaoDto) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.criarUsuario(usuarioCriacaoDto)
                if (response.isSuccessful) {
                    println("Usuário criado com sucesso")
                } else {
                    erroApi.postValue(response.errorBody()?.string() ?: "")
                }
            } catch (e: Exception) {
                erroApi.postValue(e.message)
            }
        }
    }
}
