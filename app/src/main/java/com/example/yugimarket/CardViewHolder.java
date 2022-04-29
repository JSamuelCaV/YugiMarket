package com.example.yugimarket;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;

import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class CardViewHolder extends RecyclerView.ViewHolder {
    private final TextView textCard;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        textCard = (TextView) itemView.findViewById(R.id.nameCard);
    }

    public void showData(CardData data, Activity activity) {
        textCard.setText(data.getName());
        textCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, FragmentUploadCards.class);
                intent.putExtra("Card name", data.getName());
                activity.startActivity(intent);
            }
        });

    }
}