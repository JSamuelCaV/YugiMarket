package com.example.yugimarket;

import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OfferData {
    private String Card_name;
    private String Card_id;
    private String card_image;
public OfferData(JSONObject json){
    try{
        if(json.has("Card_id")) {
            this.Card_id = json.getString("Card_id");
        }
        if(json.has("Card_name")) {
            this.Card_name = json.getString("Card_name");
        }
        this.card_image=json.getString("card_image");
    }catch (JSONException error){
        error.printStackTrace();
    }

}

    public String getCard_name() {
        return Card_name;
    }




    public String getCard_id() {
        return Card_id;
    }

    public String getCard_image(){
    return card_image;
    }
}
