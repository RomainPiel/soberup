package com.romainpiel.soberup.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import com.romainpiel.soberup.R

class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val cards = listOf(TitleViewModel(), SummaryViewModel(10), AddViewModel());
        recyclerView.adapter = CardAdapter(cards)
    }
}