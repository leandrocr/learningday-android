package com.theiconic.android.learningday.Repositories;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.theiconic.android.learningday.Entities.ProductEntity;

import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lrepolho on 24/3/17.
 */

public class ProductRepository {

    private static final String BASE_URL = "https://eve.theiconic.com.au/v1/";
    private static final int PAGE_SIZE = 20;
    private ProductService productService;

    public ProductRepository(){
        Gson gson = new GsonBuilder().create();
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        productService = retrofit.create(ProductService.class);
    }

    public void getWomensClothingAll(Callback<ProductEntity> callback) {
        productService.getProducts("female", 4, 1, PAGE_SIZE, true).enqueue(callback);
    }
}
