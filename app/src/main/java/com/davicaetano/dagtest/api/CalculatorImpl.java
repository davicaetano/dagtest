package com.davicaetano.dagtest.api;

/**
 * Created by davicaetano on 6/9/16.
 */
public class CalculatorImpl implements Calculator {
    @Override
    public void calculates(float v1, float v2, String op, Callback callback) {
        float r = v1 + v2;
        callback.success(r);
    }
}
