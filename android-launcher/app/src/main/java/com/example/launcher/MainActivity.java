package com.example.launcher;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start the LauncherActivity to display the list of installed applications
        Intent intent = new Intent(this, LauncherActivity.class);
        startActivity(intent);
        finish();
    }
}