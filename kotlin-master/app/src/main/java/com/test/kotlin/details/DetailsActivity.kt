package com.test.kotlin.details

import android.os.Bundle
import android.widget.TextView
import com.test.kotlin.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        tv.setText("Test")


    }
}