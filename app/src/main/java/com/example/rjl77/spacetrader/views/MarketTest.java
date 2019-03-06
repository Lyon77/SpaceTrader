package com.example.rjl77.spacetrader.views;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.example.rjl77.spacetrader.R;


import com.example.rjl77.spacetrader.game.Game;

public class MarketTest extends AppCompatActivity {

    /** a reference to our Game */
    private Game game;

    /** make an adapter for the list of courses */
    private final MarketAdapter adapter = new MarketAdapter();

    /** an integer used because add a course returns something */
    public static final int ADD_COURSE_REQUEST_ID = 1;

    /** a string key for passing the course in a map */
    public static final String EXTRA_COURSE = "edu.gatech.cs2340.lab3newcomponents.views.EXTRA_COURSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_main);

        game = Game.getInstance();

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

//        //This code sets up a listener so that if you click on a course, we launch the detail screen
//        adapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClicked(Item item) {
//                Intent intent = new Intent(MarketTest.this, BuySell.class);
//                intent.putExtra(EXTRA_COURSE, item);
//                startActivity(intent);
//            }
//        });

        adapter.setItemList(game.getCurrentSystemMarket(), game.getPlayerShip());
    }
}
