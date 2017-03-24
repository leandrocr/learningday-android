package com.theiconic.android.learningday.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lrepolho on 24/3/17.
 */

public class CatalogProductEntity {
    @SerializedName("sku")
    private String sku;

    @SerializedName("name")
    private String name;

    @SerializedName("short_description")
    private String shortDescription;

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public double getPrice() {
        return price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public Embedded getEmbedded() {
        return embedded;
    }

    @SerializedName("price")
    private double price;

    @SerializedName("final_price")
    private double finalPrice;

    @SerializedName("_embedded")
    private Embedded embedded;

    private static class Embedded {
        @SerializedName("brand")
        private BrandEntity brand;

        @SerializedName("images")
        private List<ImageEntity> images;
    }
}
