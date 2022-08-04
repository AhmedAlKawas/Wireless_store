package com.example.wirelessstore.presentation.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.wirelessstore.R;
import com.example.wirelessstore.databinding.ActivityMainBinding;
import com.example.wirelessstore.di.BaseActivity;
import com.example.wirelessstore.di.ViewModelFactory;
import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.domain.model.ProductsList;
import com.example.wirelessstore.presentation.cart.CartActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProductsActivity extends BaseActivity implements OnProductItemListener {

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

        initListeners();
        initProductsAdapter();
        productsViewModel.getProducts();
        productsViewModel.getCartItems();
    }

    private void initProductsAdapter() {
        if (products == null)
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
                productsViewModel.addOrRemoveItemFromCart(products.get(interactionProductPosition));
            } else
                Toast.makeText(this, "An error occurred, try again!",
                        Toast.LENGTH_SHORT).show();
        });
        productsViewModel.getAddOrRemoveItemFromCartResponse().observe(this, success -> {
            if (success && interactionProductPosition != -1) {
                products.get(interactionProductPosition)
                        .setProductIsAddedToCart(products.get(interactionProductPosition)
                                .getProductIsAddedToCart());
                adapter.notifyItemChanged(interactionProductPosition);
                if (products.get(interactionProductPosition).getProductIsAddedToCart()) {
                    Toast.makeText(this, "Added successfully", Toast.LENGTH_SHORT)
                            .show();
                } else
                    Toast.makeText(this, "Removed successfully", Toast.LENGTH_SHORT)
                            .show();
                interactionProductPosition = -1;
            } else
                Toast.makeText(this, "An error occurred, try again!",
                        Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public void onItemAddToCartClicked(int position) {
        productsViewModel.changeProductIsAddedToCart(products.get(position));
        interactionProductPosition = position;
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_shipping_cart) {
            startActivity(new Intent(ProductsActivity.this, CartActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
