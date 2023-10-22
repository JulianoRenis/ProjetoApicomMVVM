package br.com.sistemadereparo.projetoapicommvvm.data.model

data class Postagem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)