package com.xinfu.rong.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xinfu.rong.mvpdemo.Presenter.UserLoginPresenter;
import com.xinfu.rong.mvpdemo.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView, View.OnClickListener {


    protected EditText username;
    protected EditText password;
    protected Button login;
    protected Button clear;
    UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassWord() {
        return password.getText().toString();
    }

    @Override
    public void clearUserName() {
        username.setText("");
    }

    @Override
    public void clearPassWord() {
        password.setText("");
    }

    @Override
    public void toSuccessActivity() {
        Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toFaildActivity() {
        Toast.makeText(this,"失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            userLoginPresenter.login();
        } else if (view.getId() == R.id.clear) {
            userLoginPresenter.clear();
        }
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(MainActivity.this);
        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(MainActivity.this);
    }
}
