package com.sandeappbrewery.denriadmin.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.sandeappbrewery.denriadmin.Common.Product;
import com.sandeappbrewery.denriadmin.databinding.ProductItemBinding;

public class ProductAdapter extends ListAdapter<Product, ProductAdapter.ProductViewHolder> {

    protected ProductAdapter() {
        super(Product.itemCallback);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public ProductViewHolder(ProductItemBinding binding) {
            super(binding.getRoot());
        }
    }
}
