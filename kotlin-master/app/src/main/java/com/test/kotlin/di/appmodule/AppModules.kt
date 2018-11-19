package com.test.kotlin.di.appmodule

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class AppModules {
  @Binds
  abstract fun provideContext(application: Application): Context

  @Binds fun provideRealm(){
    return
  }

}