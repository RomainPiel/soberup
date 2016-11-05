package com.romainpiel.soberup.repository

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class DrinkRepository(private val drinksDbReference: DatabaseReference) {
    fun subscribe(valueEventListener: ValueEventListener) {
        drinksDbReference.addValueEventListener(valueEventListener)
    }
    fun unsubscribe(valueEventListener: ValueEventListener) {
        drinksDbReference.removeEventListener(valueEventListener)
    }
}