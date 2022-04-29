package com.example.yugimarket;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewCardAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<CardData> allTheData;
    private Activity activity;

    public RecyclerViewCardAdapter(List<CardData>allTheData,Activity activity){
        this.allTheData=allTheData;
        this.activity=activity;
    }
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_holder,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
      //  holder.showData();
    }

    @Override
    public int getItemCount() {
       return allTheData.size();
    }
}