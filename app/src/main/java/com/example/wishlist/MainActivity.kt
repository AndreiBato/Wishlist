package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var myList = ArrayList<WantList>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listsRv = findViewById<RecyclerView>(R.id.listsRv)
        val adapter = MyListAdapter(this, myList)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val priceInput = findViewById<EditText>(R.id.priceInput)
        val urlInput = findViewById<EditText>(R.id.urlInput)

        findViewById<Button>(R.id.submitButton).setOnClickListener{
            myList.add(WantList(nameInput.text.toString(), urlInput.text.toString(),
                priceInput.text.toString() ))
            adapter.notifyDataSetChanged()
        }



        listsRv.adapter=adapter
        listsRv.layoutManager = LinearLayoutManager(this)
    }

}