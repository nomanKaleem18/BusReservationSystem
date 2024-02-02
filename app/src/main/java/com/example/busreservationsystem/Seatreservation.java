package com.example.busreservationsystem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Seatreservation extends AppCompatActivity {
    private TextView otpBox1, otpBox2, otpBox3, otpBox4, otpBox5, otpBox6, otpBox7, otpBox8, otpBox9,t1,t2,t3;
    Button book;
    private boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seatreservation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }
   t1=findViewById(R.id.t1);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t2);
        book=findViewById(R.id.book);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Seatreservation.this,SearReservation1.class);
                startActivity(intent);
            }
        });
        String departure = getIntent().getStringExtra("DEPARTURE");
        String arrival = getIntent().getStringExtra("ARRIVAL");
        String travelDate = getIntent().getStringExtra("TRAVEL_DATE");

        // Display data in TextViews
        t1.setText(departure);
        t2.setText(arrival);
        t3.setText(travelDate);

        // Find TextViews by their IDs
        otpBox1 = findViewById(R.id.otpBox1);
        otpBox2 = findViewById(R.id.otpBox2);
        otpBox3 = findViewById(R.id.otpBox3);
        otpBox4 = findViewById(R.id.otpBox4);
        otpBox5 = findViewById(R.id.otpBox5);
        otpBox6 = findViewById(R.id.otpBox6);
        otpBox7 = findViewById(R.id.otpBox7);
        otpBox8 = findViewById(R.id.otpBox8);
        otpBox9 = findViewById(R.id.otpBox9);

        // Set initial background color for each TextView
        setInitialBackgroundColor(otpBox1);
        setInitialBackgroundColor(otpBox2);
        setInitialBackgroundColor(otpBox3);
        setInitialBackgroundColor(otpBox4);
        setInitialBackgroundColor(otpBox5);
        setInitialBackgroundColor(otpBox6);
        setInitialBackgroundColor(otpBox7);
        setInitialBackgroundColor(otpBox8);
        setInitialBackgroundColor(otpBox9);

        // Set OnClickListener for each TextView
        setOnClickListenerForTextView(otpBox1);
        setOnClickListenerForTextView(otpBox2);
        setOnClickListenerForTextView(otpBox3);
        setOnClickListenerForTextView(otpBox4);
        setOnClickListenerForTextView(otpBox5);
        setOnClickListenerForTextView(otpBox6);
        setOnClickListenerForTextView(otpBox7);
        setOnClickListenerForTextView(otpBox8);
        setOnClickListenerForTextView(otpBox9);
    }

    private void setOnClickListenerForTextView(final TextView textView) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle the click state
                isClicked = !isClicked;


                if (isClicked) {
                    textView.setBackgroundColor(Color.parseColor("#DDA6E6")); // Set to orange color
                } else {
                    setInitialBackgroundColor(textView);
                }
            }
        });
    }

    private void setInitialBackgroundColor(TextView textView) {
        textView.setBackgroundColor(Color.parseColor("#BDBDBD")); // Set to white color
    }

}
