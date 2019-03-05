package com.example.rjl77.spacetrader.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rjl77.spacetrader.R;
import com.example.rjl77.spacetrader.entities.GameDifficulty;
import com.example.rjl77.spacetrader.entities.Item;
import com.example.rjl77.spacetrader.entities.Market;

import java.util.HashMap;

public class MarketScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        //set item
        Spinner itemSpinner = findViewById(R.id.item_spinner);
        ArrayAdapter<Item> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Item.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(adapter);

    }





    public void onBackPressed(View view) { onBackPressed();}
}
