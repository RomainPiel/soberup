package com.romainpiel.soberup.ui.main

import com.romainpiel.soberup.ui.ViewModel

class SummaryViewModel(val daysCount: Int) : ViewModel {
    override fun type(): Int = CardAdapter.Type.summary
}
