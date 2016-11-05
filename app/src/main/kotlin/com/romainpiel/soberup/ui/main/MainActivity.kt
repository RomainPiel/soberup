package com.romainpiel.soberup.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.dagger.ActivityModule
import com.romainpiel.soberup.repository.DrinkRepository
import com.romainpiel.soberup.ui.applicationComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    @Inject
    lateinit var drinkRepository: DrinkRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(this))

        recyclerView.layoutManager = LinearLayoutManager(this)
        val cards = listOf(TitleViewModel(), SummaryViewModel(10), AddViewModel())
        recyclerView.adapter = CardAdapter(cards)
    }
}