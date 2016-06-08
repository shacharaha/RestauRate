package com.example.shachar.restaurate.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shachar on 6/5/2016.
 */
public class Restaurant {
    private String name;
    private String address;
    private float service;
    private float taste;
    private float organized;
    private float speed;
    private float clean;

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
            this.service = (float)jsonObject.get(J_SERVICE);
            this.taste = (float)jsonObject.get(J_TASTE);
            this.organized = (float)jsonObject.get(J_ORGANIZED);
            this.speed = (float)jsonObject.get(J_SPEED);
            this.clean = (float)jsonObject.get(J_CLEAN);
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

    public float getService() {
        return service;
    }

    public void setService(float service) {
        this.service = service;
    }

    public float getTaste() {
        return taste;
    }

    public void setTaste(float taste) {
        this.taste = taste;
    }

    public float getOrganized() {
        return organized;
    }

    public void setOrganized(float organized) {
        this.organized = organized;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getClean() {
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
}
