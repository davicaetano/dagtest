package com.davicaetano.dagtest.ui.main;

import com.davicaetano.dagtest.api.Calculator;

/**
 * Created by davicaetano on 6/9/16.
 */
public class MainPresenterImpl implements MainPresenter {
    MainView view;
    Calculator calculator;

    public MainPresenterImpl(MainView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    @Override
    public void makeCalculation(String v1, String v2, String op) {
        float a = Float.parseFloat(v1);
        float b = Float.parseFloat(v2);
        calculator.calculates(a, b, op, new Calculator.Callback() {
            @Override
            public void success(float result) {
                view.showResult(result);
            }

            @Override
            public void error(String error) {
                view.showError(error);
            }
        });
    }
}
