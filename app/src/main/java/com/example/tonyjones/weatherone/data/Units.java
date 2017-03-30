package com.example.tonyjones.weatherone.data;

import org.json.JSONObject;

/**
 * Created by tonyjones on 3/7/17.
 */

public class Units implements JSONPopulator {
    private String temperature;

    @Override
    public void populate(JSONObject data) {

        temperature = data.optString("temperature");

    }
}
