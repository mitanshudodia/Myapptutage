package com.example.myapptutage

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDate.setOnClickListener {view ->

            clickDatePicker(view)
        }
    }


    fun clickDatePicker(view : View){
        var myCalender = Calendar.getInstance()
        val i = myCalender.get(Calendar.YEAR)
        val i2 = myCalender.get(Calendar.MONTH)
        val i3 = myCalender.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    Toast.makeText(this, "The chosen date is $i3/${i2+1}/$i", Toast.LENGTH_LONG).show()

                    val selectedDate = "$i3/${i2 + 1}/$i"
                    tvSelectedDate.setText(selectedDate)
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    val theDate = sdf.parse(selectedDate)

                    val selectedDateInMinutes = theDate!!.time/60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    val currentDateToMinutes = currentDate!!.time/60000
                    val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
                    tvSelectedDateInMinutes.setText(differenceInMinutes.toString())


                }, i, i2, i3).show()
    }

}