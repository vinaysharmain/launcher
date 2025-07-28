package com.example.launcher.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launcher.R;

import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppViewHolder> {

    private final List<ResolveInfo> appList;
    private final PackageManager packageManager;
    private final Context context;

    public AppListAdapter(Context context, List<ResolveInfo> appList) {
        this.context = context;
        this.appList = appList;
        this.packageManager = context.getPackageManager();
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        ResolveInfo appInfo = appList.get(position);
        String appName = appInfo.loadLabel(packageManager).toString();
        holder.appName.setText(appName);

        // Set click listener to launch the app
        holder.itemView.setOnClickListener(v -> {
            Intent launchIntent = packageManager.getLaunchIntentForPackage(
                    appInfo.activityInfo.packageName);
            if (launchIntent != null) {
                context.startActivity(launchIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {
        TextView appName;

        AppViewHolder(View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.app_name);
        }
    }
}