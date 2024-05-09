package com.example.conecti.network

import androidx.compose.runtime.MutableState

class Service {

    // Criação de usuário


    // Classe que representa a resposta do servidor ao criar um usuário
    data class UsuarioResponse (
        val email: String,
        val papel: String,
        val senha: String
    )

    // Classe que representa os dados de criação de usuário
    data class UsuarioCriacaoDto(
        val email: String,
        val papel: String,
        val senha: String
    )

    data class UsuarioTokenDto(
        val usuario: UsuarioLoginDto,
        val token: String
    )

    data class UsuarioLoginDto(
        val email: String,
        val senha: String
    )

}
