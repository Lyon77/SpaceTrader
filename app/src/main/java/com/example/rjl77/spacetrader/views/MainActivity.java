package com.example.rjl77.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;



import com.example.rjl77.spacetrader.R;
import com.example.rjl77.spacetrader.entities.GameDifficulty;
import com.example.rjl77.spacetrader.entities.Player;
import com.example.rjl77.spacetrader.game.Game;

public class MainActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = Game.getInstance();

        //Gets the button to create the player
        Button create = findViewById(R.id.button_create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add the code here to check for player points
                try {
                    EditText pilot_skill = findViewById(R.id.pilot_skill_points);
                    int pilot = Integer.parseInt(pilot_skill.getText().toString());
                    EditText fighter_skill = findViewById(R.id.fighter_skill_points);
                    int fighter = Integer.parseInt(fighter_skill.getText().toString());
                    EditText trader_skill = findViewById(R.id.trader_skill_points);
                    int trader = Integer.parseInt(trader_skill.getText().toString());
                    EditText engineer_skill = findViewById(R.id.engineer_skill_points);
                    int engineer = Integer.parseInt(engineer_skill.getText().toString());
                    Spinner mySpinner = findViewById(R.id.game_difficulty_spinner);
                    String text = mySpinner.getSelectedItem().toString();
                    EditText username = findViewById(R.id.username_entry);
                    String name = username.getText().toString();

                    if (pilot + fighter + trader + engineer == 16 && name != null && !name.equals("")) {
                        game.setPlayer(new Player(name, pilot, fighter, trader, engineer, text));
                        Log.i("Player", game.getPlayerInfo());
                        startActivity(new Intent(MainActivity.this, PlanetScreen.class));
                    } else {
                        Log.e("Value", "Invalid inputs");
                    }
                } catch (NumberFormatException exc) {
                    Log.e("Fail", exc.getMessage());
                }


            }
        });

        //set difficulty
        Spinner gameDifficultySpinner = findViewById(R.id.game_difficulty_spinner);
        ArrayAdapter<GameDifficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameDifficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gameDifficultySpinner.setAdapter(adapter);

        //button to exit the game and close the app
        final Button exit =  findViewById(R.id.button_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
