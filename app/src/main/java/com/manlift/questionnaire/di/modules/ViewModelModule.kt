package com.manlift.questionnaire.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.manlift.questionnaire.di.ViewModelFactory


import com.manlift.questionnaire.di.ViewModelKey
import com.manlift.questionnaire.viewmodel.QuestionnareViewModel
import com.manlift.questionnaire.viewmodel.SplashViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * All viewmodel class must be specified here
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(vm: SplashViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(QuestionnareViewModel::class)
    abstract fun bindDashBoardViewModel(vm: QuestionnareViewModel): ViewModel


    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory


}
