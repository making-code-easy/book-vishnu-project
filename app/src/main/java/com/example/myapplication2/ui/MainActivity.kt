package com.example.myapplication2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.R

class MainActivity : AppCompatActivity() {
    private var recyclerView:RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = BooksAdapter(BooksAdapter.diffutilCallback())
        recyclerView?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView?.adapter = adapter

        val viewModel = ViewModelProvider(this)[BooksViewModel::class.java]

        viewModel.getBooks()

        viewModel.books.observe(this){
            adapter.submitList(it)
        }
    }
}