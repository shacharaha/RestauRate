package com.example.shachar.restaurate.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shachar.restaurate.Constants;
import com.example.shachar.restaurate.LogUtils;
import com.example.shachar.restaurate.model.Restaurant;
import com.example.shachar.resturate.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int NEW_RESTAURANT_ACTIVITY = 0;
    private ArrayList<Restaurant> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCreateNewRestaurant = (Button) findViewById(R.id.btn_create_new_restaurant);
        Button btnRestaurantList = (Button) findViewById(R.id.btn_restaurant_list);
        btnCreateNewRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewRestaurantActivity();
            }
        });
        btnRestaurantList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArray jsonArray = new JSONArray();
                for (int i = 0; i < restaurants.size(); i++) {
                    jsonArray.put(restaurants.get(i).toJSON());
                }
                startRestaurantListActivity(jsonArray.toString());
            }
        });
        restaurants = new ArrayList<>();
    }

    private void startNewRestaurantActivity() {
        Intent intent = new Intent(this, NewRestaurantActivity.class);
        startActivityForResult(intent, NEW_RESTAURANT_ACTIVITY);
    }

    private void startRestaurantListActivity(String input) {
        Intent intent = new Intent(this, RestaurantListActivity.class);
        intent.putExtra(Constants.RESTAURANTS, input);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == NEW_RESTAURANT_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                String restaurantJsonString = data.getStringExtra(Constants.RESTAURANT);
                LogUtils.log(restaurantJsonString);
                JSONObject restaurantJsonObject = stringToJSON(restaurantJsonString);
                Restaurant restaurant = new Restaurant(restaurantJsonObject);
                restaurants.add(restaurant);

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    @Nullable
    private JSONObject stringToJSON(String s) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(s);
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
