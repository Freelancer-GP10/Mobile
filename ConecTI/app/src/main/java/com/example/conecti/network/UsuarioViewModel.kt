import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conecti.RetrofitClient.connection
import com.example.conecti.RetrofitClient.getToken
import com.example.conecti.netWorkFreela.ServiceFreela
import com.example.conecti.network.Service
import com.example.conecti.network.Service.UsuarioCriacaoDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
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
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    private val _cadastroFreela = MutableStateFlow(Service.CadastrarFreelaDto("", "", "", "", "", "", ""))
  //  val cadastroFreela: StateFlow<Service.CadastrarFreelaDto> = _cadastroFreela

    private val _cadastroStatus = MutableLiveData<Result<Void?>>()
//    val cadastroStatus: LiveData<Result<Void?>> = _cadastroStatus
//
//    // Função para atualizar os dados do freelancer
//    fun atualizarCadastroFreela(novoCadastro: Service.CadastrarFreelaDto) {
//        _cadastroFreela.value = novoCadastro
//    }

    var nome = mutableStateOf("")
//    var sobrenome = mutableStateOf("")
//    var cpf = mutableStateOf("")
//    var telefone = mutableStateOf("")
//    var areaAtuacao = mutableStateOf("")
//    var linguagemDominio = mutableStateOf("")
//    var formacao = mutableStateOf("")

//    fun enviarDados() {
//        viewModelScope.launch {
//            // Crie o DTO com os dados
//            val freelaDto = Service.CadastrarFreelaDto(
//                nome = nome.value,
//                sobrenome = sobrenome.value,
//                cpf = cpf.value,
//                telefone = telefone.value,
//                areaAtuacao = areaAtuacao.value,
//                linguagemDominio = linguagemDominio.value,
//                formacao = formacao.value
//            )
//            // Envie o DTO ao servidor usando Retrofit
//        }
//    }


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
//    suspend fun getToken(): String? { // Alteração 1: Nome da função getToken foi corrigido e usada a mesma para obter o token
//        val tokenKey = stringPreferencesKey("token")
//        val dataStore = context.dataStore
//        val preferences = dataStore.data.map { preferences ->
//            preferences[tokenKey]
//        }.first()
//        return preferences
//    }

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
            val token = getToken2()

            val call = apiService.getProximosServicos(token!!)
            if(token.isEmpty() || token==null){
                println("Token não encontrado")
            }
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
            val token = getToken2()
            if (token != null) {
                Log.i("api", "Token: $token")
                Log.i("api", "Dados do serviço: $servico")

                apiService.cadastrarServico("Bearer $token", servico).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            println("servico cadastrado com sucesso")
                            Log.i("api", "servico cadastrado com sucesso")
                        } else {
                            println("Erro ao cadastrar servico: ${response.errorBody()?.string()}")
                            erroApi.postValue("Erro ao cadastrar servico: ${response.errorBody()?.string()}")
                        }
                    }
                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        println("Falha ao cadastrar servico : ${t.message}")
                        erroApi.postValue("Falha ao cadastrar servico 2: ${t.message}")
                    }
                })
            //    _cadastroStatus.postValue(result)
            } else {
                _cadastroStatus.postValue(Result.failure(Exception("Token não encontrado")))
            }
        }
    }


    fun cadastrarFreelancer(freelaDto: ServiceFreela.freelaDetailsDto) {
        viewModelScope.launch {
            val token = getToken2()
            if (token != null) {
                apiService.cadastrarFreelancer("Bearer $token", freelaDto).enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                        if (response.isSuccessful) {
                            println("Freelancer cadastrado com sucesso")
                        } else {
                            println("Erro ao cadastrar freelancer: ${response.errorBody()?.string()}")
                            erroApi.postValue("Erro ao cadastrar freelancer: ${response.errorBody()?.string()}")
                        }
                    }
                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        println("Falha ao cadastrar freelancer: ${t.message}")
                        erroApi.postValue("Falha ao cadastrar freelancer: ${t.message}")
                    }
                })
            }
        }
    }

    private suspend fun saveToken(token: String) {
        context.tokenUsuario.edit { settings ->
            settings[stringPreferencesKey("token")] = token
        }
    }

    public suspend fun getToken2(): String? {
        val preferences = context.tokenUsuario.data.first()
        return preferences[stringPreferencesKey("token")]
    }
}
