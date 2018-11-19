package com.test.kotlin.di.appcomponents

import com.test.kotlin.di.appmodule.ActvityBuilder
import com.test.kotlin.di.appmodule.AppModules
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class, //: We didn’t create this. It is an internal class in Dagger 2.10. Provides our activities and fragments with given module.
        ActvityBuilder::class,// We map all our activities here. And Dagger know our activities in compile time
        AppModules::class
    )
)
interface AppComponents : AndroidInjector<DaggerApplication> {

 // fun inject(app: App)

 // override fun inject(instance: DaggerApplication)

  /*@Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder  //this get called from App class

    fun build(): AppComponents  //this get called from App class    method which returns your Component.
  }*/


  @Component.Builder abstract class Builder : AndroidInjector.Builder<DaggerApplication>()
}