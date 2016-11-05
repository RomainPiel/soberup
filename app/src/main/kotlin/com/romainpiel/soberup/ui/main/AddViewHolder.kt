package com.romainpiel.soberup.ui.main

import android.support.design.widget.FloatingActionButton
import android.view.ViewGroup
import android.widget.Button
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.ui.ViewHolder
import com.romainpiel.soberup.ui.ViewModel
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit

class AddViewHolder(parent: ViewGroup?) : ViewHolder(R.layout.item_add, parent) {
    private val DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uuuu")

    val day: Button by bindView(R.id.day)
    val units: Button by bindView(R.id.units)
    val fab: FloatingActionButton by bindView(R.id.fab)

    var onClickListener: CardAdapter.OnClickListener? = null
        set

    override fun bind(viewModel: ViewModel) {
        val addViewModel = viewModel as AddViewModel
        val daysAgo = ChronoUnit.DAYS.between(addViewModel.day, LocalDate.now()).toInt()
        day.text = when(daysAgo) {
            0 -> itemView.resources.getString(R.string.today)
            1 -> itemView.resources.getString(R.string.yesterday)
            else -> addViewModel.day.format(DATE_FORMATTER)
        }
        units.text = itemView.resources.getQuantityString(R.plurals.units_, addViewModel.units, addViewModel.units)

        day.setOnClickListener { onClickListener?.onDateClicked() }
        units.setOnClickListener { onClickListener?.onUnitsClicked() }
        fab.setOnClickListener { onClickListener?.onAddClicked(addViewModel.day, addViewModel.units) }
    }
}