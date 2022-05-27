package com.example.yugimarket;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewOfferAdapter extends RecyclerView.Adapter<OfferViewHolder>{

   private List<OfferData> allTheOffers;
   private Activity activity;

    public RecyclerViewOfferAdapter(List<OfferData>allTheOffers,Activity activity){
        this.allTheOffers=allTheOffers;
        this.activity=activity;

    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_offer_view_holder,parent,false);
        RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        OfferData dataPosition=allTheOffers.get(position);
        holder.showData(dataPosition,activity);
    }

    @Override
    public int getItemCount() {
        return allTheOffers.size();
    }
}


