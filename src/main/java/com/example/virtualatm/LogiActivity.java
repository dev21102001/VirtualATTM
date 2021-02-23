package com.example.virtualatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogiActivity extends AppCompatActivity {

    EditText email, password;
    Button signIn;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logi);

        email = findViewById(R.id.emailPhone);
        password = findViewById(R.id.passWord);

        signIn = findViewById(R.id.SignUp);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                email.setError(null);
                password.setError(null);

                if (email.getText().toString().isEmpty()) {
                    email.setError("Field can't be empty");
                    return;
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Field can't be empty");
                    return;
                }
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });


    }

    public void register (View view) {
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }

    public void skip (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
