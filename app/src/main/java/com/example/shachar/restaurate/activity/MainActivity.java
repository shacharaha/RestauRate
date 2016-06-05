package com.example.shachar.restaurate.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shachar.resturate.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCreateNewRestaurant = (Button)findViewById(R.id.btn_create_new_restaurant);
        Button btnRestaurantList = (Button)findViewById(R.id.btn_restaurant_list);
        btnCreateNewRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewRestaurantActivity();
            }
        });
        btnRestaurantList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRestaurantListActivity();
            }
        });
    }
    private void startNewRestaurantActivity()
    {
        Intent intent = new Intent(this, NewRestaurantActivity.class);
        startActivity(intent);
    }
    private void startRestaurantListActivity()
    {
        Intent intent = new Intent(this, RestaurantListActivity.class);
        startActivity(intent);
    }
}
