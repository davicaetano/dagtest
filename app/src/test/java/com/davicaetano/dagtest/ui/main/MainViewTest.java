package com.davicaetano.dagtest.ui.main;

import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.davicaetano.dagtest.BuildConfig;
import com.davicaetano.dagtest.MockApp1;
import com.davicaetano.dagtest.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


/**
 * Created by davicaetano on 6/10/16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21, constants = BuildConfig.class, application = MockApp1.class)
public class MainViewTest {
    MainActivity mainActivity;
    Spinner spinner;
    EditText result;
    Button calculate;

    @Before
    public void setUp(){
        mainActivity = Robolectric.setupActivity(MainActivity.class);
        calculate = (Button)mainActivity.findViewById(R.id.ok_button);
        spinner = (Spinner)mainActivity.findViewById(R.id.spinner);
        result = (EditText)mainActivity.findViewById(R.id.result_editText);
        assertNotNull("Activity not set up", mainActivity);
        assertNotNull("Activity not set up", spinner);
    }

    @Test
    public void testSpinnerOperations(){
        Adapter adapter = spinner.getAdapter();
        assertFalse("Spinner is empty", adapter.isEmpty());
        List operations = Arrays.asList( mainActivity.getResources().getStringArray(R.array.array_math_op)) ;
        for(int i = 0; i < adapter.getCount(); i++){
            assertTrue("adapter does not contain every operator",operations.contains(adapter.getItem(i)));
            operations.set(i,"");
        }
    }

    @Test
    public void testShowResult(){
        Float testResult = 0.0f;
        mainActivity.showResult(testResult);
        assertEquals(testResult.toString(),result.getText().toString());
    }

    @Test
    public void testShowError(){
        String errorMessage = "testShowError Message";
        mainActivity.showError(errorMessage);
        assertEquals(errorMessage,result.getText().toString());
    }

    @Test
    public void testCalculateButton(){
        ((EditText)mainActivity.findViewById(R.id.first_EditText)).setText("10");
        ((EditText)mainActivity.findViewById(R.id.second_EditText)).setText("20");
        calculate.performClick();
        assertEquals("100.0",result.getText().toString());
    }

    @Test
    public void testCalculateButtonFirstTextEmpty(){
        ((EditText)mainActivity.findViewById(R.id.first_EditText)).setText("");
        ((EditText)mainActivity.findViewById(R.id.second_EditText)).setText("20");
        calculate.performClick();
    }


}
