package com.theiconic.android.learningday.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lrepolho on 24/3/17.
 */

public class ProductEntity {
    @SerializedName("page_count")
    private int pageCount;

    @SerializedName("page_size")
    private int pageSize;

    @SerializedName("total_items")
    private int totalItems;

    @SerializedName("_embedded")
    private Embedded embedded;

    private static class Embedded {
        @SerializedName("product")
        private List<CatalogProductEntity> products;
    }
}
