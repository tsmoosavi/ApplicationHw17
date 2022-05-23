package com.example.myapplication.ui.movieList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.network.ApiService
import com.example.myapplication.data.network.poster_path
import com.example.myapplication.databinding.FragmentMovieListBinding


class MovieListFragment : Fragment() {
    lateinit var binding: FragmentMovieListBinding
    val viewModel : MovieListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_movie_list,container,false)
        binding.vModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = MovieAdapter()
        binding.searchIcon.setOnClickListener {
            var action = MovieListFragmentDirections.actionMovieListFragmentToSearchResultFragment(binding.searchBox.text.toString())
            findNavController().navigate(action)
        }
        viewModel.movieList.observe(viewLifecycleOwner) {
            binding.movieRecyclerView.adapter = adapter
            adapter.submitList(it)
//            Glide.with(this).load(poster_path + it[0].poster_path).into(binding.moviePhoto)
        }
    }

//    https://image.tmdb.org/p/w500//neMZH82Stu91d3iqvLdNQfqPPyl.jpg
//    https://image.tmdb.org/t/p/w500/neMZH82Stu91d3iqvLdNQfqPPyl.jpg


}