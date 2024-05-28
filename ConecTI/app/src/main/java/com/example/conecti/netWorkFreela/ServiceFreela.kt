package com.example.conecti.netWorkFreela

class ServiceFreela {
    data class freelaDetailsDto(
        val nome: String,
        val sobrenome: String,
        val areaAtuacao: String,
        val linguagemDominio: String,
        val formacao: String,
        val cpf: String,
        val telefone: String
    )
}