package com.romainpiel.soberup.ui.main

import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.ui.ViewHolder
import com.romainpiel.soberup.ui.ViewModel

class SummaryViewHolder(parent: ViewGroup?) : ViewHolder(R.layout.item_summary, parent) {
    val description: TextView by bindView(R.id.description)

    override fun bind(viewModel: ViewModel) {
        val summaryViewModel = viewModel as SummaryViewModel
        val daysCount = summaryViewModel.daysCount
        description.text =
                when (daysCount) {
                    null ->
                        ""
                    0 ->
                        itemView.resources.getText(R.string.summary_description_zero)
                    else ->
                        itemView.resources.getQuantityString(R.plurals.summary_description_, daysCount, daysCount)
                }
    }
}