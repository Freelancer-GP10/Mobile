import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.conecti.netWorkFreela.ServiceFreela
import com.example.conecti.netWorkMIcro.ServiceMicroDto
import com.example.conecti.network.Service
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
val Context.tokenUsuario: DataStore<Preferences> by preferencesDataStore("token")

interface ApiService {
    @POST("/api/usuarios")
    fun criarUsuario(@Body usuarioCriacaoDto: Service.UsuarioCriacaoDto): Call<Service.UsuarioResponse>

    @POST("/api/usuarios/login")
    fun login(@Body usuarioLoginDto: Service.UsuarioLoginDto): Call<Service.UsuarioTokenDto>

//    @POST("/freelancers")
//    fun cadastrarFreelancer(@Body cadastrarFreelaDto: RequestBody): Call<Service.FreelancerResponse>
    @POST("/api/freelancer")
    fun cadastrarFreelancer(
    @Header("Authorization") token: String,
    @Body freelaDto: ServiceFreela.freelaDetailsDto
    ): Call<Void>
    @POST("/api/empresa")
    fun cadastrarEmpresa(
        @Header("Authorization") token: String,
        @Body empresa: ServiceMicroDto.CadastrarEmpresaDto): Call<ServiceMicroDto.Empresa>
   // @POST("/cadastrarFreelancer")
    //fun cadastrarFreelancer(@Body freelaDto: ServiceFreela.freelaDetailsDto): Call<Void>
   @GET("/lista-proximos-servicos")
   fun getProximosServicos(

   ): Call<List<Service.ListarServicoDto>>
    @POST("/api/servicos")
    fun cadastrarServico(@Body cadastrarServicoDto: Service.CadastrarServicoDto): Call<Void>
}
