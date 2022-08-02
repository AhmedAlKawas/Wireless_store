package com.example.wirelessstore.di;

import com.example.wirelessstore.presentation.products.ProductsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RoomModule.class, ViewModelModule.class})
public interface AppComponent {

    void inject(ProductsActivity mainActivity);

}
