package com.example.sfhan.fragmentdemo;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{
    /**
     * ViewPager
     */
    private ViewPager mViewPager;
    /**
     * ViewPager的适配器
     */
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mViews;
    private LayoutInflater mInflater;
    private ImageButton btnima0,btnima1,btnima2,btnima3;
    private int currentIndex;

    /**
     * 底部四个按钮
     */
    private LinearLayout mTabBtnWeixin;
    private LinearLayout mTabBtnFrd;
    private LinearLayout mTabBtnAddress;
    private LinearLayout mTabBtnSettings;

    FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInflater=LayoutInflater.from(this);
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        //去掉ViewPager两边滑到底出现蓝色拉升
        mViewPager.setOverScrollMode(mViewPager.OVER_SCROLL_NEVER);
        /**
         * 初始化View
         */
        initView();
        mViewPager.setAdapter(mAdapter);
     /*
      *监听ViewPage的状态
      */
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                resetTabBtn();
                switch (position){
                    case 0:
                        btnima0.setImageResource(R.drawable.csc);
                        break;
                    case 1:
                        btnima1.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
//                    留一个参考写法
//                        ((ImageButton)mTabBtnAddress.findViewById(R.id.btn_tab_bottom_contact))
//                                .setImageResource(R.drawable.tab_address_pressed);
                        btnima2.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        btnima3.setImageResource(R.drawable.fvfvf);
                        break;
                }
                currentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void resetTabBtn(){
        btnima0.setImageResource(R.drawable.dd);
        btnima1  .setImageResource(R.drawable.tab_find_frd_normal);
        btnima2.setImageResource(R.drawable.tab_address_normal);
        btnima3.setImageResource(R.drawable.ss);
    }

    private void initView() {
        btnima0 = (ImageButton) findViewById(R.id.btn_tab_bottom_weixin);
        btnima1 = (ImageButton) findViewById(R.id.btn_tab_bottom_friend);
        btnima2 = (ImageButton) findViewById(R.id.btn_tab_bottom_contact);
        btnima3 = (ImageButton) findViewById(R.id.btn_tab_bottom_setting);


        mTabBtnWeixin = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        mTabBtnFrd = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        mTabBtnAddress = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        mTabBtnSettings = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);

        mTabBtnWeixin.setOnClickListener(this);
        mTabBtnFrd.setOnClickListener(this);
        mTabBtnAddress.setOnClickListener(this);
        mTabBtnSettings.setOnClickListener(this);

        mViews = new ArrayList<Fragment>();
        mViews.add(new FragMent_one());
        mViews.add(new FragMent_two());
        mViews.add(new FragMent_Three());
        mViews.add(new FragMent_four());

        fm=getSupportFragmentManager();

//Adapder
        mAdapter = new FragmentPagerAdapter(fm) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return mViews.get(position);
            }

            @Override
            public int getCount() {
                return mViews.size();
            }
        };
    }

//监听点击的那个按钮
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_tab_bottom_weixin:
                //第二个参数false可以去掉跳转时的动画10个以内有效
                mViewPager.setCurrentItem(0,false);
                break;
            case R.id.id_tab_bottom_friend:
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.id_tab_bottom_contact:
                mViewPager.setCurrentItem(2,false);
                break;
            case R.id.id_tab_bottom_setting:
                mViewPager.setCurrentItem(3,false);
                break;
        }
    }
}
