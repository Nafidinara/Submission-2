package com.nafidinara.twosubmission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView detailTitle,detailDirector,detailRuntime,detailLanguage,detailRating,detailStoryline,detailTitle_actionBar;
    private ImageView detailImage,detailImageBg;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Items detailItems = getIntent().getParcelableExtra("DETAIL_DATA");

        detailTitle = findViewById(R.id.detail_tv_title);
        String txt_title = detailItems.getTitle();
        detailTitle.setText(txt_title);

        detailDirector = findViewById(R.id.detail_tv_director);
        String txt_director = detailItems.getDirector();
        detailDirector.setText(txt_director);

        detailRuntime = findViewById(R.id.detail_tv_runtime);
        String txt_runtime = detailItems.getRuntime();
        detailRuntime.setText(txt_runtime);

        detailLanguage = findViewById(R.id.detail_tv_language);
        String txt_language = detailItems.getLanguage();
        detailLanguage.setText(txt_language);

        detailRating = findViewById(R.id.detail_tv_rating);
        String txt_rating = detailItems.getScore();
        detailRating.setText(txt_rating);

        detailStoryline = findViewById(R.id.detail_tv_storyline);
        String txt_storyline = detailItems.getStoryline();
        detailStoryline.setText(txt_storyline);

        detailTitle_actionBar = findViewById(R.id.detail_title_tolbar);
        String txt_title_toolbar = detailItems.getTitle();
        detailTitle_actionBar.setText(txt_title_toolbar);

        detailImage = findViewById(R.id.detail_poster);
        Glide.with(detailImage).load(detailItems.getImage()).into(detailImage);

        detailImageBg = findViewById(R.id.detail_poster_background);
        Glide.with(detailImageBg).load(detailItems.getImage()).into(detailImageBg);

        toolbar = findViewById(R.id.detail_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24px);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
