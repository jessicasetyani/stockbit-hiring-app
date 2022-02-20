package com.stockbit.hiring.feature.watchlistSymbol.module

import com.stockbit.hiring.feature.watchlistSymbol.viewModel.WatchlistSymbolViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Jessica Setyani on 19/02/22.
 */
val watchlistSymbolModule = module {
    viewModel { WatchlistSymbolViewModel() }
}