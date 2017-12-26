package com.example.sfhan.fragmentdemo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sfhan on 2017/12/21.
 */

public class FragMent_two extends Fragment {
    View view;
    private TextView title_item_two;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
           view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_two,null);
           title_item_two= (TextView) view.findViewById(R.id.title_item_two).findViewById(R.id.tv_title);
           title_item_two.setText("朋友");
           return view;
    }
}
