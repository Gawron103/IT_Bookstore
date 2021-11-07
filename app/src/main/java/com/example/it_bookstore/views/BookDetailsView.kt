package com.example.it_bookstore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.it_bookstore.R
import com.example.it_bookstore.databinding.FragmentBookDetailsViewBinding

class BookDetailsView : Fragment() {

    private var _binding: FragmentBookDetailsViewBinding? = null
    private val binding get() = _binding!!

    private val _args: BookDetailsViewArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailsViewBinding.inflate(inflater, container, false)

        val book = _args.book

        binding.tvISBN.text = book.isbn
        binding.tvPrice.text = book.price
        binding.tvSubtitle.text = book.subtitle
        binding.tvTitle.text = book.title

        return binding.root
    }

}