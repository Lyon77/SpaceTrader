package com.example.rjl77.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.rjl77.spacetrader.game.Game;
import com.example.rjl77.spacetrader.R;

public class Travel extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.travel_selector);

        game = Game.getInstance();

        Spinner planetSpinner = findViewById(R.id.planet_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, game.getUniverse().getSystemNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(adapter);

        TextView fuel = findViewById(R.id.fuel);
        fuel.setText("Fuel: " + game.getPlayerShip().getFuel());

        Button travel = findViewById(R.id.button_travel);
        travel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Spinner mySpinner = findViewById(R.id.planet_spinner);
                String text = mySpinner.getSelectedItem().toString();

                if (game.getPlayerShip().getFuel() > 0) {
                    Log.i("Planet", "No Fuel");
                    startActivity(new Intent(Travel.this, PlanetScreen.class));
                }

                if (game.getUniverse().setCurrentSystem(text)){
                    Log.i("Planet", game.currentPlanetName());
                    game.getPlayerShip().setFuel(game.getPlayerShip().getFuel() - 1);
                    startActivity(new Intent(Travel.this, PlanetScreen.class));
                } else {
                    Log.i("Planet", "Failed Travel");
                }
            }

        });

    }


}
