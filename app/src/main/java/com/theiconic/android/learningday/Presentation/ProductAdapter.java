package com.theiconic.android.learningday.Presentation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.theiconic.android.learningday.Entities.CatalogProductEntity;

import java.util.Collections;
import java.util.List;

/**
 * Created by lrepolho on 24/3/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<CatalogProductEntity> products = Collections.emptyList();

    public void updateProducts(List<CatalogProductEntity> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
