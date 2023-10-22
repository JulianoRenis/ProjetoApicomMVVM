package br.com.sistemadereparo.projetoapicommvvm.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.sistemadereparo.projetoapicommvvm.data.model.Postagem
import br.com.sistemadereparo.projetoapicommvvm.data.repository.IPostagemRepository
import br.com.sistemadereparo.projetoapicommvvm.data.repository.PostagemRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: IPostagemRepository
) : ViewModel(

) {

    var listaPostagens = MutableLiveData<List<Postagem>>()
        get()=repository.listaPostagensRepository
    fun recuperarPostagens(){


        viewModelScope.launch {
            repository.recuperarPostagens()

        }
    }
}