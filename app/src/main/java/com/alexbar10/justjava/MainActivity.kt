package com.alexbar10.justjava

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

/**
 * This app displays an order form to order coffee
 */
class MainActivity : AppCompatActivity() {
    // Global variable for quantity of coffees
    private var numberOfCoffees = 98

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked
     */
    fun submitOrder(view: View) {
        val price = calculatePrice(whipped_cream_check_box.isChecked, chocolate_checkbox.isChecked)
        displayMessage(createOrderSummary(price, whipped_cream_check_box.isChecked, chocolate_checkbox.isChecked, name_edit_text.text.toString()))
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
        if (numberOfCoffees < 100) {
            numberOfCoffees += 1
            displayQuantity(numberOfCoffees)
        } else {
            Toast.makeText(this, "Can not serve more than 100 coffees", Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Decrement the quantity of coffees
     */
    fun decrement(view: View) {
        if (numberOfCoffees > 1) {
            numberOfCoffees -= 1
            displayQuantity(numberOfCoffees)
        } else {
            Toast.makeText(this, "Can not serve less than one coffee", Toast.LENGTH_LONG).show()
        }
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
     * @param addWhippedCream is whether or not the user wants whipper cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return the total price
     */
    private fun calculatePrice(addWhippedCream: Boolean, addChocolate: Boolean) : Int {
        var extraWhippedCream = 0
        var extraChocolate = 0
        if (addWhippedCream) {
            extraWhippedCream = 1
        }
        if (addChocolate) {
            extraChocolate = 2
        }
        return numberOfCoffees * (5 + extraWhippedCream + extraChocolate)
    }

    /**
     * Order summary
     * @param price the price for the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return the order summary
     */
    private fun createOrderSummary(price: Int, addWhippedCream: Boolean, addChocolate: Boolean, name: String): String {
        return "Name: $name\nAdd whipped cream? $addWhippedCream \nAdd chocolate? $addChocolate \nQuantity: $numberOfCoffees\nTotal: $$price\nThank you!"
    }
}
