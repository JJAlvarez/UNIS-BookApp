package com.example.ejerciciolibros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class BookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.collapsing_toolbar);
        toolbarLayout.setTitle("Toolbar colapsada");
        toolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        toolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        ImageView bookDetailImage = findViewById(R.id.book_detail_image);
        Glide.with(this).load("http://i.ebayimg.com/00/$(KGrHqV,!g0E6ZCwQ)wpBOuWbUNB,g~~_6.JPG?set_id=89040003C1").into(bookDetailImage);
    }
}