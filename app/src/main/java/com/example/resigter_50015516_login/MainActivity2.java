package com.example.resigter_50015516_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity
    {

    EditText  emailId;
    EditText pwdId;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"; //String used to validate email at login screen
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btReg = (Button)findViewById(R.id.buttonReg); //Linking Registration button to variable

        //When Register button is clicked, do the following
        btReg.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                startActivity(new Intent(MainActivity2.this, MainActivity3.class)); //Use intent to move to registration page
                }
            });

        btnLogin = (Button)findViewById(R.id.buttonLogin); //Linking Login button to variable
        emailId = findViewById(R.id.emailText); //Linking email editText
        pwdId = findViewById(R.id.passwordText); //Linking pwd editText

            //When Login button is clicked, do the following
        btnLogin.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)
                {
                if(emailId.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Email Address", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (emailId.getText().toString().trim().matches(emailPattern)) //Validating Email
                    {
                        if (pwdId.getText().toString().length() != 0)
                        {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            emailId.setText("");
                            pwdId.setText("");
                        }
                        else
                        {
                            pwdId.setError("Enter Password");
                        }
                    }
                    else
                    {
                        emailId.setError("Invalid email address");
                    }
                }
            }
            });
        }
    }