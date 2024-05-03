package com.example.myapplication2.ui.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication2.domain.dataclass.Book

class DiffUtilCallBack : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }

}