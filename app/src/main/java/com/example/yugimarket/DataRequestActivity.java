package com.example.yugimarket;


import android.app.Activity;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.data_request_activity);
                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                Activity activity = this;
              JsonArrayRequest request = new JsonArrayRequest(
                    Request.Method.GET,
                    "https://db.ygoprodeck.com/api/v7/cardinfo.php?fname",
                     null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<CardData> allTheCards = new ArrayList<>();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject card = response.getJSONObject(i);
                                CardData cardData = new CardData(card);
                                allTheCards.add(cardData);
                            } catch (JSONException error) {
                                error.printStackTrace();
                            }
                        }
                        RecyclerViewCardAdapter adapter = new RecyclerViewCardAdapter(allTheCards, activity);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("error");
                    }
                });
        RequestQueue cola = Volley.newRequestQueue(this);
        cola.add(request);

    }
}
