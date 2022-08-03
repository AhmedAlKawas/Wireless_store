package com.example.wirelessstore.presentation.cart;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.wirelessstore.R;
import com.example.wirelessstore.databinding.ActivityMainBinding;
import com.example.wirelessstore.di.BaseActivity;
import com.example.wirelessstore.di.ViewModelFactory;
import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.presentation.products.OnProductItemListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CartActivity extends BaseActivity implements OnProductItemListener {

    @Inject
    ViewModelFactory viewModelFactory;
    CartsViewModel cartsViewModel;
    List<CartItem> cartItems;
    CartsAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initListeners();
        initCartsAdapter();
        cartsViewModel.getCartItems();

    }

    private void initListeners() {
        cartsViewModel = new ViewModelProvider(CartActivity.this, viewModelFactory)
                .get(CartsViewModel.class);
        cartsViewModel.cartItems().observe(this, cartsResponse -> {
            if (cartsResponse != null && !cartsResponse.isEmpty() && cartItems.isEmpty()) {
                cartItems.addAll(cartsResponse);
                adapter.notifyItemRangeInserted(0, cartsResponse.size());
            }
        });
    }

    private void initCartsAdapter() {
        if (cartItems == null)
            cartItems = new ArrayList<>();
        adapter = new CartsAdapter(cartItems, this);
        binding.productsRv.setAdapter(adapter);
    }

    @Override
    public void onItemAddToCartClicked(int position) {

        cartsViewModel.removeCartItem(cartItems.get(position));

    }
}