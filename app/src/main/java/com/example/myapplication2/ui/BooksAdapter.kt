package com.example.myapplication2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication2.R
import com.example.myapplication2.domain.dataclass.Book

class BooksAdapter(diffUtil: DiffUtil.ItemCallback<Book>) :
    ListAdapter<Book, BooksAdapter.BookViewHolder>(diffUtil) {

    inner class BookViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Book) {
            view.findViewById<TextView>(R.id.title).text = item.title
            view.findViewById<TextView>(R.id.description).text = item.description
            loadImage(item.imageUrl, view.findViewById<ImageView>(R.id.image))
        }
    }

    private fun loadImage(url: String, imageView: ImageView) {
        Glide
            .with(imageView)
            .load(url)
            .centerCrop()
            .into(imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class diffutilCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }

    }
}