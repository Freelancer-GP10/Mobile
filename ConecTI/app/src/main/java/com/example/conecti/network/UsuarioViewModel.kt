import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conecti.RetrofitClient
import com.example.conecti.RetrofitClient.connection
import com.example.conecti.network.Service
import com.example.conecti.network.Service.UsuarioCriacaoDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch
import okhttp3.RequestBody.Companion.toRequestBody

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsuarioViewModel(private val context: Context) : ViewModel() {
    private val apiService = connection()
    var erroApi = MutableLiveData("")

    private val _cadastroFreela = MutableStateFlow(Service.CadastrarFreelaDto("", "", "", "", "", "", ""))
    val cadastroFreela: StateFlow<Service.CadastrarFreelaDto> = _cadastroFreela

    // Função para atualizar os dados do freelancer
    fun atualizarCadastroFreela(novoCadastro: Service.CadastrarFreelaDto) {
        _cadastroFreela.value = novoCadastro
    }

    var nome = mutableStateOf("")
    var sobrenome = mutableStateOf("")
    var cpf = mutableStateOf("")
    var telefone = mutableStateOf("")
    var areaAtuacao = mutableStateOf("")
    var linguagemDominio = mutableStateOf("")
    var formacao = mutableStateOf("")

    fun enviarDados() {
        viewModelScope.launch {
            // Crie o DTO com os dados
            val freelaDto = Service.CadastrarFreelaDto(
                nome = nome.value,
                sobrenome = sobrenome.value,
                cpf = cpf.value,
                telefone = telefone.value,
                areaAtuacao = areaAtuacao.value,
                linguagemDominio = linguagemDominio.value,
                formacao = formacao.value
            )
            // Envie o DTO ao servidor usando Retrofit
        }
    }


    fun criarUsuario(usuarioCriacaoDto: UsuarioCriacaoDto) {
        apiService.criarUsuario(usuarioCriacaoDto).enqueue(object :
            Callback<Service.UsuarioResponse> {
            override fun onResponse(
                call: Call<Service.UsuarioResponse>,
                response: Response<Service.UsuarioResponse>
            ) {
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
            override fun onResponse(
                call: Call<Service.UsuarioTokenDto>,
                response: Response<Service.UsuarioTokenDto>
            ) {
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


    fun criarUsuarioParte2(cadastrarFreelaDto: Service.CadastrarFreelaDto) {
        apiService.cadastrarFreelancer(cadastrarFreelaDto).enqueue(object :
            Callback<Service.FreelancerResponse2> {
            override fun onResponse(
                call: Call<Service.FreelancerResponse2>,
                response: Response<Service.FreelancerResponse2>
            ) {
                if (response.isSuccessful) {
                    println("Usuário criado com sucesso")
                } else {
                    println("Erro ao criar usuário: ${response.errorBody()?.string()}")
                    erroApi.postValue("Erro ao criar usuário: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Service.FreelancerResponse2>, t: Throwable) {
                println("Falha ao criar usuário: ${t.message}")
                erroApi.postValue("Falha ao criar usuário: ${t.message}")
            }
        })
    }


//    fun cadastrarFreelancer(dto: Service.CadastrarFreelaDto, navigateToNextScreen: () -> Unit) {
//        val call = RetrofitClient.connection().cadastrarFreelancer(dto.toJson().toRequestBody())
//        call.enqueue(object : retrofit2.Callback<Service.FreelancerResponse> {
//            override fun onResponse(
//                call: retrofit2.Call<Service.FreelancerResponse>,
//                response: retrofit2.Response<Service.FreelancerResponse>
//            ) {
//                if (response.isSuccessful) {
//                    // Sucesso
//                    navigateToNextScreen()
//                } else {
//                    // Trate o erro
//                }
//            }
//
//            override fun onFailure(call: retrofit2.Call<Service.FreelancerResponse>, t: Throwable) {
//                // Trate a falha
//            }
//        })
//    }


}
