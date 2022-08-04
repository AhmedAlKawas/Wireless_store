package com.example.wirelessstore.presentation.cart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.wirelessstore.R;
import com.example.wirelessstore.databinding.ActivityMainBinding;
import com.example.wirelessstore.di.BaseActivity;
import com.example.wirelessstore.di.ViewModelFactory;
import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.presentation.products.OnProductItemListener;
import com.example.wirelessstore.presentation.products.ProductsActivity;

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
    int deleteItemPosition = -1;

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
        cartsViewModel.getRemoveCartItemResponse().observe(this, success -> {
            if (success)
                cartsViewModel.changeProductAddedToCart(cartItems.get(deleteItemPosition));
        });
        cartsViewModel.getChangeProductAddedToCartResponse().observe(this, success -> {
            if (success && deleteItemPosition != -1){
                cartItems.remove(deleteItemPosition);
                adapter.notifyItemRemoved(deleteItemPosition);
                Toast.makeText(this, "Removed successfully", Toast.LENGTH_SHORT).show();
                deleteItemPosition = -1;
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
        deleteItemPosition = position;

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CartActivity.this, ProductsActivity.class));
    }
}