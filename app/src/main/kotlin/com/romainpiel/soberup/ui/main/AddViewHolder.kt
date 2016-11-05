package com.romainpiel.soberup.ui.main

import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.ui.ViewHolder
import com.romainpiel.soberup.ui.ViewModel
import org.threeten.bp.LocalDate

class AddViewHolder(parent: ViewGroup?) : ViewHolder(R.layout.item_add, parent) {
    val day: TextView by bindView(R.id.day)
    val units: TextView by bindView(R.id.units)

    override fun bind(viewModel: ViewModel) {
        val addViewModel = viewModel as AddViewModel
        val daysAgo = LocalDate.now().compareTo(addViewModel.day)
        day.text = when(daysAgo) {
            0 -> itemView.resources.getString(R.string.today)
            1 -> itemView.resources.getString(R.string.yesterday)
            else -> itemView.resources.getString(daysAgo, R.string.days_ago_)
        }
        units.text = itemView.resources.getQuantityString(R.plurals.units_, addViewModel.unitCount, addViewModel.unitCount)
    }
}