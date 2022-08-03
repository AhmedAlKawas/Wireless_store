package com.example.wirelessstore.di;

import com.example.wirelessstore.presentation.cart.CartActivity;
import com.example.wirelessstore.presentation.products.ProductsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract CartActivity cartActivity();

    @ContributesAndroidInjector
    abstract ProductsActivity productsActivity();
}
