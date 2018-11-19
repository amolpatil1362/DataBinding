package com.test.kotlin.main

import com.test.kotlin.domain.UsecaseController
import com.test.kotlin.realm.DatabaseManager
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityModule {

  /**
   * @Binds is the replacement for the @Provides
   *if we use @Bind then we will also need to mark our Module as abstract in this case, which is more efficient than a concrete one and thus makes @Binds more efficient.
   * @Provides methods are instance methods and they need an instance of our module in order to be invoked.
   * If our Module is abstract and contains @Binds methods, dagger will not instantiate our module and instead directly use the Provider of our injected parameter
   *
   *
   * In case, your Module has both @Provides and @Binds methods, you have two options :

    1.Simplest would be to mark your @Provides instance methods as static.
    2.If it is necessary to keep them as instance methods, then you can split your module into two and extract out all the @Binds methods into an abstract Module.
   */

  @Binds
  abstract fun provideMainView(mainActivity: MainActivity): IMainView


  @Module
  companion object {
    @JvmStatic @Provides fun provideMainPresenter(mainView: IMainView, usecaseController: UsecaseController, dbManager:DatabaseManager): MainPresenter {
      return MainPresenter(mainView, usecaseController, dbManager)
    }
  }
//https://github.com/google/dagger/issues/900

  /**
   * here for above method we can not use @Bind because
   * @Binds methods must have only one parameter whose type is assignable to the return type
   * If we have presenter having constructor having only one param then we can use @Bind
   */




}