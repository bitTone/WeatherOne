package com.example.tonyjones.weatherone.data;

import org.json.JSONObject;

/**
 * Created by tonyjones on 3/7/17.
 */

/**
 *
 * Parsing the JSON Object data in the JSON object node "channel"
 *
 */
public class Channel implements JSONPopulator {

    private int code;
    private int temperature;
    private String description;

    public String getDescription() {
        return description;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getCode() {
        return code;
    }

    @Override
    public void populate(JSONObject data) {
        code= data.optInt("code");
        temperature = data.optInt("temp");
        description = data.optString("text");
    }
}
