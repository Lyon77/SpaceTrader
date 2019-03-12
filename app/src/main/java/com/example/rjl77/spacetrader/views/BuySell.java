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
        item = (Item) getIntent().getSerializableExtra(MarketView.EXTRA_COURSE);
        setTitle("Buying or Selling");

        name.setText(item.getName());
        price.setText(String.valueOf(item.getPrice()));
        cargo.setText(String.valueOf(item.getCargoAmt()));
        balance.setText(String.valueOf(p.getCredits()));


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
        int amount = item.getCargoAmt();

        if (buysel < 0) {
            if (amount + buysel > 0) {
                p.setCredits(credit + buysel * price_);
                ship.sellCargo(item.getName(), amount);
                startActivity(new Intent(BuySell.this, MarketView.class));
            } else {
                Log.d("Edit", "not enough of item");
            }
        } else if (buysel > 0) {
            if (credit - buysel * price_ > 0) {
                p.setCredits(credit - buysel * price_);
                ship.addCargo(item.getName(), amount);
            } else {
                Log.d("Edit", "not enough money");
            }
        } else {
            Log.d("Edit", "set nonzero buy/sell");
        }


    }

}



