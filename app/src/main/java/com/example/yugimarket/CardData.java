package com.example.yugimarket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

public class CardData {
    private String name;
    private ArrayList<String> set_code = new ArrayList<>();
    private String image_url_small;

    public CardData(JSONObject json) {
        try {
            this.name = json.getString("name");
            JSONArray jsonArray = json.getJSONArray("card_sets");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                this.set_code.add(jsonObject.getString("set_code"));

            }
            JSONArray jsonArray1 =json.getJSONArray("card_images");
            JSONObject jsonObject1=jsonArray1.getJSONObject(0);
            this.image_url_small=jsonObject1.getString("image_url_small");


        } catch (JSONException error) {
            error.printStackTrace();
        }
    }


    public String getName() {
        return name;
    }


    public ArrayList<String> getSet_code() {
        return set_code;

    }
    public String getImage_url_small(){
        return image_url_small;
    }

}