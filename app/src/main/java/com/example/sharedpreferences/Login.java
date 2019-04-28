package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText etUser, etPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            CheckUser();
            }
        });

    }
    public void CheckUser()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
        String Username = sharedPreferences.getString("Username","");
        String Password = sharedPreferences.getString("Password","");
        if (Username.equals(etUser.getText().toString()) && Password.equals(etPassword.getText().toString())){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Wrong Email address & Password ", Toast.LENGTH_SHORT).show();
        }
    }
}
