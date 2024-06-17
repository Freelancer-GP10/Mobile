import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiUsuario {
    @POST("login") // Substitua "login" pelo endpoint correto da sua API
    suspend fun fazerLogin(@Body usuarioLoginDto: UsuarioLoginDto): Response<Any>
}
