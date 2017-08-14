package com.mredrock.freshmanspecial.strategy.adapter;

import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.mredrock.freshmanspecial.strategy.fragment.SchoolEnvironmentPictureItemFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grantsome on 2017/8/4.
 */

public class SchoolPictureViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<SchoolEnvironmentPictureItemFragment> mFragmentList;

    private ArrayList<Rect> mRectList;

    private List<String> mResIDList;

    private Rect mRect;

    private String mUrl;

    private String nUrl;

    public SchoolPictureViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
    }

    public SchoolPictureViewPagerAdapter(FragmentManager fm, ArrayList<Rect> rectList,List<String> resIDList) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mRectList = rectList;
        mResIDList = resIDList;
    }

    public SchoolPictureViewPagerAdapter(FragmentManager fm, ArrayList<Rect> rectList,String url) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mRectList = rectList;
        nUrl = url;
    }

    public SchoolPictureViewPagerAdapter(FragmentManager fm,ArrayList<SchoolEnvironmentPictureItemFragment> fragmentList) {
        super(fm);
        mFragmentList = fragmentList;
        Log.d("ViewPager里面的list长度",mFragmentList.size()+"");
    }

    @Override
    public Fragment getItem(int position) {
        mRect = mRectList.get(position);
        try{
            mUrl = mResIDList.get(position);
        }catch (Exception e){
            e.printStackTrace();
            mUrl = nUrl;
        }
        Log.d("ImageDetailActivity", "getItem: 传入Fragment的url"+mUrl);
        return SchoolEnvironmentPictureItemFragment.newInstance(mRect,mUrl,position,mRectList.size());
    }

    @Override
    public int getCount() {
        return mRectList.size();
    }

}
