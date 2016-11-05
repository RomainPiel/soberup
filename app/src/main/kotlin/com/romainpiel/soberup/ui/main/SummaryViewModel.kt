package com.romainpiel.soberup.ui.main

import com.romainpiel.soberup.ui.ViewModel

class SummaryViewModel(var daysCount: Int? = null) : ViewModel {
    override fun type(): Int = CardAdapter.Type.summary
}
