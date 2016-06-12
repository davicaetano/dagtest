package com.davicaetano.dagtest;

import android.app.Application;

import com.davicaetano.dagtest.api.CalculatorModule;
import com.davicaetano.dagtest.ui.main.MainActivity;
import com.davicaetano.dagtest.ui.main.MainModule;

/**
 * Created by davicaetano on 6/9/16.
 */
public class App extends Application {
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    protected void initComponent() {
        appComponent = DaggerAppComponent.builder()
                .calculatorModule(new CalculatorModule())
                .build();
    }

    public void injectMainActivity(MainActivity mainActivity) {
        appComponent.plus(new MainModule(mainActivity)).inject(mainActivity);
    }
}
