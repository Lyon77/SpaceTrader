package com.example.rjl77.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;
import java.io.File;

//import android.util.Log;

import com.example.rjl77.spacetrader.R;
import com.example.rjl77.spacetrader.game.Game;

/**
 * Represents main screen of game
 * @author Team 71
 * @version 1.0
 */
public class MainScreen extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = Game.getInstance();

        Button load = findViewById(R.id.button_load);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, PlanetScreen.class));
                File file = new File(getApplicationContext().getFilesDir(), "data.json");
                game.loadJson(file);
            }
        });

        Button new1 = findViewById(R.id.button_new);
        new1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, CreateActivity.class));
            }
        });
    }
}
