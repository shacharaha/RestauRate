package com.example.shachar.restaurate.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.shachar.restaurate.model.Restaurant;
import com.example.shachar.resturate.R;

public class NewRestaurantActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etAddress;
    private RatingBar rbService;
    private RatingBar rbTaste;
    private RatingBar rbOrganized;
    private RatingBar rbSpeed;
    private RatingBar rbClean;

    private Button btnFinish;

    private Restaurant restaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_restaurant);
        etName = (EditText)findViewById(R.id.et_restaurant_name);
        etAddress = (EditText)findViewById(R.id.et_restaurant_address);
        rbService = (RatingBar)findViewById(R.id.rb_service);
        rbTaste = (RatingBar)findViewById(R.id.rb_taste);
        rbOrganized = (RatingBar)findViewById(R.id.rb_organized);
        rbSpeed = (RatingBar)findViewById(R.id.rb_speed);
        rbClean = (RatingBar)findViewById(R.id.rb_clean);
        restaurant = new Restaurant();
        rbService.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                restaurant.setService(rating);
            }
        });
        rbTaste.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                restaurant.setTaste(rating);
            }
        });
        rbOrganized.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                restaurant.setOrganized(rating);
            }
        });
        rbSpeed.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                restaurant.setSpeed(rating);
            }
        });
        rbClean.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                restaurant.setClean(rating);
            }

        });

        btnFinish = (Button)findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!isStringEmpty(etName.getText().toString()))
                    if(!isStringEmpty(etAddress.getText().toString()))
                    {
                        restaurant.setName(etName.getText().toString());
                        restaurant.setAddress(etAddress.getText().toString());

                        Intent intent = new Intent();
                        intent.putExtra("restaurant", restaurant.toJSON().toString());
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                }
            }
        });
    }
    private boolean isStringEmpty(String s){
        return s == null || s.isEmpty();
    }
}
