import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conecti.RetrofitClient
import com.example.conecti.netWorkMIcro.ServiceMicroDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MicroViewModel(private val context: Context) : ViewModel() {
    private val apiService = RetrofitClient.connection()
    private val usuarioViewModel = UsuarioViewModel(context)

    fun cadastrarEmpresa(empresa: ServiceMicroDto.CadastrarEmpresaDto, callback: (Response<ServiceMicroDto.Empresa>) -> Unit) {
        viewModelScope.launch {
            val token = usuarioViewModel.getToken2()
            if (token != null) {
                val call = apiService.cadastrarEmpresa("Bearer $token", empresa)
                call.enqueue(object : Callback<ServiceMicroDto.Empresa> {
                    override fun onResponse(call: Call<ServiceMicroDto.Empresa>, response: Response<ServiceMicroDto.Empresa>) {
                        callback(response)
                    }

                    override fun onFailure(call: Call<ServiceMicroDto.Empresa>, t: Throwable) {
                        Toast.makeText(context, "Falha na comunicação com o servidor", Toast.LENGTH_LONG).show()
                    }
                })
            } else {
                Toast.makeText(context, "Token não encontrado", Toast.LENGTH_LONG).show()
            }
        }
    }
}

