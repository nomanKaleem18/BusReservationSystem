package com.example.busreservationsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class searchticket extends AppCompatActivity {
    TextView t1, t2, t3, a1, a2, a3, a11, a22, a33;
    RecyclerView recyclerView;
    BusAdapter busAdapter;
    List<Bus> allBuses;
    CardView cardView,cardview1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchticket);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a11 = findViewById(R.id.a11);
        a22 = findViewById(R.id.a22);

        cardView = findViewById(R.id.cardview);
        cardview1 = findViewById(R.id.cardview1);

        // Get user input from Intent
        String departure = getIntent().getStringExtra("DEPARTURE");
        String arrival = getIntent().getStringExtra("ARRIVAL");
        String travelDate = getIntent().getStringExtra("TRAVEL_DATE");

        // Display data in TextViews
        t1.setText(departure);
        t2.setText(arrival);
        t3.setText(travelDate);
        // Display data in TextViews
        a1.setText(departure);
        a2.setText(arrival);
        a3.setText(travelDate);

        // Set onClickListener for the CardView
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(searchticket.this,Seatreservation.class);
                startActivity(intent);
            }
        });
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(searchticket.this,Seatreservation.class);
                startActivity(intent);
            }
        });
    }
}
