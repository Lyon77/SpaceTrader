package com.example.rjl77.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.rjl77.spacetrader.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Gets the button to create the player
        Button create =  findViewById(R.id.button_create);
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

                    if (pilot + fighter + trader + engineer != 16) {
                        Log.i("Confirm sum to 16", "Does not sum to 16");
                    }
                    Log.i("Check", "Create Button Works");
                } catch (NumberFormatException exc) {
                    Log.i("Valid inputs", "Invalid inputs");

                }
            }
        });

        //button to exit the game and close the app
        Button exit =  findViewById(R.id.button_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
