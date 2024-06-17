package com.example.conecti.Micro.NetworkMicro

class ServiceMicro {
    data class microDetailsDto(
        val nome: String,
        val sobrenome: String,
        val areaAtuacao: String,
        val linguagemDominio: String,
        val formacao: String,
        val cpf: String,
        val telefone: String
    )
}