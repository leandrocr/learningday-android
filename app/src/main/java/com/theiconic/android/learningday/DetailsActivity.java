package com.theiconic.android.learningday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public static final String SKU = "sku";

    private TextView name;
    private TextView description;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        name.setText(getIntent().getStringExtra(SKU));
    }
}
