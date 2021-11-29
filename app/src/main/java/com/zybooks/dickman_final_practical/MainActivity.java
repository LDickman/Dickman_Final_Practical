package com.zybooks.dickman_final_practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callButton = findViewById(R.id.call_number_button);
    }

    public void callNumber(View view) {
        String number = callButton.getText().toString();
        Uri phoneNumber = Uri.parse("tel:" + number);
        Intent intent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void onNextClick(View view) {
        Intent intent = new Intent(this, SelectConcertActivity.class);
        startActivity(intent);
    }
}