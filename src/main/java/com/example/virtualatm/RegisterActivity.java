package com.example.virtualatm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText name, email, phone, password;
    Button Register;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.emailPhone);
        email = findViewById(R.id.passWord);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        Register = findViewById(R.id.SignUp);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                email.setError(null);
                name.setError(null);
                password.setError(null);
                phone.setError(null);
                if (name.getText().toString().isEmpty()) {
                    name.setError("Field can't be empty");
                    return;
                }
                if (phone.getText().toString().isEmpty()) {
                    phone.setError("Field can't be empty");
                    return;
                }
                if (email.getText().toString().isEmpty()) {
                    email.setError("Field can't be empty");
                    return;
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Field can't be empty");
                    return;
                }
                if (!VALID_EMAIL_ADDRESS_REGEX.matcher(email.getText().toString()).find()) {
                    email.setError("Please enter a valid email id");
                    return;
                }
                if (phone.getText().toString().length() != 10) {
                    phone.setError("Enter a valid phone Number");
                    return;
                }

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }


    public void login (View view) {
        startActivity(new Intent(getApplicationContext(), LogiActivity.class));

    }

    public void skip (View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
