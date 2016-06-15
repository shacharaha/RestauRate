package com.example.shachar.restaurate.model;

import com.example.shachar.restaurate.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shachar on 6/5/2016.
 */
public class Restaurant {
    private String name;
    private String address;
    private double service;
    private double taste;
    private double organized;
    private double speed;
    private double clean;

    public Restaurant(String name, String address, float service, float taste, float organize, float speed, float clean) {
        this.name = name;
        this.address = address;
        this.service = service;
        this.taste = taste;
        this.organized = organize;
        this.speed = speed;
        this.clean = clean;
    }

    public Restaurant(JSONObject jsonObject) {
        try {
            this.name = jsonObject.getString(J_NAME);
            this.address = jsonObject.getString(J_ADDRESS);
            this.service = jsonObject.getDouble(J_SERVICE);
            this.taste = jsonObject.getDouble(J_TASTE);
            this.organized = jsonObject.getDouble(J_ORGANIZED);
            this.speed = jsonObject.getDouble(J_SPEED);
            this.clean = jsonObject.getDouble(J_CLEAN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Restaurant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getService() {
        return service;
    }

    public void setService(double service) {
        this.service = service;
    }

    public double getTaste() {
        return taste;
    }

    public void setTaste(double taste) {
        this.taste = taste;
    }

    public double getOrganized() {
        return organized;
    }

    public void setOrganized(double organized) {
        this.organized = organized;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getClean() {
        return clean;
    }

    public void setClean(float clean) {
        this.clean = clean;
    }

    private final String J_NAME = "name";
    private final String J_ADDRESS = "address";
    private final String J_SERVICE = "service";
    private final String J_TASTE = "taste";
    private final String J_ORGANIZED = "organized";
    private final String J_SPEED = "speed";
    private final String J_CLEAN = "clean";

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(J_NAME, this.name);
            jsonObject.put(J_ADDRESS, this.address);
            jsonObject.put(J_SERVICE, this.service);
            jsonObject.put(J_TASTE, this.taste);
            jsonObject.put(J_ORGANIZED, this.organized);
            jsonObject.put(J_SPEED, this.speed);
            jsonObject.put(J_CLEAN, this.clean);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    public double getRatingAverage()
    {
        double[] rating = new double[Constants.NUMBER_OF_RATING_BARS];
        rating[0] = this.service;
        rating[1] = this.taste;
        rating[2] = this.organized;
        rating[3] = this.speed;
        rating[4] = this.clean;
        return Utils.getAverage(rating);
    }

    @Override
    public String toString() {
        String itemData = "";
        itemData+= "Name: " + this.name + "\n";
        itemData+= "Address: " + this.address + "\n";
        itemData+= "average rating: " + this.getRatingAverage() + "\n";
        itemData+= "Service rating: " + this.service + "\n";
        itemData+= "Taste rating: " + this.taste + "\n";
        itemData+= "Organized rating: " + this.organized + "\n";
        itemData+= "Speed rating: " + this.speed + "\n";
        itemData+= "Clean rating: " + this.clean;

        return itemData;
    }
}
