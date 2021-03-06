package com.example.rjl77.spacetrader.views;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.rjl77.spacetrader.R;
import com.example.rjl77.spacetrader.entities.Item;
import com.example.rjl77.spacetrader.entities.Ship;
import com.example.rjl77.spacetrader.game.Game;


/**
 * Represents screen for viewing items in marketplace
 * @author Team 71
 * @version 1.0
 */
public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {

    private List<Item> itemList = new ArrayList<>();

    private OnItemClickListener listener;

    /**
     * Created a view holder for the market
     * @param parent is the view group to send to the parent class
     * @return a marketviewholder containing the data about the item
     */
    @NonNull
    @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.market_item, parent, false);

        return new MarketViewHolder(itemView);
    }

    /**
     * Sets up the display items
     * @param holder the place to hold the data
     * @param position which item to place the data into
     */
    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {

        Item item = itemList.get(position);

        Game game = Game.getInstance();
        Ship ship = game.getPlayerShip();

        holder.priceTag.setText(Integer.toString(item.getPrice()));
        holder.stock.setText(Integer.toString(ship.cargoAmount(item.getName())));
        holder.tradeGood.setText(item.getName());


    }

    /**
     * get the amount of items int item list
     * @return the amount of items
     */
    @Override
    public int getItemCount() {
        if(itemList == null) {
            return 0;
        }
        return itemList.size();
    }

    /**
     * creates the item list
     * @param market the current market
     * @param ship the player's ship
     */
    public void setItemList(HashMap<String, Integer> market, Ship ship) {
        List<Item> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : market.entrySet()) {
            String key = entry.getKey();
            list.add(new Item(key, entry.getValue(), ship.cargoAmount(key)));
        }
        itemList = list;
    }

//    public Item getItemAt(int position) {
//        return itemList.get(position);
//    }

    /**
     * The view holder for the items
     */
    class MarketViewHolder extends RecyclerView.ViewHolder {
        //View holder needs reference to each widget in the individual item in the list
        private TextView price;
        private TextView priceTag;
        private TextView cargo;
        private TextView stock;
        private TextView tradeGood;


        /**
         * Construct a new view holder, grab all the widget references and setup the
         * listener to detect a click on this item.
         *
         * @param itemView used in MarketViewHolder
         */
        protected MarketViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.uni);
            priceTag = itemView.findViewById(R.id.priceTag);
            cargo = itemView.findViewById(R.id.cargo);
            stock = itemView.findViewById(R.id.stock);
            tradeGood = itemView.findViewById(R.id.tradeGood);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClicked(itemList.get(position));
                    }
                }
            });

        }
    }

    /**
     * calls the item clicked method
     */
    public interface OnItemClickListener {
        void onItemClicked(Item course);
    }

    /**
     * sets the item click listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
