package br.com.joao.demopersistence

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.joao.demopersistence.model.Game
import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.content_lista.*

class ListaActivity : AppCompatActivity() {

    lateinit var listaViewModel: ListaViewModel

    lateinit var gameAdapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        iniciaViewModel()

        inicializaRecyclerView()

        listaViewModel.carregaGAmes()

        listaViewModel.games?.observe(this,
                Observer<List<Game>> {
                    gameAdapter.setList(it!!)
                    rvGames.adapter.notifyDataSetChanged()
                })

        fab.setOnClickListener {
            NovoGameDialog().show(fragmentManager, "CriarJogo")
        }

    }

    private fun inicializaRecyclerView() {
        //Cria uma lista na vertical
        rvGames.layoutManager = LinearLayoutManager(this)
        gameAdapter = GameAdapter(listOf())
        rvGames.adapter = gameAdapter
    }

    private fun iniciaViewModel() {
        listaViewModel = ViewModelProviders
                .of(this)
                .get(ListaViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences = getSharedPreferences("meuapp",
                Context.MODE_PRIVATE)

        val usuario = sharedPreferences
                .getString("USUARIO", "Nao informado")

        tvNome.text = usuario
    }

}
