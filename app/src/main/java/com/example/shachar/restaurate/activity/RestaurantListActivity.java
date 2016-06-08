package com.example.shachar.restaurate.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.shachar.restaurate.Constants;
import com.example.shachar.restaurate.LogUtils;
import com.example.shachar.resturate.R;

public class RestaurantListActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        adapter = new ArrayAdapter(this, R.layout.list_item, mobileArray);
        listView = (ListView)findViewById(R.id.lv_restaurant_list);
        listView.setAdapter(adapter);
        Intent intent = getIntent();
        LogUtils.log(intent.getStringExtra(Constants.RESTAURANTS));
    }
}
