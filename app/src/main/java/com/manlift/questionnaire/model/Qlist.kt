package com.manlift.questionnaire.model

data class Qlist(
        val answer_a: String,
        val answer_b: String,
        val answer_c: String,
        val answer_d: String,
        val number: String,
        val question: String,
        var right_answer: Int,
        var selectedoption: Int
)