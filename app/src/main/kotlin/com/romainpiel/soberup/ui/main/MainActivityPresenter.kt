package com.romainpiel.soberup.ui.main

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.romainpiel.soberup.repository.DrinkRepository
import com.romainpiel.soberup.utils.L
import javax.inject.Inject

class MainActivityPresenter : ValueEventListener {

    @Inject
    lateinit var drinkRepository: DrinkRepository

    fun onResume() {
        drinkRepository.subscribe(this)
    }

    fun onPause() {
        drinkRepository.unsubscribe(this)
    }

    override fun onCancelled(error: DatabaseError?) {
        L.e("onCanceled", error?.toException())
    }

    override fun onDataChange(snapshot: DataSnapshot?) {
        L.d(snapshot?.toString()!!)
    }
}
