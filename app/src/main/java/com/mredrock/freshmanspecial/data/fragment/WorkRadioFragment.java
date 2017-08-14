package com.mredrock.freshmanspecial.data.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.http.HttpReUtils;
import com.mredrock.freshmanspecial.data.http.HttpUtils;
import com.mredrock.freshmanspecial.data.widget.PickerStatusView;
import com.mredrock.freshmanspecial.strategy.widget.AcrView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.OptionPicker;

/**
 * Created by Grantsome on 2017/8/9.
 */

public class WorkRadioFragment extends Fragment {

    @Bind (R.id.work_radio_view)
    AcrView mWorkView;

    @Bind(R.id.not_work_radio_view)
    AcrView mNotWorkView;

    @Bind(R.id.picker_view_text_college)
    PickerStatusView mPickerView;

    private List<String> pickerList;

    private List<Float> workRatioList;

    private List<Float> unWorkRatioList;

    @OnClick (R.id.picker_view_text_college)
    public void onClickPicker(){
        setPicker();
    }

    public WorkRadioFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pickerList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_work_radio, container, false);
        ButterKnife.bind(this,view);
        mWorkView.bringToFront();
        mNotWorkView.bringToFront();
        initData();
        return view;
    }

    private void initData(){
        pickerList = new ArrayList<>();
        pickerList = HttpUtils.getmCollegeList();
        workRatioList = HttpReUtils.getWorkRatioList();
        unWorkRatioList = HttpReUtils.getUnWorkCourseList();
    }

    private void setPicker(){
        OptionPicker picker = new OptionPicker(getActivity(),pickerList);
        picker.setOffset(2);
        picker.setSelectedIndex(1);
        picker.setTextSize(15);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                mPickerView.setText(item);
                mWorkView.setPercent(workRatioList.get(index)*100);
                mNotWorkView.setPercent(unWorkRatioList.get(index)*100);
                Log.d("SexRadio", "onOptionPicked: 完成");
            }
        });
        picker.show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}

