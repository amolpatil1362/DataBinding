package com.test.kotlin.domain

import com.test.kotlin.model.genre.GetGenres
import rx.Observable

interface IUsecase {
  fun getGenreList(): Observable<GetGenres>
  //fun onResponse(response: Observable<GetGenres>)

}