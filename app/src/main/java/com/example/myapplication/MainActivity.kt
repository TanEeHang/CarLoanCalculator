package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_cal = findViewById(R.id.submit) as Button

        btn_cal.setOnClickListener(){
          calculation(it)
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        }


    }

    private fun calculation(view: View){
        var price = findViewById<EditText>(R.id.carPrice).text.toString()
        var down = findViewById<EditText>(R.id.dPAmount).text.toString()
        var loanP = findViewById<EditText>(R.id.loanPeriod).text.toString()
        var interestR = findViewById<EditText>(R.id.interestRate).text.toString()

        var carLoan = price.toDouble() - down.toDouble()
        var interest = carLoan.toDouble() * (interestR.toDouble()/100) * loanP.toDouble()
        var month = (carLoan.toDouble() + interest.toDouble()) / loanP.toDouble() / 12


        textView5.text = "Car Loan = RM %.2f".format(carLoan).toString()
        textView6.text = "Interest = RM %.2f".format(interest).toString()
        textView7.text = "Monthly Repayment = RM %.2f".format(month).toString()

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }


}
