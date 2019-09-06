package com.example.rohini.recyclerview;

import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<RecyclerViewAdapter> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    View ChildView ;
    int RecyclerViewItemPosition ;
    RecyclerViewAdapter movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }

            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {

                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);

                    Toast.makeText(MainActivity.this, movieList.get(RecyclerViewItemPosition).getTitle().toString(), Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        prepareMovieData();

    }

    private void prepareMovieData() {
        movie = new RecyclerViewAdapter("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Star Wars: Episode VII", "Action", "2015");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Shaun the Sheep", "Animation", "2015");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Up", "Animation", "2009");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Star Trek", "Science Fiction", "2009");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("The LEGO Movie", "Animation", "2014");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Iron Man", "Action & Adventure", "2008");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Aliens", "Science Fiction", "1986");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Chicken Run", "Animation", "2000");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Back to the Future", "Science Fiction", "1985");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Goldfinger", "Action & Adventure", "1965");
        movieList.add(movie);

        movie = new RecyclerViewAdapter("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(movie);

        mAdapter.notifyDataSetChanged();
    }
}

//Refer link for more details
// https://www.androidhive.info/2016/01/android-working-with-recycler-view/
