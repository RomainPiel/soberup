package com.romainpiel.soberup.ui.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.romainpiel.soberup.ui.ViewHolder
import com.romainpiel.soberup.ui.ViewModel
import com.romainpiel.soberup.utils.Screen
import org.threeten.bp.LocalDate

class CardAdapter(val onClickListener: OnClickListener) : RecyclerView.Adapter<ViewHolder>() {
    object Type {
        val title = 0
        val summary = 1
        val add = 2
    }

    val items: List<ViewModel> = listOf(TitleViewModel(), SummaryViewModel(), AddViewModel())

    fun setDaysCount(daysCount: Int?) {
        val itemPosition = 1
        val summaryViewModel = items.get(itemPosition) as SummaryViewModel
        summaryViewModel.daysCount = daysCount
        notifyItemChanged(itemPosition)
    }

    fun setNewDrinkDate(date: LocalDate) {
        val itemPosition = 2
        val addViewModel = items.get(itemPosition) as AddViewModel
        addViewModel.day = date
        notifyItemChanged(itemPosition)
    }

    fun decrementNewDrinkUnits() {
        val itemPosition = 2
        val addViewModel = items.get(itemPosition) as AddViewModel
        if (addViewModel.units == 1) return
        addViewModel.units--
        notifyItemChanged(itemPosition)
    }

    fun incrementNewDrinkUnits() {
        val itemPosition = 2
        val addViewModel = items.get(itemPosition) as AddViewModel
        addViewModel.units++
        notifyItemChanged(itemPosition)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(items[position])
        holder?.itemView?.elevation = Screen.dpToPx((itemCount - position) * 10)
        if (getItemViewType(position) == Type.add) {
            (holder as AddViewHolder).onClickListener = onClickListener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return when (viewType) {
            Type.title -> TitleViewHolder(parent)
            Type.summary -> SummaryViewHolder(parent)
            Type.add -> AddViewHolder(parent)
            else -> throw RuntimeException("Unknown type " + viewType)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type()
    }

    interface OnClickListener {
        fun onDateClicked()
        fun onUnitMinusClicked()
        fun onUnitPlusClicked()
        fun onAddClicked(date: LocalDate, units: Int)
    }
}