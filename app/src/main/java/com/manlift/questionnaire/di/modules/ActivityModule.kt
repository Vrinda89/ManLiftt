package com.manlift.questionnaire.di.modules


import com.manlift.questionnaire.view.dashboard.QuestionnareActivity
import com.manlift.questionnaire.view.splash.SplashActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All Activity must be specified here
 */

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeSplash(): SplashActivity

    @ContributesAndroidInjector
    internal abstract fun contributeDashBoard(): QuestionnareActivity


}
