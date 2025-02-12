package com.cleanFood.exceptions

import java.util.Date

class ExceptionMessage (
    val timestap: Date,
    val message: String? = null,
    val details: String,
)