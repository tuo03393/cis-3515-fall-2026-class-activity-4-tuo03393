package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        val numberArray = Array(20) {it -> (it +1) * 5}
        //println(numberArray)
        //IntArray's are functionally an array that contains integers.
        //For a language as strongly typed as Kotlin, it does not equal an array of ints.
        //So IntArray =/= Array<Int>

        /* In class versions- Given by another student.
        val numberArray = Array(size = 20){0}
        var counter = 5

        for (i in numberArray) {
        numberArray[i] = counter
        counter += 5
        // Teacher said this was a very java way of implementing it.
         */

        /* TODO Step 3: Create adapter to display items from array in Spinner */
        spinner.adapter = ArrayAdapter(this,
            android.R.layout.simple_dropdown_item_1line,
            numberArray.asList())

        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,    //parent
                p1: View?,              //view
                p2: Int,                //position
                p3: Long                //id
            ) {
                displayTextView.textSize = p0?.getItemAtPosition(p2).toString().toFloat()
                //Reason? Low coupling, high cohesion.
                //We want it to only know its parents & as few other places as possible.
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                    //We don't need this. It's for if you delete the last element.
            }
        }
    }
}