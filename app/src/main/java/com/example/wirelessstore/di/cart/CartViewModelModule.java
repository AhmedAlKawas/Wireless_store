package com.example.wirelessstore.di.cart;

import androidx.lifecycle.ViewModel;

import com.example.wirelessstore.di.ViewModelKey;
import com.example.wirelessstore.presentation.cart.CartsViewModel;
import com.example.wirelessstore.presentation.products.ProductsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class CartViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CartsViewModel.class)
    public abstract ViewModel bindCartsViewModel(CartsViewModel cartsViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductsViewModel.class)
    public abstract ViewModel bindProductsViewModel(ProductsViewModel productsViewModel);

}
