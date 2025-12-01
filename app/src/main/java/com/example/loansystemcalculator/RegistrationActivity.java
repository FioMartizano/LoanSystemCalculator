package com.example.loansystemcalculator;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {

    private EditText edit_DateHired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edit_DateHired = findViewById(R.id.edit_DateHired);

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
}
