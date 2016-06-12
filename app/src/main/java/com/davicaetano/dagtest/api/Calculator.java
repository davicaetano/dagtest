package com.davicaetano.dagtest.api;

/**
 * Created by davicaetano on 6/9/16.
 */
public interface Calculator {
    void calculates(float v1, float v2, String op, Callback callback);

    public interface Callback{
        void success(float result);
        void error(String error);
    }
}
