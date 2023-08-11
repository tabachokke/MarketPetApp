package com.example.marketpetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)



        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "sofa", "Диван", "opisanie divana", "strange text", 100))
        items.add(Item(2, "lighter", "Свет", "opisanie", "strange text", 125))
        items.add(Item(3, "kiitchen", "Кухня", "opisanie", "strange text", 500))
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

    }
}