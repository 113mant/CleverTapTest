package com.example.clevertaptest;
import android.app.NotificationManager;        //added by CleverTap Assistant
import com.clevertap.android.sdk.CleverTapAPI; //added by CleverTap Assistant

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private CleverTapAPI clevertapDefaultInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());   //Initializing the CleverTap SDK
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		CleverTapAPI.createNotificationChannel(getApplicationContext(),"TestOne","mychannel","lDescription",NotificationManager.IMPORTANCE_MAX,true);        //added by CleverTap Assistant
    }

    public void UpdateEmailBtn_Clicked(View v) {
        EditText emailEditText = findViewById(R.id.emailAddressEditText);
        HashMap<String,Object> map = new HashMap<>();
        map.put("Email",emailEditText.getText().toString());
        clevertapDefaultInstance.onUserLogin(map);
        Toast toast = Toast.makeText(getApplicationContext(),"Email has been updated",Toast.LENGTH_LONG);
        toast.show();
    }

    public void RaiseProductViewedBtn_Clicked(View v) {
        EditText emailEditText = findViewById(R.id.emailAddressEditText);
        HashMap<String,Object> map = new HashMap<>();
        map.put("Email",emailEditText.getText().toString());        map.put("Product ID",1);
        map.put("Product Image","https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");
        map.put("Product Name","CleverTap");
        clevertapDefaultInstance.pushEvent("Product Viewed", map);
        Toast toast = Toast.makeText(getApplicationContext(),"Product Viewed has been updated",Toast.LENGTH_LONG);
        toast.show();
    }
}
