package com.example.busreservationsystem;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.busreservationsystem.MyAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;

public class bookseat extends AppCompatActivity {

    TextInputEditText timeEditText;
    AutoCompleteTextView departureTerminalDropdown, arrivalTerminalDropdown;
    Button bus;
    TextView arrow;
    private RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookseat);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }
        bus = findViewById(R.id.bus);
        arrow = findViewById(R.id.arrow);
        departureTerminalDropdown = findViewById(R.id.departureTerminalDropdown);
        arrivalTerminalDropdown = findViewById(R.id.arrivalTerminalDropdown);
        timeEditText = findViewById(R.id.timeEditText);
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected values
                String departure = departureTerminalDropdown.getText().toString();
                String arrival = arrivalTerminalDropdown.getText().toString();
                String travelDate = timeEditText.getText().toString();

                // Create an Intent to start the next activity
                Intent intent = new Intent(bookseat.this, searchticket.class);

                // Pass the values to the next activity using Intent extras
                intent.putExtra("DEPARTURE", departure);
                intent.putExtra("ARRIVAL", arrival);
                intent.putExtra("TRAVEL_DATE", travelDate);

                // Start the next activity
                startActivity(intent);
            }
        });


        //Recycler View part

        recyclerView = findViewById(R.id.Recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<CityPair> cityPairs = new ArrayList<>();
        cityPairs.add(new CityPair("Karachi", "Islamabad", "2024-01-1"));
        cityPairs.add(new CityPair("Islamabad", "Lahore", "2024-01-4"));
        cityPairs.add(new CityPair("Lahore", "Sialkot", "2024-01-5"));
        cityPairs.add(new CityPair("Sialkot", "Peshawar", "2024-01-9"));
        cityPairs.add(new CityPair("Peshawar", "Karachi", "2024-01-12"));
        cityPairs.add(new CityPair("Lahore", "Karachi", "2024-01-15"));
        cityPairs.add(new CityPair("Karachi", "Sialkot", "2024-01-18"));
        cityPairs.add(new CityPair("Sialkot", "Islamabad", "2024-01-21"));
        cityPairs.add(new CityPair("Islamabad", "Peshawar", "2024-01-24"));
        cityPairs.add(new CityPair("Peshawar", "Lahore", "2024-01-27"));
        cityPairs.add(new CityPair("Lahore", "Peshawar", "2024-01-30"));
        cityPairs.add(new CityPair("Peshawar", "Karachi", "2024-02-2"));
// Add more as needed





        adapter = new MyAdapter(this, cityPairs);
        recyclerView.setAdapter(adapter);

//Recycler View part close

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, new String[]{"Lahore", "Sialkot"});
        departureTerminalDropdown.setAdapter(cityAdapter);

        ArrayAdapter<String> cityAdapterArrival = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, new String[]{"Karachi", "Islamabad", "Lahore", "Sialkot", "Peshawar"});
        arrivalTerminalDropdown.setAdapter(cityAdapterArrival);

        // Click listener for departure terminal dropdown
        departureTerminalDropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                departureTerminalDropdown.showDropDown();
            }
        });

        // Click listener for arrival terminal dropdown
        arrivalTerminalDropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrivalTerminalDropdown.showDropDown();
            }
        });

        // Click listener for time edit text to show DatePickerDialog
        timeEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookseat.this, Dasboard.class);
                startActivity(intent);
            }
        });
    }

    private void showDatePickerDialog() {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDayOfMonth) {
                // Handle the selected date
                String selectedDate = selectedDayOfMonth + "/" + (selectedMonth + 1) + "/" + selectedYear;
                timeEditText.setText(selectedDate);
            }
        }, year, month, day);

        // Show the DatePickerDialog
        datePickerDialog.show();
    }
}
