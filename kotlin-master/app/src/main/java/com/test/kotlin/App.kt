package com.test.kotlin

import com.test.kotlin.di.appcomponents.DaggerAppComponents
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration

class App : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {//write something

    /* val appComponent = DaggerAppComponents
        .builder()
        .application(this)
        .build()

    appComponent.inject(this)
    return appComponent*/
    return DaggerAppComponents.builder().create(this)

  }

  override fun onCreate() {
    super.onCreate()
    //realm

    Realm.init(applicationContext)

    val config: RealmConfiguration

    config = RealmConfiguration.Builder()
        .schemaVersion(0)
        .build()

    Realm.setDefaultConfiguration(config)
  }
}