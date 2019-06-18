package com.manlift.questionnaire.viewmodel

import com.manlift.questionnaire.core.liveevent.SingleLiveEvent
import com.manlift.questionnaire.core.repository.MainRepository
import com.manlift.questionnaire.model.Questions
import javax.inject.Inject

class QuestionnareViewModel @Inject constructor(private val mainRepository: MainRepository) : BaseViewModel() {

    val onNextQuestion = SingleLiveEvent<Void>()
    val onPreviousQuestion = SingleLiveEvent<Void>()
    val onSkipCategory = SingleLiveEvent<Void>()
    val onFinishTest = SingleLiveEvent<Void>()

    fun onNextQuestionClicked() {
        onNextQuestion.call()
    }

    fun onPreviouswQuestion() {
        onPreviousQuestion.call()
    }

    fun onSkipCategory() {
        onSkipCategory.call()
    }

    fun onFinish() {
        onFinishTest.call()
    }

    fun loadQuestions(): Questions {
        return mainRepository.getQuestions()
    }


}
