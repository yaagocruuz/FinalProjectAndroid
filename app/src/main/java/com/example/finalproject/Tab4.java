package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Tab4 extends Fragment {

    public TextView internetStatus;
    private Button btMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab4, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        internetStatus = getView().findViewById(R.id.internet_status);
        btMap = getView().findViewById(R.id.btOpenMap);

        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            changeTextStatus(true);
        } else {
            changeTextStatus(false);
        }

        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMapActivity = new Intent(Tab4.super.getContext(), MapsActivity.class);
                startActivity(openMapActivity);
            }
        });

    }

    public void changeTextStatus(boolean isConnected) {
        // Change status according to boolean value
        if (isConnected) {
            internetStatus.setText("Internet Connected.");
            internetStatus.setTextColor(Color.parseColor("#00ff00"));
        } else {
            internetStatus.setText("Internet Disconnected.");
            internetStatus.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MyApplication.activityPaused();// On Pause notify the Application
    }

    @Override
    public void onResume() {
        super.onResume();
        MyApplication.activityResumed();// On Resume notify the Application
    }

}
