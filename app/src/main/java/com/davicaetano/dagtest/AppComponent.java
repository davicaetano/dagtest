package com.davicaetano.dagtest;

import com.davicaetano.dagtest.api.Calculator;
import com.davicaetano.dagtest.api.CalculatorModule;
import com.davicaetano.dagtest.ui.main.MainComponent;
import com.davicaetano.dagtest.ui.main.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by davicaetano on 6/9/16.
 */
@Singleton
@Component(modules = {
        CalculatorModule.class
})
public interface AppComponent {
    Calculator calculator();

    MainComponent plus(MainModule mainModule);
}
