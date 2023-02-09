package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager(){
        ViewPager2 moviesViewPager = findViewById(R.id.moviesPageViewer);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position)->{
            float r = 1 - Math.abs(position);
            page.setScaleY(0.85f+r*0.15f);
        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));
    }

    private List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();

        Movie passengers = new Movie();
        passengers.poster = R.drawable.im1;
        passengers.name = "Passengers";
        passengers.category = "Science Fiction";
        passengers.releaseDate = "December 22, 2016";
        passengers.rating = 4.6f;
        movies.add(passengers);

        Movie tomorrowWar = new Movie();
        tomorrowWar.poster = R.drawable.im2;
        tomorrowWar.name = "The Tomorrow War";
        tomorrowWar.category = "Science Fiction";
        tomorrowWar.releaseDate = "December 14, 2016";
        tomorrowWar.rating = 4.8f;
        movies.add(tomorrowWar);

        Movie annihilation = new Movie();
        annihilation.poster = R.drawable.im3;
        annihilation.name = "Annihilation";
        annihilation.category = "Science Fiction";
        annihilation.releaseDate = "February 13, 2018";
        annihilation.rating = 3.5f;
        movies.add(annihilation);

        Movie theMartian = new Movie();
        theMartian.poster = R.drawable.im4;
        theMartian.name = "The Martian";
        theMartian.category = "Science Fiction";
        theMartian.releaseDate = "October 02, 2013";
        theMartian.rating = 4f;
        movies.add(theMartian);

        Movie theMartian1 = new Movie();
        theMartian1.poster = R.drawable.im2;
        theMartian1.name = "The Martian One";
        theMartian1.category = "Science Fiction";
        theMartian1.releaseDate = "August 02, 2013";
        theMartian1.rating = 3f;
        movies.add(theMartian1);

        Movie theMartian2 = new Movie();
        theMartian2.poster = R.drawable.im6;
        theMartian2.name = "The Martian Two";
        theMartian2.category = "Science Fiction";
        theMartian2.releaseDate = "September 02, 2013";
        theMartian2.rating = 2.4f;
        movies.add(theMartian2);

        return movies;
    }
}