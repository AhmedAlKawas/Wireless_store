package com.example.wirelessstore.di;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindFactory(ViewModelFactory viewModelFactory);

}
