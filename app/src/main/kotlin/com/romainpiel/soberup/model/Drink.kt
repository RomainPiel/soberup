package com.romainpiel.soberup.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Drink(
        var date: String? = null,
        var units: Int? = null
)