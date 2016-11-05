package com.romainpiel.soberup.ui.main

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import butterknife.bindView
import com.romainpiel.soberup.R
import com.romainpiel.soberup.dagger.ActivityModule
import com.romainpiel.soberup.ui.applicationComponent
import org.threeten.bp.LocalDate

class MainActivity : AppCompatActivity(), MainView, CardAdapter.OnClickListener {

    val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    lateinit var presenter: MainPresenter
    lateinit var adapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        DaggerMainActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
                .inject(presenter)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CardAdapter(this)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun setDaysSinceLastDrink(daysCount: Int?) = adapter.setDaysCount(daysCount)

    override fun onAddClicked(date: LocalDate, units: Int) = presenter.onAddClicked(date, units)

    override fun onDateClicked() {
        val dialog = DatePickerDialog(this)
        dialog.setOnDateSetListener { datePicker, year, month, dayOfMonth ->
            val date = LocalDate.of(year, month + 1, dayOfMonth)
            if (LocalDate.now() < date) {
                Toast.makeText(this, getString(R.string.date_in_future), Toast.LENGTH_SHORT).show()
            } else {
                adapter.setNewDrinkDate(date)
            }
        }
        dialog.show()
    }
    override fun onUnitsClicked() {
    }
}