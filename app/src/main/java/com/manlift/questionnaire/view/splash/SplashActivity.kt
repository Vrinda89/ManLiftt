package com.manlift.questionnaire.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.manlift.questionnaire.BR
import com.manlift.questionnaire.view.base.BaseActivity
import com.manlift.questionnaire.R
import com.manlift.questionnaire.databinding.ActivitySplashBinding
import com.manlift.questionnaire.view.dashboard.QuestionnareActivity
import com.manlift.questionnaire.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_splash

    private val mWaitHandler = Handler()

    public override fun getViewModel(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startDashboardActivity()
    }

    private fun startDashboardActivity() {
        mWaitHandler.postDelayed({
            try {
                val intent = Intent(this@SplashActivity, QuestionnareActivity::class.java)
                this@SplashActivity.startActivity(intent)
                this@SplashActivity.finish()
            } catch (ignored: Exception) {
                ignored.printStackTrace()
            }
        }, 3000)
    }


}
