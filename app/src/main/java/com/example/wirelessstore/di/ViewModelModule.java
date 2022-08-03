package com.example.wirelessstore.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.wirelessstore.presentation.cart.CartsViewModel;
import com.example.wirelessstore.presentation.products.ProductsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel.class)
    abstract ViewModel productsViewModel(ProductsViewModel peopleViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CartsViewModel.class)
    abstract ViewModel cartsViewModel(CartsViewModel cartsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory viewModelFactory);

}
