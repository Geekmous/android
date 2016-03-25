package com.example.geek.ziqiangmission1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by GEEK on 16/3/20.
 */
public class DummyFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";
    // 该方法的返回值就是该Framgment显示的VIew组件
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());

        textView.setGravity(Gravity.START);
        //获取创建该Fragment时传入的参数Bundle
        Bundle args = getArguments();

        textView.setText(args.getInt(ARG_SECTION_NUMBER) + "the is showed by DummyFragment");

        textView.setTextSize(30);

        return textView;
    }
}
