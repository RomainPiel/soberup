package com.romainpiel.soberup.ui.main

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.romainpiel.soberup.model.Drink
import com.romainpiel.soberup.repository.DrinkRepository
import com.romainpiel.soberup.utils.L
import org.threeten.bp.LocalDate
import javax.inject.Inject

class MainPresenter(private val view: MainView) : ValueEventListener {

    @Inject
    lateinit var drinkRepository: DrinkRepository

    fun onResume() {
        drinkRepository.subscribeToLatest(this)
    }

    fun onPause() {
        drinkRepository.unsubscribe(this)
    }

    override fun onCancelled(error: DatabaseError?) {
        L.e("onCanceled", error?.toException())
    }

    override fun onDataChange(snapshot: DataSnapshot?) {
        L.d(snapshot?.toString()!!)
        val lastDrink = snapshot?.children?.firstOrNull()?.getValue(Drink::class.java)
        val lastDrinkDate = LocalDate.parse(lastDrink?.date)
        val daysSinceLastDrink = LocalDate.now().compareTo(lastDrinkDate)
        view.setDaysSinceLastDrink(daysSinceLastDrink)
    }
}
