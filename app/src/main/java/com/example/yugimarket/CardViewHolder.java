package com.example.yugimarket;

import androidx.annotation.NonNull;

import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardViewHolder extends RecyclerView.ViewHolder {
    private final TextView textCard;
    private final View principal;


    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        textCard = (TextView) itemView.findViewById(R.id.nameCard);
        principal = (View) itemView.findViewById(R.id.principal);
    }

    public void showData(@NonNull CardData data, Activity activity) {
        textCard.setText(data.getName());



        principal.setOnClickListener(new View.OnClickListener() {

            String item="Doesn't have set code";
            @Override
            public void onClick(View view) {
                CharSequence[] items=data.getSet_code().toArray(new CharSequence[data.getSet_code().size()]);
                if (items.length>0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle("Pick a card id");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(activity, SpecificUploadActivity.class);
                            intent.putExtra("name", String.valueOf(data.getName()));
                            intent.putExtra("set_code", items[which]);
                            intent.putExtra("image_url_small", String.valueOf(data.getImage_url_small()));
                            activity.startActivity(intent);
                        }

                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else {

                    Intent intent = new Intent(activity, SpecificUploadActivity.class);
                    intent.putExtra("name", String.valueOf(data.getName()));
                    intent.putExtra("set_code",String.valueOf(item));
                    intent.putExtra("image_url_small", String.valueOf(data.getImage_url_small()));
                    activity.startActivity(intent);
                }

            }
        });

    }


}


