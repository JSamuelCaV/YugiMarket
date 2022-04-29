package com.example.yugimarket;

import org.json.JSONException;
import org.json.JSONObject;

public class CardData {
    private String name;


public CardData(JSONObject json) {
    try {
        this.name = json.getString("name");
    }catch (JSONException error){
        error.printStackTrace();
    }
}

    public String getName() {
        return name;
    }
}