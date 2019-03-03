package com.example.rjl77.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.rjl77.spacetrader.R;

public class MarketScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        TextView textView = (TextView) findViewById(R.id.c1);
        textView.setText("s");

    }



}
