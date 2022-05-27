package com.example.yugimarket;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpecificUploadActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextCode;
    private JsonArrayRequest jsonArrayRequest;
    String name,set_code,image_url_small;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_upload);
        editTextName = (EditText) findViewById(R.id.name);
        editTextCode = (EditText) findViewById(R.id.setCode);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            name = (String) bundle.get("name");
             set_code = (String) bundle.get("set_code");
            image_url_small=(String) bundle.get("image_url_small");
            editTextName.setText(name);

            editTextCode.setText(set_code);

        }


        final Button button=findViewById(R.id.upload_button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String sseller,sprice,snumber_to_sell;
                Double dprice ;
                Integer inumber_to_sell;

                EditText price=findViewById(R.id.price);
                sprice=price.getText().toString();
                    try {
                        dprice = Double.parseDouble(sprice);

                    } catch (NumberFormatException nfenpe) {
                        Toast.makeText(view.getContext(), "You did not enter a number in price", Toast.LENGTH_SHORT).show();
                        dprice = 0.0;



                    }
                EditText number_to_sell=findViewById(R.id.number_to_sell);
                snumber_to_sell=number_to_sell.getText().toString();
                    try {
                        inumber_to_sell = Integer.parseInt(snumber_to_sell);
                    }catch (NumberFormatException nfe){
                        Toast.makeText(view.getContext(),"You did not enter a number in number_to_sell",Toast.LENGTH_SHORT).show();
                        inumber_to_sell=0;
                    }

                EditText seller=findViewById(R.id.seller);
                sseller=seller.getText().toString();
                if(sseller.matches("")){
                    Toast.makeText(view.getContext(),"You did not enter a seller",Toast.LENGTH_SHORT).show();

                }
                if (dprice!=0.0 && inumber_to_sell!=0 && sseller!="") {


                    UploadCards(view ,name, set_code ,dprice,inumber_to_sell,sseller);



                }


            }
        });
    }
    private void UploadCards(View view,String name,String set_code,Double fprice,int inumber_to_sell,String sseller){

        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Card_id", set_code);
            jsonObject.put("Card_name", name);
            jsonObject.put("price", fprice);
            jsonObject.put("number_to_sell", inumber_to_sell);
            jsonObject.put("seller", sseller);
            jsonObject.put("card_image", image_url_small);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url="https://624ad3a4852fe6ebf88bbd03.mockapi.io/offers";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,jsonObject,
                new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(view.getContext(), "uploading data",Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(view.getContext(),FragmentUploadCards.class);
                startActivity(intent);
            }
        },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(view.getContext(),"could failed the uploading data"+error.toString(),Toast.LENGTH_SHORT).show();
                Log.d("Error: ",error.toString());

            }

    });




        queue.add(jsonObjectRequest);
    }


    public void onClick(View view) {
    }


}

