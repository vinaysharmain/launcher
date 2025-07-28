package com.example.launcher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LauncherActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AppListAdapter appListAdapter;
    private List<ResolveInfo> essentialApps;

    // Essential apps that help reduce screen time
    private final List<String> allowedApps = Arrays.asList(
        "com.android.dialer",           // Phone
        "com.android.contacts",         // Contacts
        "com.android.mms",              // Messages
        "com.android.camera2",          // Camera
        "com.android.camera",           // Camera (alternative)
        "com.android.settings",         // Settings
        "com.android.calculator2",      // Calculator
        "com.android.calendar",         // Calendar
        "com.google.android.apps.maps", // Maps
        "com.android.clock",            // Clock/Alarm
        "com.android.email",            // Email
        "com.google.android.gm"         // Gmail
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadEssentialApps();
    }

    private void loadEssentialApps() {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> allApps = packageManager.queryIntentActivities(intent, 0);
        
        essentialApps = new ArrayList<>();
        
        // Filter to only include essential apps
        for (ResolveInfo app : allApps) {
            String packageName = app.activityInfo.packageName;
            if (allowedApps.contains(packageName)) {
                essentialApps.add(app);
            }
        }
        
        appListAdapter = new AppListAdapter(this, essentialApps);
        recyclerView.setAdapter(appListAdapter);
    }
}