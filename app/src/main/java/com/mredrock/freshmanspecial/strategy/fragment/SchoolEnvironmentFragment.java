package com.mredrock.freshmanspecial.strategy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.adapter.SchoolEnvironmentRvAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *  Created by Grantsome on 2017/8/3.
 */
public class SchoolEnvironmentFragment extends Fragment {

    @Bind(R.id.recycler_view)
    RecyclerView mSchoolRv;

    private static View mView;

    private String TAG = "SchoolEnvironmentFM";

    private int mIndex;

    private SchoolEnvironmentRvAdapter mRvAdapter;

    private static List<String> mContentList = new ArrayList<>();

    private static List<String> mTitleList = new ArrayList<>();

    private static List<String> mUrlList = new ArrayList<>();

    public SchoolEnvironmentFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setUpSchoolRv(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mSchoolRv.setLayoutManager(layoutManager);
//        mRvAdapter = new SchoolEnvironmentRvAdapter(getActivity(),mContentList,mTitleList,mUrlList);
        mRvAdapter = new SchoolEnvironmentRvAdapter(getActivity());
        mSchoolRv.setAdapter(mRvAdapter);
        if(null == mSchoolRv.getAdapter()){
            mSchoolRv.setAdapter(mRvAdapter);
        }else{
            mRvAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_school_environment, container, false);
        ButterKnife.bind(this,view);
        initData();
        setUpSchoolRv();
        mRvAdapter.notifyDataSetChanged();
        Log.d(TAG, "onCreateView: Adapter已经更新");
        return view;
    }

    private void initData(){
//        if(mUrlList.size() == 0){
////            mContentList = HttpOkUtils.getContentList();
////            mTitleList = HttpOkUtils.getTitleList();
//            mUrlList = HttpOkUtils.getUrlList();
//        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

//    @Override
//    public void onDestroyView() {
//// TODO Auto-generated method stub
//        super.onDestroyView();
//        try {
//            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
//            childFragmentManager.setAccessible(true);
//            childFragmentManager.set(this, null);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private void log(String message){
        Log.d(TAG,message);
    }


}
