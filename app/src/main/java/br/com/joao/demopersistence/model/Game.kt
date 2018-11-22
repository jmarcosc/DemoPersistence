package br.com.joao.demopersistence.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Game {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var nome: String? = null
    var plataforma: String? = null

    constructor()


    constructor(nome: String, plataforma: String) {
        this.nome = nome
        this.plataforma = plataforma
    }
}