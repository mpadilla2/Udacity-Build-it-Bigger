package com.udacity.jokedemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

public class JokesterActivityFragment extends Fragment {


    public JokesterActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jokester_activity, container, false);
        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        String joke = intent.getStringExtra(JokesterActivity.JOKE_KEY);
        TextView jokeTV = view.findViewById(R.id.joke_textview);
        if (joke != null && joke.length() != 0){
            jokeTV.setText(joke);
        }
        return view;
    }
}
