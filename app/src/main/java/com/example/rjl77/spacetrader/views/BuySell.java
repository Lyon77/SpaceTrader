package com.example.rjl77.spacetrader.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.rjl77.spacetrader.R;
import com.example.rjl77.spacetrader.entities.Item;
import com.example.rjl77.spacetrader.entities.Player;
import com.example.rjl77.spacetrader.entities.Ship;
import com.example.rjl77.spacetrader.game.Game;


public class BuySell extends AppCompatActivity {

    /* ************************
       Widgets we will need for binding and getting information
    */
    private TextView price;
    private TextView name;
    private TextView cargo;
    private TextView balance;
    private EditText buysell;
    private Button save_button;
    private Button exit_button;
    private Game game = Game.getInstance();
    private Player p = game.getPlayer();
    private Ship ship = p.getShip();
    private Item item;
    private String cargoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        /*
         * Grab the dialog widgets so we can get info for later
         */
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        cargo = findViewById(R.id.cargo);
        balance = findViewById(R.id.balance);
        buysell = findViewById(R.id.buysell);
        save_button = findViewById(R.id.save_button);
        exit_button = findViewById(R.id.exit_button);


        //buy or sell - set default data
        Bundle bundle = getIntent().getExtras();
        setTitle("Buying or Selling");

        cargoName = bundle.getString("Name");
        name.setText(cargoName);
        price.setText(bundle.getString("Price"));
        cargo.setText(bundle.getString("CargoAmt"));
        balance.setText(String.valueOf(p.getCredits()));

        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuySell.this, MarketView.class));
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSavePressed(v);
            }
        });

    }

    /**
     * Button handler save
     *
     * @param view the button that was pressed for buy and sell
     */
    public void onSavePressed(View view) {
        int buysel = Integer.parseInt(buysell.getText().toString());
        int credit = p.getCredits();
        int price_ = Integer.parseInt(price.getText().toString());
        int amount = ship.cargoAmount(cargoName);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        cargo = findViewById(R.id.cargo);
        balance = findViewById(R.id.balance);

        if (buysel < 0) {
            if (amount + buysel >= 0 && ship.hasRoomToBuy(buysel)) {
                p.setCredits(credit - buysel * price_);
                ship.sellCargo(cargoName, Math.abs(buysel));
                balance.setText(String.valueOf(p.getCredits()));
                cargo.setText(String.valueOf(ship.cargoAmount(cargoName)));
            } else {
                Log.d("Edit", "not enough of items");
            }
        } else if (buysel > 0) {
            if (credit - buysel * price_ >= 0) {
                p.setCredits(credit - buysel * price_);
                balance.setText(String.valueOf(p.getCredits()));
                ship.addCargo(cargoName, buysel);
                cargo.setText(String.valueOf(ship.cargoAmount(cargoName)));
            } else {
                Log.d("Edit", "not enough money");
            }
        } else {
            Log.d("Edit", "set nonzero buy/sell");
        }


    }



}



