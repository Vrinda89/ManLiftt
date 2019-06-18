package com.manlift.questionnaire.view.dashboard

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import com.manlift.questionnaire.BR
import com.manlift.questionnaire.R
import com.manlift.questionnaire.databinding.ActivityQuestionnareBinding
import com.manlift.questionnaire.model.Qlist
import com.manlift.questionnaire.model.Questions
import com.manlift.questionnaire.view.base.BaseActivity
import com.manlift.questionnaire.viewmodel.QuestionnareViewModel


class QuestionnareActivity : BaseActivity<ActivityQuestionnareBinding, QuestionnareViewModel>(), NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener {


    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val bindingVariable: Int = BR.viewModel

    override val layoutId: Int = R.layout.activity_questionnare

    private var binding: ActivityQuestionnareBinding? = null
    private lateinit var questions: Questions
    override fun getViewModel(): Class<QuestionnareViewModel> {
        return QuestionnareViewModel::class.java
    }

    private var totalCategories = 0
    private var lastCategoryId = 0
    private var lastSelectedIndexInCategory = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    /**
     * Initial setup
     */
    private fun init() {
        binding = viewDataBinding
        binding?.toolbar?.title = getString(R.string.str_title)
        setSupportActionBar(binding?.toolbar)


        questions = viewModel.loadQuestions()

        totalCategories = questions.data.categoryList.size

        binding?.rbtnGroup?.setOnCheckedChangeListener(this)

        observeActions()


        updateUI(getCategoryName(), getNextQuestion())
    }

    /**
     * Updates the control button visibility
     */
    private fun updateButtons() {
        binding?.btnPrev?.visibility = if (hasPrev()) View.VISIBLE else View.GONE
        binding?.btnNext?.visibility = if (hasNext()) View.VISIBLE else View.GONE
        binding?.btnSkip?.visibility = if (hasNextCategory()) View.VISIBLE else View.GONE
        binding?.btnFinish?.visibility = if (!hasNext()) View.VISIBLE else View.GONE
        binding?.container?.visibility = View.VISIBLE
    }

    /**
     * Get the category name
     */
    private fun getCategoryName(): String {
        return questions.data.categoryList.get(lastCategoryId).cname
    }


    /**
     * Get the next question
     */
    private fun getNextQuestion(): Qlist {
        if (lastSelectedIndexInCategory == 3) {
            lastCategoryId += 1
            lastSelectedIndexInCategory = 0
        } else {
            lastSelectedIndexInCategory += 1
        }

        return questions.data.categoryList[lastCategoryId].qlist[lastSelectedIndexInCategory]
    }

    /**
     * Get the previous question
     */
    private fun getPrevQuestion(): Qlist {
        if (lastSelectedIndexInCategory == 0) {
            lastCategoryId -= 1
            lastSelectedIndexInCategory = 3
        } else {
            lastSelectedIndexInCategory -= 1
        }

        return questions.data.categoryList[lastCategoryId].qlist[lastSelectedIndexInCategory]
    }

    /**
     * Check if has next question available
     */
    private fun hasNext(): Boolean {
        return !(lastCategoryId == totalCategories - 1 && lastSelectedIndexInCategory == 3)
    }

    /**
     * Check if has previous question available
     */
    private fun hasPrev(): Boolean {
        return !(lastCategoryId == 0 && lastSelectedIndexInCategory == 0)
    }

    /**
     * Check if has next category available
     */
    private fun hasNextCategory(): Boolean {
        return lastCategoryId < totalCategories - 1
    }

    /**
     * Listenens next , prev , skip and finish action
     */
    private fun observeActions() {
        viewModel.onNextQuestion.observe(this, Observer {
            nextQuestionButtonSelected()
        })
        viewModel.onPreviousQuestion.observe(this, Observer {
            previousQuestionButtonSelected()
        })
        viewModel.onFinishTest.observe(this, Observer {
            finishAndPublishResult()
        })
        viewModel.onSkipCategory.observe(this, Observer {
            lastCategoryId += 1
            lastSelectedIndexInCategory = 0

            val question = questions.data.categoryList.get(lastCategoryId).qlist.get(lastSelectedIndexInCategory)
            val categoryName = getCategoryName()

            updateUI(categoryName, question)

        })

    }

    /**
     *  Verifies the answers and calculating the Score.
     */
    private fun finishAndPublishResult() {
        var unAttented = 0
        var correctAnswer = 0
        var totalQuestion = 0
        questions.data.categoryList.forEach {
            it.qlist.forEach { question ->
                totalQuestion += 1
                if (question.selectedoption == question.right_answer) correctAnswer += 1
                if (question.selectedoption <= 0) unAttented += 1
            }
        }
        showAlertDialog("$correctAnswer/$totalQuestion", this, "$unAttented/$totalQuestion")
    }

    /**
     * Update UI with previous question
     */
    private fun previousQuestionButtonSelected() {
        val prevQuestion = getPrevQuestion()
        val categoryName = getCategoryName()
        updateUI(categoryName, prevQuestion)
    }


    /**
     * Sets questions, category name and options to UI
     */
    private fun updateUI(cName: String, qlist: Qlist) {
        val question = qlist.question
        val questionNumber = qlist.number
        binding?.container?.visibility = View.INVISIBLE
        binding?.categoryName?.text = cName
        binding?.tvQuestionNumber?.text = questionNumber
        binding?.tvQuestion?.text = question
        binding?.rbtnOptionA?.text = qlist.answer_a
        binding?.rbtnOptionB?.text = qlist.answer_b
        binding?.rbtnOptionC?.text = qlist.answer_c
        binding?.rbtnOptionD?.text = qlist.answer_d
        binding?.rbtnGroup?.clearCheck()
        when (qlist.selectedoption) {
            1 -> binding?.rbtnOptionA?.isChecked = true
            2 -> binding?.rbtnOptionB?.isChecked = true
            3 -> binding?.rbtnOptionC?.isChecked = true
            4 -> binding?.rbtnOptionD?.isChecked = true
        }
        updateButtons()
    }

    /**
     * Set Next Question and option
     */
    private fun nextQuestionButtonSelected() {
        val nextQuestion = getNextQuestion()
        val categoryName = getCategoryName()
        updateUI(categoryName, nextQuestion)

    }


    /**
     * Radio button group check change listener
     */
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.rbtn_option_a -> updateAnswer(binding?.rbtnOptionA, 1)
            R.id.rbtn_option_b -> updateAnswer(binding?.rbtnOptionB, 2)
            R.id.rbtn_option_c -> updateAnswer(binding?.rbtnOptionC, 3)
            R.id.rbtn_option_d -> updateAnswer(binding?.rbtnOptionD, 4)
        }

    }

    /**
     * Updates the answer to the model
     */
    private fun updateAnswer(rbtn: RadioButton?, answer: Int) {
        rbtn?.let {
            if (it.isChecked) questions.data.categoryList[lastCategoryId].qlist[lastSelectedIndexInCategory].selectedoption = answer

        }
    }


}