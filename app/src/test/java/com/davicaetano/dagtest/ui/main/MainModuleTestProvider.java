package com.davicaetano.dagtest.ui.main;

import com.davicaetano.dagtest.api.Calculator;
import com.davicaetano.dagtest.ui.ActivityScope;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import dagger.Module;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

/**
 * Created by davicaetano on 6/10/16.
 */
@ActivityScope
@Module
public class MainModuleTestProvider extends MainModule {

    public MainModuleTestProvider(MainView view) {
        super(view);
    }

    @Override
    public MainPresenter provideMainPresenter(Calculator calculator) {
        MainPresenter presenter = mock(MainPresenter.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                view.showResult(120);
                return null;
            }
        }).when(presenter).makeCalculation(anyString(), anyString(), anyString());
        return presenter;
    }
}
