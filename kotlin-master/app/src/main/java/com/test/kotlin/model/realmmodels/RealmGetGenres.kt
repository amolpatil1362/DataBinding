package com.test.kotlin.model.realmmodels

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class RealmGetGenres : RealmObject() {

  @SerializedName("genres")
  @Expose
  var genres: RealmList<RealmGenre>? = null
}