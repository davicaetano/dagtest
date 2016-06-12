package com.davicaetano.dagtest;

import com.davicaetano.dagtest.data.MockCalculatorModule1;
import com.davicaetano.dagtest.ui.main.MainActivity;
import com.davicaetano.dagtest.ui.main.MainModuleTestProvider;

/**
 * Created by davicaetano on 6/10/16.
 */
public class MockApp1 extends App {

    @Override
    protected void initComponent() {
        appComponent = DaggerAppComponent.builder().calculatorModule(new MockCalculatorModule1()).build();
    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
        appComponent.plus(new MainModuleTestProvider(mainActivity)).inject(mainActivity);
    }
}
