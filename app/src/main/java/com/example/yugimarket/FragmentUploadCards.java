package com.example.yugimarket;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.yugimarket.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentUploadCards extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener {
  private RecyclerView recyclerView;
  ProgressDialog progress;
  RequestQueue queue;
  JsonObjectRequest jsonObjectRequest;

  private EditText editText;

  public FragmentUploadCards(){

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_upload_cards, container, false);

    recyclerView = view.findViewById(R.id.recycler_view);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    queue = Volley.newRequestQueue(getContext());

    editText = view.findViewById(R.id.search);
    editText.setOnKeyListener(new View.OnKeyListener() {

      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
          String text = editText.getText().toString();
          loadData(text);
          return true;

        }
        return false;

      }
    });

    return view;

  }

  private void loadData(String text) {
    progress=new ProgressDialog(getContext());
    progress.setMessage("Consulting data...");
    progress.show();
    String url="https://db.ygoprodeck.com/api/v7/cardinfo.php?fname="+text;
    jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
    queue.add(jsonObjectRequest);
  }


  @Override
  public void onErrorResponse(VolleyError error) {
    Toast.makeText(getContext(),"The name of card not exist"+error.toString(),Toast.LENGTH_SHORT).show();
    System.out.println();
    progress.hide();
    Log.d("Error: ",error.toString());

  }



  @Override
  public void onResponse(JSONObject response) {
    List<CardData> allTheCards = new ArrayList<CardData>();
    try {
      JSONArray jsonArray= response.getJSONArray("data");
      for (int i = 0; i < jsonArray.length(); i++) {

        JSONObject cards = jsonArray.getJSONObject(i);
        CardData data = new CardData(cards);
        allTheCards.add(data);

      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    RecyclerViewCardAdapter adapter=new RecyclerViewCardAdapter(allTheCards);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }
  }
