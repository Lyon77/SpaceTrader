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
import android.widget.Toast;

import java.util.Random;


import com.example.rjl77.spacetrader.entities.Universe;
import com.example.rjl77.spacetrader.game.Game;
import com.example.rjl77.spacetrader.R;
import com.example.rjl77.spacetrader.entities.Ship;
import com.example.rjl77.spacetrader.entities.Market.TradeGood;

/**
 * Represents screen for selecting travel
 * @author Team 71
 * @version 1.0
 */
public class Travel extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.travel_selector);

        game = Game.getInstance();
        Universe universe = game.getUniverse();
        Ship ship = game.getPlayerShip();

        Spinner planetSpinner = findViewById(R.id.planet_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.my_spinner, universe.getSystemNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(adapter);

        TextView fuel = findViewById(R.id.fuel);
        fuel.setText("Fuel: " + ship.getFuel());

        Button travel = findViewById(R.id.button_travel);
        travel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Spinner mySpinner = findViewById(R.id.planet_spinner);
                String text = mySpinner.getSelectedItem().toString();
                Universe uni = game.getUniverse();
                Ship ship = game.getPlayerShip();

                if (ship.getFuel() > 0) {
                    Log.i("Planet", "No Fuel");
                    startActivity(new Intent(Travel.this, PlanetScreen.class));
                }

                if (uni.setCurrentSystem(text)){
                    Log.i("Planet", game.currentPlanetName());
                    ship.setFuel(ship.getFuel() - 1);
                    Random r = new Random();
                    int randomEvent = r.nextInt(10);
                    if (randomEvent == 0 && ship.hasCargo(TradeGood.FOOD.toString())) {
                        ship.sellCargo(TradeGood.FOOD.toString(), ship.cargoAmount(
                                TradeGood.FOOD.toString())/2);
                        Toast.makeText(getApplicationContext(), "A hoard of starving pirates " +
                                "stole half your food.", Toast.LENGTH_LONG).show();
                    } else if (randomEvent == 1 && ship.hasCargo(TradeGood.NARCOTICS.toString())) {
                        ship.sellCargo(TradeGood.NARCOTICS.toString(), ship.cargoAmount(
                                TradeGood.NARCOTICS.toString ()));
                        Toast.makeText(getApplicationContext(), "The police pulled you over for " +
                                "speeding and confiscated all your narcotics.",
                                Toast.LENGTH_LONG).show();
                    } else if (randomEvent == 2) {
                        ship.setFuel(ship.getFuel() + 15);
                        Toast.makeText(getApplicationContext(), "An overburdened gasoline " +
                                "trader ship gave you 15 units of fuel.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Uneventful flight.",
                                Toast.LENGTH_LONG).show();
                    }
                    startActivity(new Intent(Travel.this, PlanetScreen.class));
                } else {
                    Log.i("Planet", "Failed Travel");
                }
            }

        });

    }


}
