package com.stockbit.hiring.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.ItemWatchlistSymbolBinding
import com.stockbit.model.CoinInfo

/**
 * Created by Jessica Setyani on 19/02/22.
 */
class WatchlistSymbolAdapter(private val clickListener: (CoinInfo) -> Unit) :
    RecyclerView.Adapter<MyViewHolder>() {
    private val coinList = ArrayList<CoinInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemWatchlistSymbolBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_watchlist_symbol, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return coinList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(coinList[position], clickListener)
    }

    fun setList(coins: List<CoinInfo>) {
        coinList.clear()
        coinList.addAll(coins)

    }
}

class MyViewHolder(val binding: ItemWatchlistSymbolBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(coinInfo: CoinInfo, clickListener: (CoinInfo) -> Unit) {
        binding.coinNameText.text = coinInfo.name
        binding.coinFullNameText.text = coinInfo.fullName
        binding.listItemLayout.setOnClickListener {
            clickListener(coinInfo)
        }
    }
}


