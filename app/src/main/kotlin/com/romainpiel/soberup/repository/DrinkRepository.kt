package com.romainpiel.soberup.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.romainpiel.soberup.model.Drink

class DrinkRepository(private val drinksDbReference: DatabaseReference) {
    fun subscribeToLatest(valueEventListener: ValueEventListener) {
        drinksDbReference.orderByChild("date")
                .limitToLast(1)
                .addValueEventListener(valueEventListener)
    }
    fun unsubscribe(valueEventListener: ValueEventListener) {
        drinksDbReference.removeEventListener(valueEventListener)
    }
    fun add(drink: Drink) {
        drinksDbReference.push().setValue(drink)
    }
}