package com.davicaetano.dagtest.data;


import com.davicaetano.dagtest.ui.main.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by davicaetano on 6/9/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config
public class CalculatorTest {
    private MainActivity mainActivity;

    @Before
    public void setUp(){
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void testSimpleSum(){

    }


}
