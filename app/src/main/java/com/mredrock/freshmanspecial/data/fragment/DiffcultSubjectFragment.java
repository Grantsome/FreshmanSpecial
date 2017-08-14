package com.mredrock.freshmanspecial.data.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.http.HttpOkUtils;
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

public class DiffcultSubjectFragment extends Fragment {

    @Bind (R.id.diffcult_arc)
    AcrView mDiffcultView;

    @Bind(R.id.just_arc)
    AcrView mJustView;

    @Bind(R.id.easy_arc)
    AcrView mEasyView;

    @Bind(R.id.picker_view_text_college)
    PickerStatusView mPickerCollegeView;

    @Bind(R.id.picker_view_text_major)
    PickerStatusView mPickerMajorView;

    @Bind(R.id.diff_text)
    TextView mDiffText;

    @Bind(R.id.just_text)
    TextView mJustText;

    @Bind(R.id.easy_text)
    TextView mEasyText;

    private List<String> pickerList;

    private List<String> majorList;

    private List<Float> mRatioList;

    private List<String> mCourseList;

    private boolean isChoosedCollege = false;

    private static Toast toast;

    private String college;

    private String major;

    @OnClick(R.id.picker_view_text_college)
    public void onClickCollege(){
        setCollegePicker();
    }

    @OnClick(R.id.picker_view_text_major)
    public void onClickMajor(){
       setMajorPicker();
    }

    public DiffcultSubjectFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pickerList = new ArrayList<>();
        majorList = new ArrayList<>();
        mRatioList = new ArrayList<>();
        mCourseList = new ArrayList<>();
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_diffcult_subject, container, false);
        ButterKnife.bind(this,view);
        mEasyView.bringToFront();
        mJustView.bringToFront();
        mDiffcultView.bringToFront();
        return view;
    }

    private void initData(){
        if(pickerList == null){
            pickerList = new ArrayList<>();
        }
        pickerList.clear();
        pickerList = HttpOkUtils.getCollegeList();
    }

    private void setCollegePicker(){
        if(null == pickerList){
            initData();
        }
        if(null != pickerList){
            for(int i = 0; i < pickerList.size(); i++){
                if(pickerList.contains("全校")){
                    pickerList.remove("全校");
                    i--;
                }
            }
        }
        OptionPicker picker = new OptionPicker(getActivity(),pickerList);
        picker.setOffset(2);
        picker.setSelectedIndex(1);
        picker.setTextSize(15);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                mPickerCollegeView.setText(item);
                college = item;
                if(item == "全校"){
                    toast("没有全校的最难科目哦，请重新选择");
                    return;
                }
                initMajor(item);
                mPickerMajorView.setText("请选择专业");
                major = null;
                majorList = HttpOkUtils.getMajorList(item);
                isChoosedCollege = true;
            }
        });
        picker.show();
    }

    private void initMajor(String item){
       if(null == majorList){
            majorList = new ArrayList<>();
       }
       majorList.clear();
       majorList = HttpOkUtils.getMajorList(item);
    }

    private void setMajorPicker(){
        if(isChoosedCollege==false||majorList == null){
            if(college!=null){
                initMajor(college);
            }
        }
        if(isChoosedCollege==false||majorList == null){
            if(college ==null){
                toast("您还没有选择学院，不能选择专业哦");
            }
            return;
        }
        if(majorList == null){
            initMajor(college);
        }
        OptionPicker picker = new OptionPicker(getActivity(),majorList);
        picker.setOffset(2);
        picker.setSelectedIndex(1);
        picker.setTextSize(15);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(int index, String item) {
                mPickerMajorView.setText(item);
                major = item;
                init();
                if(null == mRatioList || null == mCourseList){
                    init();
                }
                if(null == mRatioList || null == mCourseList){
                    toast("什么情况？没有数据");
                    return;
                }
                float first = (float) (Math.round(mRatioList.get(0)*100))/100;
                mDiffcultView.setPercent(first * 100);
                float second = (float) (Math.round(mRatioList.get(1)*100))/100;
                mJustView.setPercent(second * 100);
                float third = (float) (Math.round(mRatioList.get(2)*100))/100;
                mEasyView.setPercent(third * 100);
                mDiffText.setText(mCourseList.get(0));
                mJustText.setText(mCourseList.get(1));
                mEasyText.setText(mCourseList.get(2));
            }
        });
        picker.show();
    }

    private void init(){
        if(mCourseList == null){
            mCourseList = new ArrayList<>();
        }
        if(mRatioList == null){
            mRatioList = new ArrayList<>();
        }
        mRatioList.clear();
        mCourseList.clear();
        mRatioList = HttpOkUtils.getRatioList(college,major);
        mCourseList = HttpOkUtils.getCourseList(college,major);
    }

    //为避免重复的toast带来的不友好体验
    public void toast(String content) {
        if (toast == null) {
            toast = Toast.makeText(getContext(),
                    content,Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
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




