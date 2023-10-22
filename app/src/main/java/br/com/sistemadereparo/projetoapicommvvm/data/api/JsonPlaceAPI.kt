package br.com.sistemadereparo.projetoapicommvvm.data.api

import br.com.sistemadereparo.projetoapicommvvm.data.model.Postagem

import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceAPI {

    @GET("posts")
    suspend fun recuperarPostagens() : Response<List<Postagem>>

}