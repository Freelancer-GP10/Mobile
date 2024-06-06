import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
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

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsuarioViewModel(private val context: Context) : ViewModel() {
    private val apiService = connection()
    val errorMessage = MutableLiveData<String>()
    val servicos = MutableLiveData<List<Service.ListarServicoDto>>()
    var erroApi = MutableLiveData("")
    var usuarioAutenticado = MutableLiveData<Service.UsuarioTokenDto>()

    private val _cadastroFreela = MutableStateFlow(Service.CadastrarFreelaDto("", "", "", "", "", "", ""))
  //  val cadastroFreela: StateFlow<Service.CadastrarFreelaDto> = _cadastroFreela

    private val _cadastroStatus = MutableLiveData<Result<Void?>>()
    val cadastroStatus: LiveData<Result<Void?>> = _cadastroStatus

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
                    usuarioAutenticado.postValue(response.body())
                    erroApi.postValue("")
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

    fun fetchProximosServicos() {
        viewModelScope.launch {
            val call = apiService.getProximosServicos()
            call.enqueue(object : Callback<List<Service.ListarServicoDto>> {
                override fun onResponse(
                    call: Call<List<Service.ListarServicoDto>>,
                    response: Response<List<Service.ListarServicoDto>>
                ) {
                    if (response.isSuccessful) {
                        servicos.postValue(response.body())
                    } else {
                        errorMessage.postValue("Erro ao buscar dados: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<List<Service.ListarServicoDto>>, t: Throwable) {
                    errorMessage.postValue("Erro na chamada da API: ${t.message}")
                }
            })
        }
    }

    fun cadastrarServico(servico: Service.CadastrarServicoDto) {
        viewModelScope.launch {
            val result = try {
                val response = apiService.cadastrarServico(servico).execute()
                if (response.isSuccessful) {
                    Result.success(response.body())
                } else {
                    Result.failure(Exception(response.errorBody()?.string()))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
            _cadastroStatus.postValue(result)
        }
    }

    private suspend fun saveToken(token: String) {
        context.tokenUsuario.edit { settings ->
            settings[stringPreferencesKey("token")] = token
        }
    }







}
