package com.example.sfhan.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.sfhan.fragmentdemo.R.drawable.ss;

/**
 * Created by sfhan on 2017/12/21.
 */

public class FragMent_one  extends Fragment {
    View view;
    private TextView tv_title_one;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_one,null);
        tv_title_one= (TextView) view.findViewById(R.id.tetle_item_one).findViewById(R.id.tv_title);
        tv_title_one.setText("微信");
        return view;
    }
}
