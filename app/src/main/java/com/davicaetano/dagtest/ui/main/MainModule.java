package com.davicaetano.dagtest.ui.main;

import com.davicaetano.dagtest.api.Calculator;
import com.davicaetano.dagtest.ui.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by davicaetano on 6/9/16.
 */
@Module
public class MainModule {
    protected MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public MainPresenter provideMainPresenter(Calculator calculator){
        return new MainPresenterImpl(view, calculator);
    }
}
