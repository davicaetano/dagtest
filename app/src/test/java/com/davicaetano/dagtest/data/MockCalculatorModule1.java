package com.davicaetano.dagtest.data;

import com.davicaetano.dagtest.api.Calculator;
import com.davicaetano.dagtest.api.CalculatorModule;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import dagger.Module;

import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;

/**
 * Created by davicaetano on 6/10/16.
 */
@Module
public class MockCalculatorModule1 extends CalculatorModule{

    @Override
    public Calculator provideCalculator() {
        Calculator calculator = Mockito.mock(Calculator.class);

        final ArgumentCaptor<Calculator.Callback> callbackArgumentCaptor = ArgumentCaptor.forClass(Calculator.Callback.class);
        ArgumentCaptor<Float> arg1 = ArgumentCaptor.forClass(Float.class);
        ArgumentCaptor<Float> arg2 = ArgumentCaptor.forClass(Float.class);
        ArgumentCaptor<String> arg3 = ArgumentCaptor.forClass(String.class);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callbackArgumentCaptor.getValue().success(100f);
                return null;
            }
        }).when(calculator).calculates(anyFloat(), anyFloat(), anyString(), callbackArgumentCaptor.capture());

        return calculator;
    }
}
