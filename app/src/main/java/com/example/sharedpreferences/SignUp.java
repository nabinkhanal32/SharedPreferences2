package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private EditText etUserName, etPass, etCPass;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUserName = findViewById(R.id.etUserName);
        etPass = findViewById(R.id.etPass);
        etCPass = findViewById(R.id.etCPass);

        btnSignup=findViewById(R.id.btnSignups);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPass.getText().toString().equals(etCPass.getText().toString())) {
                    Register();
                    } else {
                    Toast.makeText(SignUp.this, "Password Wrong ", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void Register()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        editor.putString("Username",etUserName.getText().toString());
        editor.putString("Password",etPass.getText().toString());
        editor.putString("Conform Password",etCPass.getText().toString());
        editor.commit();
        Toast.makeText(this, "Successfully Register", Toast.LENGTH_SHORT).show();
        
    }
}
