package com.manlift.questionnaire.view.base

import android.app.ProgressDialog
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import com.manlift.questionnaire.R
import com.manlift.questionnaire.viewmodel.BaseViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private var mProgressDialog: ProgressDialog? = null

    protected lateinit var viewDataBinding: T

    protected lateinit var viewModel: V

    private var alertDialog: AlertDialog? = null


    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    protected abstract val bindingVariable: Int

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    protected abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    protected abstract fun getViewModel(): Class<V>


    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        this.viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        viewDataBinding.setVariable(bindingVariable, viewModel)
        viewDataBinding.executePendingBindings()
    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    fun showAlertDialog(score: String, mContext: Context, skipped: String) {
        val dialogBuilder = AlertDialog.Builder(mContext)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.article_custom_dialog_view, null)
        dialogBuilder.setView(dialogView)
        val txtViewScore = dialogView.findViewById<AppCompatTextView>(R.id.totalTV)
        val txtViewUnattended = dialogView.findViewById<AppCompatTextView>(R.id.skippedTV)
        txtViewScore.text = score
        txtViewUnattended.text = skipped
        val btnOk = dialogView.findViewById<AppCompatButton>(R.id.btnOK)
        btnOk.setOnClickListener {
            alertDialog?.dismiss()
            finish()
        }
        alertDialog = dialogBuilder.create()
        alertDialog?.show()
    }


}

