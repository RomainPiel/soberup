package com.romainpiel.soberup.ui.main

import android.support.design.widget.FloatingActionButton
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.ui.ViewHolder
import com.romainpiel.soberup.ui.ViewModel
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit

class AddViewHolder(parent: ViewGroup?) : ViewHolder(R.layout.item_add, parent) {
    object ChangeType {
        val date = 0
        val units = 1
    }

    private val DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/uuuu")

    val day: Button by bindView(R.id.day)
    val unitMinus: Button by bindView(R.id.unit_minus)
    val units: TextView by bindView(R.id.units)
    val unitPlus: Button by bindView(R.id.unit_plus)
    val fab: FloatingActionButton by bindView(R.id.fab)

    var onClickListener: CardAdapter.OnClickListener? = null
        set

    override fun bind(viewModel: ViewModel, payloads: MutableList<Any>?) {
        val addViewModel = viewModel as AddViewModel
        if (payloads != null && payloads.size > 0) {
            payloads.forEach {
                when (it as Int) {
                    ChangeType.date -> setDate(addViewModel.day)
                    ChangeType.units -> setUnits(addViewModel.units)
                }
            }
            return
        }

        setDate(addViewModel.day)
        setUnits(addViewModel.units)

        day.setOnClickListener { onClickListener?.onDateClicked() }
        unitMinus.setOnClickListener { onClickListener?.onUnitMinusClicked() }
        unitPlus.setOnClickListener { onClickListener?.onUnitPlusClicked() }
        fab.setOnClickListener { onClickListener?.onAddClicked(addViewModel.day, addViewModel.units) }
    }

    private fun setDate(d: LocalDate) {
        val daysAgo = ChronoUnit.DAYS.between(d, LocalDate.now()).toInt()
        day.text = when(daysAgo) {
            0 -> itemView.resources.getString(R.string.today)
            1 -> itemView.resources.getString(R.string.yesterday)
            else -> d.format(DATE_FORMATTER)
        }
    }

    private fun setUnits(u: Int) {
        units.text = itemView.resources.getQuantityString(R.plurals.units_, u, u)
    }
}