package com.hjo.wingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Suncere on 2016/12/2.
 */

public class OtherFragment extends Fragment {

    public static String NAME = "NAME";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = View.inflate(getContext(), R.layout.fragment_other, null);
        return v;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    TextView textView = (TextView) view.findViewById(R.id.text);
    textView.setText(getArguments().getString(NAME));
    }

    public static OtherFragment newInstance(String text) {
        Bundle args = new Bundle();
        args.putString(NAME, text);
        OtherFragment fragment = new OtherFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
