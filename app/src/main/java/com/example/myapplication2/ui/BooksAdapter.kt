package com.example.myapplication2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication2.R
import com.example.myapplication2.databinding.LayoutItemBinding
import com.example.myapplication2.domain.dataclass.Book

class BooksAdapter(diffUtil: DiffUtil.ItemCallback<Book>) :
    ListAdapter<Book, BooksAdapter.BookViewHolder>(diffUtil) {

    inner class BookViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val binding = LayoutItemBinding.bind(itemView)

        fun bind(item: Book) {

            binding.apply {
                title.text = item.title
                description.text = item.description
                loadImage(item.imageUrl, image)

            }
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
}