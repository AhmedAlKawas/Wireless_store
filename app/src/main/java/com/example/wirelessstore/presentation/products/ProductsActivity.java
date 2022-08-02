package com.example.wirelessstore.presentation.products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.wirelessstore.R;
import com.example.wirelessstore.di.AppModule;
import com.example.wirelessstore.di.DaggerAppComponent;
import com.example.wirelessstore.di.RoomModule;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);

    }
}
