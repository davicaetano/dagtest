package com.davicaetano.dagtest.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by davicaetano on 6/9/16.
 */
@Module
public class CalculatorModule {
    @Singleton
    @Provides
    public Calculator provideCalculator(){
        return new CalculatorImpl();
    }
}
