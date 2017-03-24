package com.theiconic.android.learningday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.theiconic.android.learningday.Entities.ProductEntity;
import com.theiconic.android.learningday.Repositories.ProductRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ProductRepository productRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productRepository = new ProductRepository();
        setContentView(R.layout.activity_main);
        load();
    }

    private void load() {
        productRepository.getWomensClothingAll(new Callback<ProductEntity>() {
            @Override
            public void onResponse(Call<ProductEntity> call, Response<ProductEntity> response) {
                String tmp = "";
            }
            @Override
            public void onFailure(Call<ProductEntity> call, Throwable t) {
                String tmp = "";
            }
        });
    }
}
