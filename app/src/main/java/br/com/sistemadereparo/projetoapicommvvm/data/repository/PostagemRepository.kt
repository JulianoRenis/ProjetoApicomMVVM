package br.com.sistemadereparo.projetoapicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import br.com.sistemadereparo.projetoapicommvvm.data.api.JsonPlaceAPI
import br.com.sistemadereparo.projetoapicommvvm.data.model.Postagem

class PostagemRepository(
    private val jsonPlaceAPI: JsonPlaceAPI
) :IPostagemRepository{

    override val listaPostagensRepository = MutableLiveData<List<Postagem>>()
    override suspend fun recuperarPostagens()  {



        try {
            val retorno = jsonPlaceAPI.recuperarPostagens()
            if( retorno.isSuccessful && retorno.body() != null ){

                listaPostagensRepository.postValue(retorno.body())

            }
        }catch (erroRecuperarPostagem: Exception){
            erroRecuperarPostagem.printStackTrace()
        }


    }

}