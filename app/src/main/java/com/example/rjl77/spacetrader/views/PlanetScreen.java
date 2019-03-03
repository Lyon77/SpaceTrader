package com.example.rjl77.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.rjl77.spacetrader.R;

public class PlanetScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planetscreen);
    }

    public void onMarketPressed(View view) {
        Intent intent = new Intent(this, MarketScreen.class);
        startActivity(intent);
    }
}
