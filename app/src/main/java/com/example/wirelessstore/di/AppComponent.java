package com.example.wirelessstore.di;

import android.app.Application;

import com.example.wirelessstore.di.cart.CartViewModelModule;
import com.example.wirelessstore.presentation.cart.CartActivity;
import com.example.wirelessstore.presentation.products.ProductsActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        RoomModule.class,
        ActivityBuilder.class,
        ViewModelModule.class,
        CartViewModelModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(BaseApplication application);
        Builder roomModule(RoomModule roomModule);
        AppComponent build();
    }

    void inject(BaseApplication application);

}
