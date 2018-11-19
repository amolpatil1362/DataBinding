package com.test.kotlin.di.appmodule

import com.test.kotlin.main.MainActivity
import com.test.kotlin.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActvityBuilder {

  @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
  abstract fun bindMainActivity(): MainActivity





  //@ContributesAndroidInjector -> With this annotation, we can easily attach activities/fragments to dagger graph
  // initially we were creating the module for each class to bridge it to graph but with the help of this annotation no need to create separate component for each class
}