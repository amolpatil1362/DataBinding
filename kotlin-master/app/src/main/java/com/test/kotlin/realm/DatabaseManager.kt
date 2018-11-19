package com.test.kotlin.realm

import android.util.Log
import com.test.kotlin.model.genre.Genre
import com.test.kotlin.model.realmmodels.RealmGenre
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

class DatabaseManager @Inject constructor() {

  fun saveGenres(genreList: List<Genre>) {
    val realme = Realm.getDefaultInstance()

    realme.executeTransaction { realm ->
      val realmGenreList = RealmModelFactory.getRealmGenreList(genreList)

     // Observable.from(realmGenreList)



      realm.copyToRealmOrUpdate(realmGenreList)
      Log.e("DATA SAVED","OK")

    }

  }

  fun getGenre(): RealmResults<RealmGenre>? {

    val realm = Realm.getDefaultInstance()
    return realm.where(RealmGenre::class.java).findAll()

  }

}





