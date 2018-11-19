package com.test.kotlin.network

import android.net.Uri

class GetGenereAPI {
  val apiKey: String = "f17e9c5e6c34ad9dc2bf6aab852c0cc7"
  val key: String = "api_key"

  fun buildApiParam(): NetworkRequest {

    val networkRequest = NetworkRequest()

    val builtUri = Uri.parse(Urls().GET_GENRE_LIST_URL)
        .buildUpon()
        .appendQueryParameter(key, apiKey)
        .build()

    networkRequest.setUrl(builtUri.toString())

    return networkRequest

  }
}