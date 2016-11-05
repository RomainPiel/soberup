package com.romainpiel.soberup.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.dagger.ActivityModule
import com.romainpiel.soberup.ui.applicationComponent

class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter()

        DaggerMainActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(presenter)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val cards = listOf(TitleViewModel(), SummaryViewModel(10), AddViewModel())
        recyclerView.adapter = CardAdapter(cards)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}