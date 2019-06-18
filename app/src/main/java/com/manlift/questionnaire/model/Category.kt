package com.manlift.questionnaire.model

import java.util.*

data class Category(
        val cname: String,
        val name: String,
        val qlist: LinkedList<Qlist>
)