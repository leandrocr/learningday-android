package com.theiconic.android.learningday.Repositories;

import com.theiconic.android.learningday.Entities.ProductEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by lrepolho on 24/3/17.
 */

public interface ProductService {
    @Headers("Accept: application/json")
    @GET("catalog/products")
    Call<ProductEntity> getProducts(
            @Query("gender") String gender,
            @Query("category") int category,
            @Query("page") int page,
            @Query("page_size") int pageSize,
            @Query("strip_facets") boolean stripFacets
    );
}
