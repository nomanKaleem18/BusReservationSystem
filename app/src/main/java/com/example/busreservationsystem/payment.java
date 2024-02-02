package com.example.busreservationsystem;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.busreservationsystem.R;

public class payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }

        // JazzCash Option Click
        LinearLayout jazzCashLayout = findViewById(R.id.jaz);
        jazzCashLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPhoneNumberDialog("JazzCash");
            }
        });

        // EasyPaisa Option Click
        LinearLayout easyPaisaLayout = findViewById(R.id.easy);
        easyPaisaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPhoneNumberDialog("EasyPaisa");
            }
        });
    }

    private void showPhoneNumberDialog(String paymentOption) {
        // Create an AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate the layout for the dialog
        View dialogView = inflater.inflate(R.layout.dialog_phone_cnic_input, null);
        builder.setView(dialogView);

        // Set the title for the dialog
        builder.setTitle("Enter " + paymentOption + " Phone Number or CNIC");

        // Set positive button (OK button) and its action
        builder.setPositiveButton("Make Payment", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle the input from the dialog
                EditText phoneEditText = dialogView.findViewById(R.id.phoneEditText);
                EditText cnicEditText = dialogView.findViewById(R.id.cnicEditText);

                String phoneInput = phoneEditText.getText().toString();
                String cnicInput = cnicEditText.getText().toString();

                // You can now use the inputs as needed (e.g., display in a toast)
                Toast.makeText(payment.this, "Entered Phone: " + phoneInput + "\nEntered CNIC: " + cnicInput, Toast.LENGTH_SHORT).show();
            }
        });


        // Set negative button (Cancel button)
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancel the dialog
                dialog.cancel();
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
