package com.example.yugimarket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

public class CardData {
    private String name;
    private ArrayList<String> set_code = new ArrayList<>();


    public CardData(JSONObject json) {
        try {
            this.name = json.getString("name");
            JSONArray jsonArray= json.getJSONArray("card_sets");
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                this.set_code.add(jsonObject.getString("set_code"));

            }


        }catch (JSONException error){
            error.printStackTrace();
        }
    }


    public String getName() {
        return name;
    }




    public ArrayList<String> getSet_code() {
        return set_code;

    }


}