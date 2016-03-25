package com.example.geek.ziqiangmission1;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


/**
 * Created by GEEK on 16/3/20.
 */
public class ActionBar_TabSwipenav extends FragmentActivity implements ActionBar.TabListener {
    ViewPager viewPager;
    ActionBar actionBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ActionBar对象
        actionBar = getActionBar();
        //不显示title
        actionBar.setDisplayShowTitleEnabled(false);
        //应用图标变成按钮
        actionBar.setHomeButtonEnabled(true);

        //获取ViewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        //创建一个FragmentPagerAdapter对象，该对象负责为ViewPager提供多个Fragment

        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                Fragment fragment = new NewsFragment();

                Bundle args = new Bundle();

                args.putInt(NewsFragment.number, position + 1);

                fragment.setArguments(args);

                return fragment;
            }

            @Override
            public int getCount() {
                return 6;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "推荐";
                    case 1:
                        return "新闻";
                    case 2:
                        return "通知";
                    case 3:
                        return "招聘";
                    case 4:
                        return "专题";
                    case 5:
                        return "讲座";
                }
                return null;
            }
        };

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(int i = 0; i < pagerAdapter.getCount(); i++) {
            actionBar.addTab(actionBar.newTab().setText(pagerAdapter.getPageTitle(i)).setTabListener(this));
        }

        //为ViewPager组件设置FragmentPagerAdapter
        viewPager.setAdapter(pagerAdapter);
        //为ViewPager组件绑定事件监听器
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            //当ViewPager显示的Fragment发生改变时激发方法@Override
        public void onPageSelected(int postion) {
                actionBar.setSelectedNavigationItem(postion);
            }
        });

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
