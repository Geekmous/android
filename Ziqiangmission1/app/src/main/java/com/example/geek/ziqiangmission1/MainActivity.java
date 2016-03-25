package com.example.geek.ziqiangmission1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity implements ActionBar.TabListener {
    ActionBar actionBar;
    private static final String SELECTED_ITEM = "selected_item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getActionBar();

        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("推荐").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("新闻").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("通知").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("招聘").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("专题").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("讲座").setTabListener(this));
    }
    @Override

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState.containsKey(SELECTED_ITEM)) {
            //选中前面保存的索引对应的Fragment页
            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        //将当前选中的Fragment页的索引保存到Bundle中
        outState.putInt(SELECTED_ITEM,getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTrasaction) {

    }
    // 当制定Tab被选中时激发该方法
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

        //  创建一个新的Fragment对象
        Fragment fragment = new DummyFragment();
        //创建一个Bundle对象，用于向Fragment传入参数
        Bundle args = new Bundle();

        args.putInt(DummyFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
        //向fragment传入参数
        fragment.setArguments(args);
        //获取FragemntTransaction对象
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //使用fragment代替该Activity中的container组件
        //ft.replace(R.id.container, fragment);
        //提交事务
        ft.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    public void showActionBar(View source) {

        actionBar.show();
    }

    public void hideActionBar(View source) {
        actionBar.hide();
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }
}
