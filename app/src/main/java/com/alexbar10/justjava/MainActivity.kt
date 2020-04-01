package com.alexbar10.justjava

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat

/**
 * This app displays an order form to order coffee
 */
class MainActivity : AppCompatActivity() {
    // Global variable for quantity of coffees
    private var numberOfCoffees = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked
     */
    fun submitOrder(view: View) {
        displayPrice(numberOfCoffees * 5)
    }

    /**
     * This method displays the given quantity value on the screen
     */
    private fun display(value: Int) {
        val quantityTextView = findViewById<TextView>(R.id.quantity_text_view)
        quantityTextView.text = value.toString()
    }

    /**
     * This method displays the given price on the screen
     */
    private fun displayPrice(price: Int) {
        val priceTextView = findViewById<TextView>(R.id.price_text_view)
        priceTextView.text = NumberFormat.getCurrencyInstance().format(price)
    }

    /**
     * Increment the quantity of coffees
     */
    fun increment(view: View) {
        numberOfCoffees += 1
        display(numberOfCoffees)
    }

    /**
     * Decrement the quantity of coffees
     */
    fun decrement(view: View) {
        numberOfCoffees -= 1
        display(numberOfCoffees)
    }
}
