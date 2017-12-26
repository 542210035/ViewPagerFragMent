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

public class FragMent_Three extends Fragment {
    private TextView title_item_three;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_three,null);
        title_item_three= (TextView) view.findViewById(R.id.title_item_three).findViewById(R.id.tv_title);
        title_item_three.setText("通讯录");

        return view;
    }
}
