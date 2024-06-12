package com.example.conecti.netWorkMIcro

import com.example.conecti.network.Service

class ServiceMicroDto {
    data class CadastrarEmpresaDto(
        val nome: String,
        val cnpj: String,
        val ramo: String,
        val telefone:String
    )

    data class Empresa(
        val id: Long,
        val nome: String,
        val cnpj: String,
        val ramo: String,
        val telefone: String,
        val email: String,
        val servicos: List<Empresa>,
        val usuario: Service.UsuarioResponse
    )
}