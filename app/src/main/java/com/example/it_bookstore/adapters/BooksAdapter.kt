package com.example.it_bookstore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.it_bookstore.databinding.ItemBookBinding
import com.example.it_bookstore.models.Book
import com.example.it_bookstore.views.BooksListFragmentDirections

class BooksAdapter(var books: List<Book>): RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {

    fun updateBooks(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val itemBinding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BooksViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BooksViewHolder(val itemBinding: ItemBookBinding): RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(book: Book) {
            Glide.with(itemBinding.root)
                .load(book.image)
                .into(itemBinding.ivBookCover)

            itemBinding.cvBook
            itemBinding.tvBookName.text = book.title
            itemBinding.tvBookPrice.text = book.price
            itemView.setOnClickListener { view ->
                val action = BooksListFragmentDirections.actionBooksListFragmentToBookDetailsView(book)
                view.findNavController().navigate(action)
            }
        }

    }

}