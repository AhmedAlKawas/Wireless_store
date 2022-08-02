package com.example.wirelessstore.presentation.products;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wirelessstore.R;
import com.example.wirelessstore.databinding.ProductItemBinding;
import com.example.wirelessstore.domain.model.Product;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductHolder> {

    private final List<Product> products;
    private LayoutInflater layoutInflater;
    private final OnProductItemListener listener;

    ProductsAdapter(List<Product> products, OnProductItemListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null)
            layoutInflater = LayoutInflater.from(parent.getContext());
        ProductItemBinding productItemBinding = DataBindingUtil.inflate(layoutInflater,
                R.layout.product_item, parent, false);
        return new ProductHolder(productItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        holder.productItemBinding.setProduct(products.get(position));
        holder.productItemBinding.addToCartBtn.setOnClickListener(view ->
                listener.onItemAddToCartClicked(position));

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ProductHolder extends RecyclerView.ViewHolder {

        ProductItemBinding productItemBinding;

        ProductHolder(ProductItemBinding binding) {
            super(binding.getRoot());
            productItemBinding = binding;
        }
    }

}
