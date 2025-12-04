package com.example.loansystemcalculator;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {

    EditText Fname, Lname, Password;
    private EditText edit_DateHired;
    TextView empID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Fname = findViewById(R.id.edit_firstName);
        Lname = findViewById(R.id.edit_lastName);
        Password = findViewById(R.id.edit_pass);

        edit_DateHired = findViewById(R.id.edit_DateHired);
        empID = findViewById(R.id.txt_empID);

        edit_DateHired.setOnClickListener(v -> {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePicker = new DatePickerDialog(
                    RegistrationActivity.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {

                        String date = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                        edit_DateHired.setText(date);
                    },
                    year, month, day
            );
            datePicker.show();
        });
    }

    public void onClickRegister(View view) {
        String fname = Fname.getText().toString().trim();
        String lname = Lname.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String dateHired = edit_DateHired.getText().toString().trim();
        String employeeID = empID.getText().toString().trim();

        if (fname.isEmpty() || lname.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Registration successful! Welcome, " + fname + " " + lname, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent (RegistrationActivity.this,activity_user_home.class);
        Bundle bundle = new Bundle();
        bundle.putString("Fname", fname);
        bundle.putString("Lname", lname);
        bundle.putString("Password", password);
        bundle.putString("DateHired", dateHired);
        bundle.putString("EmployeeID", employeeID);

        intent.putExtras(bundle);
        startActivity(intent);
        finish();


        /*
        boolean inserted = db.insertUser(fname, lname, username, password);
        if (inserted) {
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("Fname", fname);
            intent.putExtra("Lname", lname);
            intent.putExtra("Username", username);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Username already exists or insert failed. Try again.", Toast.LENGTH_SHORT).show();
        }
    }
    */


    }
}
