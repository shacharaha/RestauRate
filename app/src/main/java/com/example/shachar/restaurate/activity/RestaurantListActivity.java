package com.example.shachar.restaurate.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shachar.restaurate.Constants;
import com.example.shachar.restaurate.LogUtils;
import com.example.shachar.restaurate.model.Restaurant;
import com.example.shachar.resturate.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Restaurant> restaurantList;
    String[] restaurantsNames;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        restaurantList = new ArrayList<>();

        Intent intent = getIntent();
        try {
            JSONArray restaurantJSONArray = new JSONArray(intent.getStringExtra(Constants.RESTAURANTS));
            for(int i = 0 ; i < restaurantJSONArray.length(); i++) {
                restaurantList.add(new Restaurant(restaurantJSONArray.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        restaurantsNames = new String[restaurantList.size()];
        for (int i = 0; i < restaurantsNames.length; i++) {
            restaurantsNames[i] = restaurantList.get(i).toString();
        }
        listView = (ListView)findViewById(R.id.lv_restaurant_list);
        adapter = new ArrayAdapter(this, R.layout.list_item, restaurantsNames);
        listView.setAdapter(adapter);
    }
}
