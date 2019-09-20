package com.rikkei.training.mvpexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.rikkei.training.mvpexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements SignInContract.view, View.OnClickListener {
    private SignInPresenter mPresenter;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        initPresenter();
        registerListener();
    }

    private void registerListener() {
        binding.buttonSignIn.setOnClickListener(this);
    }

    private void initPresenter() {
        mPresenter = new SignInPresenter();
        mPresenter.setViews(this);
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(this, "Sign In Success!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signInFailure(String error) {
        Toast.makeText(this, "Sign In Fail!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        login();
    }

    private void login() {
        String username = binding.textUsername.getText().toString();
        String password = binding.textPassword.getText().toString();
        Log.d("Main Act",username+" "+password);

        if (!username.isEmpty() || !password.isEmpty()){
            mPresenter.handleSignIn(username,password);
        }
    }
}
