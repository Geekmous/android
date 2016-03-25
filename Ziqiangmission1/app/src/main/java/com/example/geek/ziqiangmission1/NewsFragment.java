package com.example.geek.ziqiangmission1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GEEK on 16/3/20.
 */
public class NewsFragment extends Fragment {
    public final static String number = "number";
    String[] article = {"武大计算机科学首入全球1%，入榜总学科增至14个","’创客空间‘————武大首个创业沙龙", "学在武大"};
    String[] time = {"2016-03-18", "2016-03-19", "2016-03-20"};
    int[] imagine = {R.drawable.a, R.drawable.b, R.drawable.c};
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for(int j = 0; j < 10; j++) {
            for (int i = 0; i < article.length; i++) {
                Map<String, Object> listItem = new HashMap<String, Object>();
                listItem.put("article", article[i]);
                listItem.put("time", time[i]);
                listItem.put("imagine", imagine[i]);
                listItems.add(listItem);
            }
        }


        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity(), listItems, R.layout.news_articles,new String[] {"article", "time", "imagine"}, new int[] {R.id.article, R.id.time, R.id.imagine});
        ListView list = (ListView) inflater.inflate(R.layout.list, container,false);
        list.setAdapter(simpleAdapter);

        return list;
    }
}
