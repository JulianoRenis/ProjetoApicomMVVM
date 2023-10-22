package br.com.sistemadereparo.projetoapicommvvm.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.sistemadereparo.projetoapicommvvm.R
import br.com.sistemadereparo.projetoapicommvvm.data.api.RetrofitService
import br.com.sistemadereparo.projetoapicommvvm.data.repository.PostagemFirebaseRepository
import br.com.sistemadereparo.projetoapicommvvm.data.repository.PostagemRepository
import br.com.sistemadereparo.projetoapicommvvm.databinding.ActivityMainBinding
import br.com.sistemadereparo.projetoapicommvvm.presentation.viewmodel.MainViewModel
import br.com.sistemadereparo.projetoapicommvvm.presentation.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private  val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val jsonPlaceAPI = RetrofitService.recuperarJsonPlace()
        val postagemRepository = PostagemFirebaseRepository()
        //val postagemRepository = PostagemRepository(jsonPlaceAPI)

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(postagemRepository)
        )[MainViewModel::class.java]
       // mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.listaPostagens.observe(this){ listaPostagem ->

            var listaResultado=""
            listaPostagem.forEach {postagem->
                listaResultado+= "+ ${postagem.id }) ${postagem.title}\n"


            }
            binding.textResultado.text = listaResultado

        }
    }

    override fun onStart() {
        super.onStart()
        mainViewModel.recuperarPostagens()
    }
}