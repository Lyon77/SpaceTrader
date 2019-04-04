package com.example.rjl77.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.File;

import android.util.Log;

import com.example.rjl77.spacetrader.R;
import com.example.rjl77.spacetrader.game.Game;

public class PlanetScreen extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planetscreen);

        game = Game.getInstance();

        TextView name = findViewById(R.id.planetName);
        name.setText(game.currentPlanetName());

        Button market =  findViewById(R.id.button_market);
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlanetScreen.this, MarketView.class));
            }
        });

        Button travel =  findViewById(R.id.button_travel);
        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlanetScreen.this, Travel.class));
            }
        });

        Button exit =  findViewById(R.id.button_new);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                System.exit(0);
                moveTaskToBack(true);
            }
        });

        Button save = findViewById(R.id.button_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(".", "data.json");
                try {
                    file.createNewFile();
                } catch (Exception e){
                    Log.e("FileCreation", "Failed to create file.");
                }
                game.saveJson(file);
            }
        });
    }
}
