package com.example.busreservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class Dasboard extends AppCompatActivity {
    private CardView bookSeatCardView, buyTicketCardView, myBookingCardView, refundCardView, complaintsCardView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }

        // Initialize CardViews
        bookSeatCardView = findViewById(R.id.BookSeat);
        buyTicketCardView = findViewById(R.id.BuyTicket);
        myBookingCardView = findViewById(R.id.MyBooking);
        refundCardView = findViewById(R.id.Refund);



        bookSeatCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click as per your existing logic
                Intent intent = new Intent(Dasboard.this, bookseat.class);
                startActivity(intent);
            }
        });

        buyTicketCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dasboard.this, buyticket.class);
                startActivity(intent);
            }
        });

        myBookingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        refundCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dasboard.this, refund.class);
                startActivity(intent);
            }
        });


    }
}
