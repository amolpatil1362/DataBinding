package com.test.kotlin.main

import android.util.Log
import com.test.kotlin.domain.UsecaseController
import com.test.kotlin.model.genre.Genre
import com.test.kotlin.model.genre.GetGenres
import com.test.kotlin.realm.DatabaseManager
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(
        view: IMainView,
        usecaseController: UsecaseController,
        dbManager: DatabaseManager
) : IMainPresenter {
    var mainView: IMainView

    var genreUsecaseController: UsecaseController

    private val TAG: String = javaClass.simpleName

    private var mDbManager: DatabaseManager

    init {
        mainView = view
        genreUsecaseController = usecaseController
        mDbManager = dbManager

    }

    override fun getGenreList() {//write something

        onResponse(genreUsecaseController.getGenreList())

    }

    private fun getMovieDetails(genreList: List<Genre>?) {

        Observable.from(genreList)
                .observeOn(Schedulers.newThread())
                //.subscribeOn(Schedulers.newThread())
                .subscribe(
                        object : Subscriber<Genre>() {
                            override fun onNext(t: Genre?) {//write something
                                Log.e(TAG + "Items ...", t?.id.toString())

                            }

                            override fun onCompleted() {//write something
                                Log.e(TAG + "Items ...", "OnComplete new thread")

                            }

                            override fun onError(e: Throwable?) {//write something
                            }

                        }
                )

        Observable.just(genreList).subscribe { }
    }

    private fun onResponse(genreList: Observable<GetGenres>) {
        //genreList  -> observable

        var subscription = genreList
                .subscribeOn(Schedulers.io())                     // scheduler
                .observeOn(AndroidSchedulers.mainThread())             // scheduler
                .subscribe(object : Subscriber<GetGenres>() {          //observer
                    override fun onNext(t: GetGenres?) {
                        // t?.genres=null
                        Log.e(TAG + "...main", t?.genres?.get(0)?.name)

                        t?.genres?.let { mDbManager.saveGenres(it) }

                        val result = t?.genres

                        getMovieDetails(result)
                    }

                    override fun onCompleted() {
                        Log.e(TAG, "OnComplete main thread")
                    }

                    override fun onError(e: Throwable?) {
                        Log.e(TAG, e.toString())
                    }

                })

    }

    fun getData(): String? {

        return when {
            mDbManager.getGenre()!!.size > 0 -> {

                mDbManager.getGenre()?.get(0)?.name
            }
            else -> {
                "Press Button 1"
            }
        }
    }
}