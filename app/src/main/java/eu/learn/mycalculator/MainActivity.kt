package eu.learn.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvinput : TextView? = null
    var lastdot : Boolean = false
    var lastNumeric : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvinput = findViewById(R.id.tv_input)
    }

    fun onDigit(view: View){
        tvinput?.append((view as Button).text)
        lastNumeric = true
        lastdot = false
    }

    fun onClear(view: View){
        tvinput?.text = ""
    }

    fun onDecimalPoint(view: View){
        if (lastNumeric && !lastdot){
            tvinput?.append(".")
            lastNumeric = false
            lastdot = true
        }
    }

    fun onOperator(view: View){
        tvinput?.text?.let {
            if (lastNumeric && !isOperationAdded(it.toString())){
                tvinput?.append((view as Button).text)
                lastNumeric = false
                lastdot = false
            }
        }
    }

    private fun isOperationAdded(value : String) : Boolean{
        return if (value.startsWith("-")){
            false
        }else {
            value.contains("-")
                    || value.contains("+")
                    || value.contains("x")
                    || value.contains("÷")
        }
    }
}