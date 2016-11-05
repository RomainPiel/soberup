package com.romainpiel.soberup.ui.main

import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.ui.ViewHolder
import com.romainpiel.soberup.ui.ViewModel

class SummaryViewHolder(parent: ViewGroup?) : ViewHolder(R.layout.item_summary, parent) {
    object ChangeType {
        val daysCount = 0
    }

    val description: TextView by bindView(R.id.description)

    override fun bind(viewModel: ViewModel, payloads: MutableList<Any>?) {
        val summaryViewModel = viewModel as SummaryViewModel
        if (payloads != null && payloads.size > 0) {
            payloads.forEach {
                when (it as Int) {
                    SummaryViewHolder.ChangeType.daysCount -> setDaysCount(summaryViewModel.daysCount)
                }
            }
            return
        }

        setDaysCount(summaryViewModel.daysCount)
    }

    private fun setDaysCount(daysCount: Int?) {
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