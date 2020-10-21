package com.example.resigter_50015516_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity3 extends AppCompatActivity {

    //Creating variables for each EditText for linking
    EditText  emailId1;
    EditText pwdId1;
    EditText fname;
    EditText lname;
    EditText dob;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"; //String Pattern used to validate email
    Button btnRegister;

    String date = "01/12/2019";
    String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$"; //String used to validate DOB
    //Creating a pattern object
    Pattern pattern = Pattern.compile(regex);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        fname = findViewById(R.id.fnameText);
        lname = findViewById(R.id.lnameText);
        dob = findViewById(R.id.dobText);
        emailId1 = findViewById(R.id.eText);
        pwdId1 = findViewById(R.id.pwdText);

        btnRegister = (Button)findViewById(R.id.btnRegister);

        //When Register button is clicked, do the following
        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Matcher matcher = pattern.matcher(dob.getText().toString());
                boolean bool = matcher.matches(); //Bool is used to indicate if DOB is valid or not

                //Series of if statements to vaildate data in each EditTextbox
                if(emailId1.getText().toString().isEmpty())
                {
                    emailId1.setError("Enter Email Address");
                }
                if ((fname.getText().toString().length() > 30) || (fname.getText().toString().length() < 3))
                {
                    fname.setError("Enter valid First Name");
                }
                if (lname.getText().toString().length() == 0)
                {
                    lname.setError("Enter Family Name");
                }
                if (dob.getText().toString().length() == 0 || (!bool))
                {
                    dob.setError("Enter valid Date of Birth (MM/DD/YY)");
                }
                if (pwdId1.getText().toString().length() == 0)
                {
                    pwdId1.setError("Enter Password");
                }
                else
                {
                    //Registration successful toast only if all validation checks have been met
                    if (emailId1.getText().toString().trim().matches(emailPattern))
                    {
                        if ((pwdId1.getText().toString().length() != 0) && ((fname.getText().toString().length() <= 30) && (fname.getText().toString().length() >= 3))
                                && (dob.getText().toString().length() != 0) && (bool))
                        {
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity3.this, MainActivity2.class));
                        }
                    }
                    else
                    {
                        emailId1.setError("Invalid Email address");
                    }
                }
            }
        });

        Button btnBack = (Button)findViewById(R.id.btnBack);

        //When back button is clicked, go to previous page
        btnBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, MainActivity2.class));
            }
        });
    }
}