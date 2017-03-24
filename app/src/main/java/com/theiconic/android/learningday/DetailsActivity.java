package com.theiconic.android.learningday;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by lrepolho on 24/3/17.
 */

public class DetailsActivity extends AppCompatActivity {
    private TextView name;
    private TextView description;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description);

    }
}
