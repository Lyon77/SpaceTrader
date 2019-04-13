package com.example.rjl77.spacetrader.views;


//import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rjl77.spacetrader.R;


import com.example.rjl77.spacetrader.entities.Item;
import com.example.rjl77.spacetrader.game.Game;

/**
 * Represents screen for market
 * @author Team 71
 * @version 1.0
 */
public class MarketView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Game game;
        TextView balance;
        Button leaveBtn;
        MarketAdapter adapter;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_main);
        game = Game.getInstance();

        /*get balance
         */
        balance = findViewById(R.id.balance);
        balance.setText(String.valueOf(game.getPlayerCredits()));

        leaveBtn = findViewById(R.id.leave);

        leaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MarketView.this, PlanetScreen.class));
            }
        });

        adapter = new MarketAdapter();
        /*
          Now we need to set up the view for holding the list of courses
         */
        //first grab a reference to the widget
        RecyclerView recyclerView = findViewById(R.id.market_list);
        //Set the layout manager for the list to just be a vertical list of stuff
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        //Setup the adapter for the view
        recyclerView.setAdapter(adapter);

        adapter.setItemList(game.getCurrentSystemMarket(), game.getPlayerShip());

        //This code sets up a listener so that if you click on a course, we launch the detail screen
        adapter.setOnItemClickListener(new MarketAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(Item item) {
                Intent intent = new Intent(MarketView.this, BuySell.class);

                Bundle bundle = new Bundle();

                bundle.putString("Name", item.getName());
                bundle.putString("Price", String.valueOf(item.getPrice()));
                bundle.putString("CargoAmt", String.valueOf(item.getCargoAmt()));
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }


}
