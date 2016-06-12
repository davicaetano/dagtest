package com.davicaetano.dagtest.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.davicaetano.dagtest.App;
import com.davicaetano.dagtest.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.first_EditText) EditText first_EditText;
    @BindView(R.id.second_EditText) EditText second_EditText;
    @BindView(R.id.spinner) Spinner spinner;
    @BindView(R.id.ok_button) Button ok_button;
    @BindView(R.id.result_editText) EditText result_editText;

    @Inject MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App)getApplication()).injectMainActivity(this);
    }

    @OnClick(R.id.ok_button)
    public void onClickOkButton(View view){
        presenter.makeCalculation(first_EditText.getText().toString(),
                second_EditText.getText().toString(),
                spinner.getSelectedItem().toString());
    }

    @Override
    public void showError(String error) {
        result_editText.setText(error);
    }

    @Override
    public void showResult(float result) {
        result_editText.setText(String.valueOf(result));
    }
}
