package com.example.conecti.network

import androidx.compose.runtime.MutableState
import java.util.Date

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

//    data class CadastrarFreelaDto(
//        val nome: String,
//        val sobrenome: String,
//        val areaAtuacao: String,
//        val linguagemDominio: String,
//        val formacao: String,
//        val cpf: String,
//        val telefone: String
//    )

    data class CadastrarFreelaDto(
        var nome: String,
        var sobrenome: String,
        var areaAtuacao: String,
        var linguagemDominio: String,
        var formacao: String,
        var cpf: String,
        var telefone: String
    )

    data class FreelancerResponse2(
        val id: Long,
        val nome: String,
        val sobrenome: String,
        val areaAtuacao: String,
        val linguagemDominio: String,
        val formacao: String,
        val cpf: String,
        val telefone: String,
        val email: String,
        val ativo: Boolean
    )


    data class FreelancerResponse(
        val id: Long,
        val nome: String,
        val sobrenome: String,
        val email: String,
        val telefone: String,
        val areaAtuacao: String,
        val linguagemDominio: String,
        val formacao: String,
        val cpf: String,
        val ativo: Boolean
    )



    data class UsuarioLoginDto(
        val email: String,
        val senha: String
    )

    data class UsuarioTokenDto(
        val userId: Long,
        val papel: String,
        val email: String,
        val token: String
    )

    data class ListarServicoDto(
        val id :Long,
        val nome:String,
        val prazo:Date,
        val dataInicio:Date,
        val valor:Double,
        val descricao:String
    )
    data class CadastrarServicoDto(
        val nome: String,
        val prazo: String,
        val dataInicio: String,
        val valor: Double,
        val descricao: String
    )


}
