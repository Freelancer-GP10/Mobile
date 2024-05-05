import com.example.conecti.network.Service
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/usuarios")
    fun criarUsuario(@Body usuarioCriacaoDto: Service.UsuarioCriacaoDto): Response<Service.UsuarioResponse>
}
