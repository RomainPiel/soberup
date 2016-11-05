package com.romainpiel.soberup.ui.main

import com.romainpiel.soberup.ui.ViewModel
import org.threeten.bp.LocalDate

class AddViewModel(var day: LocalDate = LocalDate.now(), var units: Int = 1) : ViewModel {
    override fun type(): Int = CardAdapter.Type.add
}
