package com.example.yugimarket;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    private final TextView textCard;





    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        textCard = (TextView) itemView.findViewById(R.id.nameCard);


    }

    public void showData(@NonNull CardData data) {
        textCard.setText(data.getName());

    }
}