package com.example.firebaseauthentication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    ImageView back_arrow;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        back_arrow = findViewById(R.id.back_arrow3);

        back_arrow.setOnClickListener(view -> {
            finish();
        });
    }
}