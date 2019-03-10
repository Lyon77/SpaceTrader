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
    public static int credit = 1000;
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
        balance.setText(String.valueOf(credit));


    }

    /**
     * Button handler save
     *
     * @param view the button that was pressed for buy and sell
     */
    public void onSavePressed(View view) {
        int buysel = Integer.parseInt(buysell.getText().toString());
        credit = Integer.parseInt(balance.getText().toString());
        int price_ = Integer.parseInt(price.getText().toString());
        if ((credit-(price_*buysel))<0) {
            Log.d("Edit", "not enough balance");
        } else {
            credit = credit-(price_*buysel);
            balance.setText(String.valueOf(credit));

        }

    }




    public static int getRemain(){return credit;};

}



