package com.example.yugimarket;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class FragmentFindCards extends Fragment implements Response.Listener<JSONArray>, Response.ErrorListener {

    private RecyclerView recyclerView;
    RequestQueue queue ;
    JsonArrayRequest jsonArrayRequest;
    EditText editText;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_find_cards,container,false);
    recyclerView=view.findViewById(R.id.recycler_view_offer);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    queue= Volley.newRequestQueue(getContext());
        editText = view.findViewById(R.id.search_offer);
    editText.setOnKeyListener(new View.OnKeyListener(){
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)) {
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
            return false;
        }
    });
    final Button button = view.findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override

        public void onClick(View v) {


            String text=editText.getText().toString();


            loadData(text);
        }
    });


    return view;
    }

    public void loadData(String text){
        String url ="https://624ad3a4852fe6ebf88bbd03.mockapi.io/offers?search="+text;
        jsonArrayRequest=new JsonArrayRequest(Request.Method.GET,url,null,this,this);
        queue.add(jsonArrayRequest);


}

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"could not connect "+error.toString(),Toast.LENGTH_SHORT).show();
        System.out.println();
        Log.d("Error: ",error.toString());
    }



    @Override
    public void onResponse(JSONArray response) {

        List<OfferData> allTheOffers=new ArrayList<OfferData>();

        try{
            for (int i=0;i<response.length();i++){
                JSONObject offers = response.getJSONObject(i);
                OfferData offer = new OfferData(offers);
                allTheOffers.add(offer);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        RecyclerViewOfferAdapter adapter= new RecyclerViewOfferAdapter(allTheOffers,getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));


    }
}