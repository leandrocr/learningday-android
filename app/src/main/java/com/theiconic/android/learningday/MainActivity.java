package com.theiconic.android.learningday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.theiconic.android.learningday.Entities.ProductEntity;
import com.theiconic.android.learningday.Presentation.ProductAdapter;
import com.theiconic.android.learningday.Repositories.ProductRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProductRepository productRepository;

    private TextView errorText;
    private RecyclerView recycler;
    private ProgressBar loadingInidicator;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productRepository = new ProductRepository();
        setContentView(R.layout.activity_main);
        errorText = (TextView) findViewById(R.id.errorText);
        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        loadingInidicator = (ProgressBar) findViewById(R.id.loadingIndicator);

        adapter = new ProductAdapter();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        load();
    }

    private void load() {
        errorText.setVisibility(View.GONE);
        recycler.setVisibility(View.GONE);
        loadingInidicator.setVisibility(View.VISIBLE);

        productRepository.getWomensClothingAll(new Callback<ProductEntity>() {
            @Override
            public void onResponse(Call<ProductEntity> call, Response<ProductEntity> response) {
                errorText.setVisibility(View.GONE);
                recycler.setVisibility(View.VISIBLE);
                loadingInidicator.setVisibility(View.GONE);

                adapter.updateProducts(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<ProductEntity> call, Throwable t) {
                errorText.setVisibility(View.VISIBLE);
                recycler.setVisibility(View.GONE);
                loadingInidicator.setVisibility(View.GONE);
            }
        });
    }
}
