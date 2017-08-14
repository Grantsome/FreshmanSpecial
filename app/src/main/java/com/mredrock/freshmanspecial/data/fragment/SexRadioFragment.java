package com.mredrock.freshmanspecial.data.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.http.HttpUtils;
import com.mredrock.freshmanspecial.data.widget.PickerStatusView;
import com.mredrock.freshmanspecial.strategy.widget.AcrView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.OptionPicker;

/**
 * Created by Grantsome on 2017/8/9.
 */

public class SexRadioFragment extends Fragment {

    @Bind(R.id.girl_radio_view)
    AcrView mGirlView;

    @Bind(R.id.boy_radio_view)
    AcrView mBoyView;

    @Bind(R.id.picker_view_text_college)
    PickerStatusView mPickerView;

    private List<String> mCollegePList;

    private List<Float> mMenRatioFloatList;

    private List<Float> mWomenRatioFloatList;

    @OnClick(R.id.picker_view_text_college)
    public void onClickPicker(){
        setPicker();
    }

    public  SexRadioFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_sex_radio, container, false);
        ButterKnife.bind(this,view);
        mGirlView.bringToFront();
        mBoyView.bringToFront();
        initData();
        return view;
    }


    private void initData(){
        mCollegePList = HttpUtils.getmCollegeList();
        mMenRatioFloatList = HttpUtils.getmMenRatioFloatList();
        mWomenRatioFloatList = HttpUtils.getmWomenRatioFloatList();
        if(null != mCollegePList && null != mMenRatioFloatList && null != mWomenRatioFloatList){
            Log.d("Fragment", "initData: 非空");
        }
    }

    private void setPicker(){
        if(mCollegePList == null){
            initData();
        }
        if(mCollegePList == null){
            return;
        }
        OptionPicker picker = new OptionPicker(getActivity(),mCollegePList);
        picker.setOffset(2);
        picker.setSelectedIndex(16);
        picker.setTextSize(15);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                mPickerView.setText(item);
                mBoyView.setPercent(mMenRatioFloatList.get(index)*100);
                mGirlView.setPercent(mWomenRatioFloatList.get(index)*100);
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



