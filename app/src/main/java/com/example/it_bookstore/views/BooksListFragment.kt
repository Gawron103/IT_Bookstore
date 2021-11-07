package com.example.it_bookstore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import com.example.it_bookstore.R
import com.example.it_bookstore.adapters.BooksAdapter
import com.example.it_bookstore.databinding.FragmentBooksListBinding
import com.example.it_bookstore.view_models.BooksViewModel
import com.example.it_bookstore.view_models.BooksViewModelFactory

class BooksListFragment : Fragment() {

    private var _binding: FragmentBooksListBinding? = null
    private val binding get() = _binding!!

    private lateinit var _booksViewModel: BooksViewModel
    private lateinit var _booksAdapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _booksViewModel = ViewModelProvider(
            this,
            BooksViewModelFactory()
        ).get(BooksViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksListBinding.inflate(inflater, container, false)

        _booksAdapter = BooksAdapter(listOf())

        binding.rvBooks.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = _booksAdapter
        }

        observeViewModel()

        return binding.root
    }

    private fun observeViewModel() {
        _booksViewModel.getBooksLiveData().observe(viewLifecycleOwner, Observer { books ->
            _booksAdapter.updateBooks(books)
        })
    }

}