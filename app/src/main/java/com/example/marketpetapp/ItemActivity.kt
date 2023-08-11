package com.example.marketpetapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast.*
import org.json.JSONObject

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = this.findViewById(R.id.itemListTitle1)
        val text: TextView = this.findViewById(R.id.item_list_text)
        val btn: TextView = this.findViewById(R.id.buttonBuy)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
       /* btn.setOnClickListener{
            startPayment()
        }
*/
     /*   Checkout.preload(getApplicationContext())
        val co = Checkout()
        co.setKeyID("rzp_test_EgmQoGwAT33eJi");

    }
    private fun startPayment() {
        *//*
        *  You need to pass the current activity to let Razorpay create CheckoutActivity
        * *//*
        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Fedorov Inc")
            options.put("description","Demoing Charges")
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#f00")
            options.put("currency","USD")
            options.put("order_id", "order_DBJOWzybf0sJbb")
            options.put("amount",10000)

            co.open(activity,options)
        }catch (e: Exception){
            makeText(activity,"Error in payment: "+ e.message, LENGTH_LONG).show()
            e.printStackTrace()
        }*/
    }
}