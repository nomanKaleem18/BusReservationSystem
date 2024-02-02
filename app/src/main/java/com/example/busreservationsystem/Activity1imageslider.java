package com.example.busreservationsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Activity1imageslider extends AppCompatActivity {

    ImageSlider imageSlider;
    Button OTP;
    EditText Mobile;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1imageslider);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }
        // Initialize UI components
        imageSlider = findViewById(R.id.imageSlider);
        OTP = findViewById(R.id.OTP);
        progressBar = findViewById(R.id.progressBar);
        Mobile = findViewById(R.id.Mobile);

        // Create a list of slide models for the image slider
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        int imageResource1 = R.drawable.imageslider1;
        int imageResource2 = R.drawable.n1;
        int imageResource3 = R.drawable.n2;
        int imageResource4 = R.drawable.imageslider2;

        slideModels.add(new SlideModel(imageResource1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageResource2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageResource3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(imageResource4, ScaleTypes.FIT));

        // Set the image list for the image slider
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        // Set onClickListener for the OTP button
    /* OTP.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        progressBar.setVisibility(View.VISIBLE);
        OTP.setVisibility(View.GONE);

        // Get the mobile number from the EditText
        String mobileNumber = Mobile.getText().toString();

        // Validate mobile number
        if (mobileNumber.isEmpty()) {
            Toast.makeText(Activity1imageslider.this, "Mobile Number is Empty", Toast.LENGTH_SHORT).show();
        } else if (mobileNumber.length() != 10) {
            Toast.makeText(Activity1imageslider.this, "Mobile Number should be 10 digits", Toast.LENGTH_SHORT).show();
        } else if (!mobileNumber.startsWith("0")) {
            Toast.makeText(Activity1imageslider.this, "Mobile Number should start with '0'", Toast.LENGTH_SHORT).show();
        } else if (!TextUtils.isDigitsOnly(mobileNumber)) {
            Toast.makeText(Activity1imageslider.this, "Mobile Number should only contain digits", Toast.LENGTH_SHORT).show();
        } else {
            // Mobile Number is valid, proceed to the next activity
            Intent intent = new Intent(Activity1imageslider.this, Activity2OTP.class);
            intent.putExtra("MOBILE_NUMBER", mobileNumber);
            startActivity(intent);
        }
    }
});

                // Start phone number verification
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+92" + Mobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        Activity1imageslider.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(PhoneAuthCredential credential) {
                                progressBar.setVisibility(View.GONE);
                                OTP.setVisibility(View.VISIBLE);

                                // Auto-fill the OTP and proceed to the next activity
                                String autoOtp = credential.getSmsCode();
                                if (autoOtp != null) {
                                    Intent intent = new Intent(Activity1imageslider.this, Activity2OTP.class);
                                    intent.putExtra("AUTO_OTP", autoOtp);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onVerificationFailed(FirebaseException e) {
                                progressBar.setVisibility(View.GONE);
                                OTP.setVisibility(View.VISIBLE);

                                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                    Toast.makeText(Activity1imageslider.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                                } else if (e instanceof FirebaseTooManyRequestsException) {
                                    Toast.makeText(Activity1imageslider.this, "Quota exceeded, please try again later", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Activity1imageslider.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {
                                progressBar.setVisibility(View.GONE);
                                OTP.setVisibility(View.VISIBLE);

                                // Start the OTP verification activity
                                Intent intent = new Intent(Activity1imageslider.this, Activity2OTP.class);
                                intent.putExtra("VERIFICATION_ID", verificationId);
                                startActivity(intent);
                            }
                        }
                );
            }
        });
    }

        */
        OTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1imageslider.this, Activity2OTP.class);
                startActivity(intent);
            }
        });
    }
}