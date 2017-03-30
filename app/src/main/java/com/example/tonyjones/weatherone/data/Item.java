package com.example.tonyjones.weatherone.data;

import org.json.JSONObject;

/**
 * Created by tonyjones on 3/7/17.
 */

public class Item implements JSONPopulator {
    private Condition condition;
    @Override
    public void populate(JSONObject data) {

        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
