package com.test.kotlin.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.test.kotlin.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button
import kotlinx.android.synthetic.main.activity_main.button2
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), IMainView {

  @Inject
  lateinit var mainPresenter: MainPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    Log.e("Dagger2", "In application class")
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    button.setOnClickListener(View.OnClickListener {
      mainPresenter?.getGenreList()
    })

    button2.setOnClickListener(View.OnClickListener {
      Toast.makeText(this, mainPresenter.getData(), Toast.LENGTH_SHORT).show()
    })

  }

  override fun showGenreList() {//write something
  }
}
