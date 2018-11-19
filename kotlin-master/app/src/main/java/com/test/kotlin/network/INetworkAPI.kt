package com.test.kotlin.network

import com.test.kotlin.model.genre.GetGenres
import retrofit2.http.GET
import retrofit2.http.Url
import rx.Observable

interface INetworkAPI {

  @GET
  fun getGenreData(@Url str: String): Observable<GetGenres>


}