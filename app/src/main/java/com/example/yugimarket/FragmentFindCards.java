package com.example.yugimarket;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentFindCards extends Fragment {


    private static final String TEXT = "text";

    public static FragmentFindCards newInstance(String text) {
        FragmentFindCards frag = new FragmentFindCards();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_find_cards, container, false);

        return layout;
    }
}