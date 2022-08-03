package com.example.wirelessstore.presentation.products;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.wirelessstore.R;
import com.example.wirelessstore.databinding.ActivityMainBinding;
import com.example.wirelessstore.di.AppModule;
import com.example.wirelessstore.di.DaggerAppComponent;
import com.example.wirelessstore.di.RoomModule;
import com.example.wirelessstore.di.ViewModelFactory;
import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.domain.model.ProductsList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProductsActivity extends AppCompatActivity implements OnProductItemListener {

    @Inject
    ViewModelFactory viewModelFactory;
    ProductsViewModel productsViewModel;
    List<Product> products;
    ProductsAdapter adapter;
    ActivityMainBinding binding;
    int interactionProductPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);


        initListeners();
        initProductsAdapter();
        productsViewModel.getProducts();
    }

    private void initProductsAdapter() {
        products = new ArrayList<>();
        adapter = new ProductsAdapter(products, this);
        binding.productsRv.setAdapter(adapter);
    }

    private void initListeners() {

        productsViewModel = new ViewModelProvider(this, viewModelFactory)
                .get(ProductsViewModel.class);
        productsViewModel.products().observe(this, productsResponse -> {
            if (productsResponse != null && !productsResponse.isEmpty() && products.isEmpty()) {
                products.addAll(productsResponse);
                adapter.notifyItemRangeInserted(0, ProductsList.getProductsList().size());
            }
        });
        productsViewModel.getChangeProductIsAddedToCartResponse().observe(this, success -> {
            if (success && interactionProductPosition != -1) {
                products.get(interactionProductPosition)
                        .setProductIsAddedToCart(products.get(interactionProductPosition)
                                .getProductIsAddedToCart());
                adapter.notifyItemChanged(interactionProductPosition);
                interactionProductPosition = -1;
            }
        });

    }

    @Override
    public void onItemAddToCartClicked(int position) {
        productsViewModel.changeProductIsAddedToCart(products.get(position));
        interactionProductPosition = position;
    }
}
