package br.com.sistemadereparo.projetoapicommvvm.api

import br.com.sistemadereparo.projetoapicommvvm.model.Postagem

import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceAPI {

    @GET("posts")
    suspend fun recuperarPostagens() : Response<List<Postagem>>

}