package com.alexbar10.justjava

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This app displays an order form to order coffee
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked
     */
    fun submitOrder(view: View) {
        display(1)
    }

    /**
     * This method displays the given quantity value on the screen
     */
    private fun display(value: Int) {
        val quantityTextView = findViewById<TextView>(R.id.quantity_text_view)
        quantityTextView.text = value.toString()
    }
}
