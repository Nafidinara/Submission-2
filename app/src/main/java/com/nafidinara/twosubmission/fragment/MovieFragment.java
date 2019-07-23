package com.nafidinara.twosubmission.fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nafidinara.twosubmission.DetailActivity;
import com.nafidinara.twosubmission.Items;
import com.nafidinara.twosubmission.R;
import com.nafidinara.twosubmission.adapter.Adapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
// Referensi : https://github.com/codermahadi/Fragment-with-Recyclerview

public class MovieFragment extends Fragment implements Adapter.OnItemClickListener {

   private String[] titleData;
    private String[] releaseData;
    private String[] directorData;
    private String[] runtimeData;
    private String[] languageData;
    private String[] scoreData;
    private String[] genreData;
    private String[] storylineData;
    private TypedArray imageData;
    private Adapter adapter;
    private View v;
    private ArrayList<Items>list;
    private RecyclerView rv;


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_movie,container,false);
        rv = v.findViewById(R.id.rv);
        Adapter adapter = new Adapter(getContext(), list);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        prepare();
        addItem();

        return v;
    }

    private void prepare() {
        titleData = getResources().getStringArray(R.array.title_movie);
        releaseData = getResources().getStringArray(R.array.release_movie);
        directorData = getResources().getStringArray(R.array.director_movie);
        runtimeData = getResources().getStringArray(R.array.runtime_movie);
        languageData = getResources().getStringArray(R.array.language_movie);
        scoreData = getResources().getStringArray(R.array.score_movie);
        genreData = getResources().getStringArray(R.array.genre_movie);
        storylineData = getResources().getStringArray(R.array.storyline_movie);
        imageData = getResources().obtainTypedArray(R.array.image_movie);
    }

    private void addItem() {
        ArrayList<Items> list = new ArrayList<>();
        for (int i = 0; i < titleData.length; i++) {
            Items items = new Items();
            items.setImage(imageData.getResourceId(i,-1));
            items.setTitle(titleData[i]);
            items.setRelease(releaseData[i]);
            items.setGenre(genreData[i]);
            list.add(items);
        }
        adapter = new Adapter(getContext(),list);
        adapter.setOnItemClickListener(MovieFragment.this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Items mItems = new Items();
        mItems.setTitle(titleData[position]);
        mItems.setDirector(directorData[position]);
        mItems.setLanguage(languageData[position]);
        mItems.setRuntime(runtimeData[position]);
        mItems.setScore(scoreData[position]);
        mItems.setStoryline(storylineData[position]);
        mItems.setImage(imageData.getResourceId(position,-1));
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("DETAIL_DATA",mItems);
        startActivity(intent);
    }
}
