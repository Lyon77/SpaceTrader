package com.example.rjl77.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        Button market =  findViewById(R.id.market);
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlanetScreen.this, MarketTest.class));
            }
        });
    }
}
