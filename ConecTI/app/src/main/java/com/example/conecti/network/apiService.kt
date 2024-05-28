import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.conecti.netWorkFreela.ServiceFreela
import com.example.conecti.netWorkMIcro.ServiceMicro
import com.example.conecti.network.Service
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
val Context.tokenUsuario: DataStore<Preferences> by preferencesDataStore("token")

interface ApiService {
    @POST("/api/usuarios")
    fun criarUsuario(@Body usuarioCriacaoDto: Service.UsuarioCriacaoDto): Call<Service.UsuarioResponse>

    @POST("/api/usuarios/login")
    fun login(@Body usuarioLoginDto: Service.UsuarioLoginDto): Call<Service.UsuarioTokenDto>

//    @POST("/freelancers")
//    fun cadastrarFreelancer(@Body cadastrarFreelaDto: RequestBody): Call<Service.FreelancerResponse>
    @POST("/usuarios")
    fun cadastrarFreelancer(@Body freelancer: ServiceFreela.freelaDetailsDto): Call<Void>
    @POST("api/empresa")
    fun cadastrarEmpresa(@Body empresa: ServiceMicro.CadastrarEmpresaDto): Call<ServiceMicro.Empresa>
   // @POST("/cadastrarFreelancer")
    //fun cadastrarFreelancer(@Body freelaDto: ServiceFreela.freelaDetailsDto): Call<Void>

}
