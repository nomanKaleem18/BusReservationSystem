package com.example.busreservationsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class Activity2OTP extends AppCompatActivity {

    private EditText digit1, digit2, digit3, digit4, digit5, digit6;
    private Button verifyButton;
    String getOtp;
    ProgressBar progress;
    TextView resend;
    TextView mob;
    TextView arrow1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_otp);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.appbackground));
        }
        digit1 = findViewById(R.id.digit1);
        digit2 = findViewById(R.id.digit2);
        digit3 = findViewById(R.id.digit3);
        digit4 = findViewById(R.id.digit4);
        digit5 = findViewById(R.id.digit5);
        digit6 = findViewById(R.id.digit6);
        progress = findViewById(R.id.progress);
        resend = findViewById(R.id.resend);
        arrow1=findViewById(R.id.arrow1);
        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Activity2OTP.this,Activity1imageslider.class);
                startActivity(intent);
            }
        });
        String mobileNumber = getIntent().getStringExtra("MOBILE_NUMBER");
        mob = findViewById(R.id.mob);
        mob.setText("Mobile Number: " + mobileNumber);
        verifyButton = findViewById(R.id.Verify);
       /*
        getOtp = getIntent().getStringExtra("VERIFICATION_ID");

resend.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        resendOTP();
    }
});
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enterCode = digit1.getText().toString() +
                        digit2.getText().toString() +
                        digit3.getText().toString() +
                        digit4.getText().toString() +
                        digit5.getText().toString() +
                        digit6.getText().toString();
                if (getOtp != null) {
                    progress.setVisibility(View.VISIBLE);
                    verifyButton.setVisibility(View.INVISIBLE);
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getOtp, enterCode);
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(Activity2OTP.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progress.setVisibility(View.GONE);
                                        verifyButton.setVisibility(View.VISIBLE);

                                        Intent intent = new Intent(Activity2OTP.this, Activity3Login.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        progress.setVisibility(View.INVISIBLE);
                                        verifyButton.setVisibility(View.VISIBLE);
                                        Toast.makeText(Activity2OTP.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(Activity2OTP.this, "Please Check Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

        NumberOtpMove();
    }
    private void NumberOtpMove() {
        digit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    digit2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        digit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    digit3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        digit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    digit4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        digit4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    digit5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        digit5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().trim().isEmpty()) {
                    digit6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void resendOTP() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+92" + getIntent().getStringExtra("Mobile"),
                60,
                TimeUnit.SECONDS,
                Activity2OTP.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential credential) {
                        // Handle verification completed, if needed
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(Activity2OTP.this, "Resend Failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {
                        getOtp = verificationId;
                        Toast.makeText(Activity2OTP.this, "OTP Resent", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

        */
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2OTP.this, Activity4Register.class);
                startActivity(intent);
            }
        });
    }


}


