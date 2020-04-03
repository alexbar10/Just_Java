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
        val price = calculatePrice()
        var priceMessage = "That would be $$price please"
        priceMessage += "\nThank you!"
        displayMessage(priceMessage)
    }

    /**
     * This method displays the given quantity value on the screen
     */
    private fun displayQuantity(number: Int) {
        val quantityTextView = findViewById<TextView>(R.id.quantity_text_view)
        quantityTextView.text = number.toString()
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
        displayQuantity(numberOfCoffees)
    }

    /**
     * Decrement the quantity of coffees
     */
    fun decrement(view: View) {
        numberOfCoffees -= 1
        displayQuantity(numberOfCoffees)
    }

    /**
     * This method display the given text on the screen
     */
    private fun displayMessage(message: String) {
        val priceTextView = findViewById<TextView>(R.id.price_text_view)
        priceTextView.text = message
    }

    /**
     * Calculates the price of the order based on the current quantity
     *
     * @return the total price
     */
    private fun calculatePrice() : Int {
        return numberOfCoffees * 5
    }
}
