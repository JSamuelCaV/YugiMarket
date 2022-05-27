package com.example.yugimarket;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class OfferViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;
    private final View view;

    public OfferViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
        view = (View) itemView.findViewById(R.id.principal);
    }
    public void showData(@NonNull OfferData offer,Activity activity){
        if (textView.getText().length() == 10 && textView.getText().toString().substring(4) == "-"&& textView!=null) {
            textView.setText(offer.getCard_id());
        } else {
            textView.setText(offer.getCard_name());
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity,SpecificGetterActivity.class);
                if (textView.getText().length() == 10 && textView.getText().toString().substring(4) == "-"&& textView!=null) {
                    intent.putExtra("Card_id",String.valueOf(offer.getCard_id()));

                }else {
                    intent.putExtra("Card_name",String.valueOf(offer.getCard_name()));
                }
                intent.putExtra("card_image",String.valueOf(offer.getCard_image()));
                activity.startActivity(intent);
            }
        });

    }
}