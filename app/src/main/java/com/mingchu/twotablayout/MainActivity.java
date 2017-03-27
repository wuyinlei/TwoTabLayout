package com.mingchu.twotablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mingchu.twotablayout.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SlidingTabLayout tab_layout;  //tablayout

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private MyPagerAdapter mAdapter;
    private final String[] mTitles = {
            "热门问题", "最新问题",
    };

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPageAdapter();
    }

    private void initView() {
        tab_layout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initPageAdapter() {
        mFragments.add(new TabLayoutFragment());
        mFragments.add(new TabLayoutFragment());
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        tab_layout.setViewPager(viewPager);

        tab_layout.showMsg(0, 8);  //显示的消息  1-9  圆形
        tab_layout.setMsgMargin(0, 0, 10);  //显示的消息的上移动10dp  也就是右上角 默认平等级

        tab_layout.showMsg(1, 11);  //显示的消息  10-99  椭圆形 可以在代码中更改
        tab_layout.setMsgMargin(1, 0, 10);
//        tab_layout.showMsg() ; //设置显示消息
//        tab_layout.setMsgMargin();  //设置显示消息的位置
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
