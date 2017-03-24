package com.theiconic.android.learningday.Presentation;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theiconic.android.learningday.DetailsActivity;
import com.theiconic.android.learningday.Entities.CatalogProductEntity;
import com.theiconic.android.learningday.R;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<CatalogProductEntity> products = Collections.emptyList();

    public void updateProducts(List<CatalogProductEntity> products) {
        this.products = products;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_item_product, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CatalogProductEntity product = products.get(position);
        holder.bind(product);
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private String sku;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            price = (TextView)itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                    intent.putExtra(DetailsActivity.SKU, sku);
                    view.getContext().startActivity(intent);
                }
            });
        }

        public void bind(CatalogProductEntity products){
            price.setText(NumberFormat.getCurrencyInstance(Locale.US).format(products.getPrice()));
            name.setText(products.getName());
            sku = products.getSku();
        }
    }
}
