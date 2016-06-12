package com.davicaetano.dagtest.ui.main;

import com.davicaetano.dagtest.ui.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by davicaetano on 6/9/16.
 */
@ActivityScope
@Subcomponent(modules = {
        MainModule.class
})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
