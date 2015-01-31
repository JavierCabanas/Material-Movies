package com.hackvg.android.view.presenter;

import android.util.Log;

import com.hackvg.android.domain.GetMoviesUsecaseController;
import com.hackvg.android.domain.GetPopularMediaUsecase;
import com.hackvg.android.domain.Usecase;
import com.hackvg.android.model.entities.TvMovie;
import com.hackvg.android.model.entities.TvShow;
import com.hackvg.android.view.mvp_views.PopularMoviesView;

import java.util.List;


public class PopularShowsPresenterImpl implements PopularMediaPresenter {

    private final PopularMoviesView popularMoviesView;

    public PopularShowsPresenterImpl(PopularMoviesView popularMoviesView) {

        this.popularMoviesView = popularMoviesView;
    }

    @Override
    public void onResume() {

        Usecase getPopularShows = new GetMoviesUsecaseController(this,
            GetPopularMediaUsecase.TV_MOVIES);

        getPopularShows.execute();
    }

    @Override
    public void onPopularShowsReceived(List<TvShow> shows) {

    }

    @Override
    public void onPopularMoviesReceived(List<TvMovie> popularMovies) {


        Log.d("[DEBUG]", "PopularShowsPresenterImpl onPopularMoviesReceived - movies: " + popularMovies);
    }
}
