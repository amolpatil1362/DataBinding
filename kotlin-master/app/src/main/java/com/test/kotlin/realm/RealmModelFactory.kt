package com.test.kotlin.realm

import com.test.kotlin.model.genre.Genre
import com.test.kotlin.model.realmmodels.RealmGenre
import io.realm.RealmList

class RealmModelFactory {

  companion object {

    fun getRealmGenreList(genreList: List<Genre>): RealmList<RealmGenre> {

      val realmGenreList = RealmList<RealmGenre>()

      for (genre: Genre in genreList) {
        realmGenreList.add(getRealmGenreModel(genre))

      }

      return realmGenreList

    }

    private fun getRealmGenreModel(genre: Genre): RealmGenre? {
      val realmGenre = RealmGenre()

      realmGenre.id = genre.id
      realmGenre.name = genre.name

      return realmGenre
    }

  }

}