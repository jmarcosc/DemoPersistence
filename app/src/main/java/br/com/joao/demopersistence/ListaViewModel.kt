package br.com.joao.demopersistence

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import br.com.joao.demopersistence.dao.BancoDeDados
import br.com.joao.demopersistence.model.Game

class ListaViewModel(application: Application)
    : AndroidViewModel(application) {

    private val bd = BancoDeDados.getDatabase(
            application.applicationContext)

    var games: LiveData<List<Game>>? = null

    fun carregaGAmes() {
        games = bd?.gameDAO()?.lerGames()
    }
}