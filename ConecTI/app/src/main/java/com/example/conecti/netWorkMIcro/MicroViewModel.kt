import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.conecti.RetrofitClient
import com.example.conecti.netWorkMIcro.ServiceMicro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MicroViewModel(private val context: Context) : ViewModel() {
    private val apiService = RetrofitClient.connection()

    fun cadastrarEmpresa(empresa: ServiceMicro.CadastrarEmpresaDto, callback: (Response<ServiceMicro.Empresa>) -> Unit) {
        val call = apiService.cadastrarEmpresa(empresa)

        call.enqueue(object : Callback<ServiceMicro.Empresa> {
            override fun onResponse(call: Call<ServiceMicro.Empresa>, response: Response<ServiceMicro.Empresa>) {
                callback(response)
            }



            override fun onFailure(call: Call<ServiceMicro.Empresa>, t: Throwable) {
                Toast.makeText(context, "Falha na comunicação com o servidor", Toast.LENGTH_LONG).show()
            }
        })
    }
}

