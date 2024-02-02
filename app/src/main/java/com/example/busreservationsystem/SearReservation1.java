package com.example.busreservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class SearReservation1 extends AppCompatActivity {
    Button Makepayment,seat,home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sear_reservation1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }
        Makepayment=findViewById(R.id.Makepayment);
        seat=findViewById(R.id.seat);
        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SearReservation1.this,bookseat.class);
                startActivity(intent);
            }
        });
        Makepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SearReservation1.this,payment.class);
                startActivity(intent);
            }
        });
        seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the custom popup dialog
                showSeatReservationPopup();
            }
        });
    }

    // Method to show the custom seat reservation popup
    private void showSeatReservationPopup() {
        // Create a custom dialog
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_seat_reservation_popup);

        // Customize your popup layout
        TextView popupMessage = dialog.findViewById(R.id.popupMessage);
        Button closeButton = dialog.findViewById(R.id.closeButton);

        // Set the popup message
        popupMessage.setText("Your temporary seat has been reserved!");

        // Set onClickListener for the close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss the popup dialog when the close button is clicked
                dialog.dismiss();
            }
        });

        // Show the custom dialog
        dialog.show();
    }
}
