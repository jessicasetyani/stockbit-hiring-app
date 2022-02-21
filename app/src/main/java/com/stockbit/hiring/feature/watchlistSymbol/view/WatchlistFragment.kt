package com.stockbit.hiring.feature.watchlistSymbol.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stockbit.hiring.R
import com.stockbit.hiring.adapter.WatchlistSymbolAdapter
import com.stockbit.hiring.databinding.FragmentWatchlistSymbolBinding
import com.stockbit.hiring.feature.watchlistSymbol.viewModel.WatchlistSymbolViewModel

class WatchlistFragment : Fragment() {
    private lateinit var binding: FragmentWatchlistSymbolBinding
    private lateinit var watchlistViewModel: WatchlistSymbolViewModel
    private lateinit var adapter: WatchlistSymbolAdapter
    lateinit var data: MutableLiveData<ArrayList<Any>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_watchlist_symbol, container, false)

        watchlistViewModel = ViewModelProvider(this).get(WatchlistSymbolViewModel::class.java)
        binding.viewModel = watchlistViewModel
        setRecyclerView()
        return binding.root
    }


    private fun setRecyclerView() {

        binding.recyclerViewWatchlist.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WatchlistFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

}