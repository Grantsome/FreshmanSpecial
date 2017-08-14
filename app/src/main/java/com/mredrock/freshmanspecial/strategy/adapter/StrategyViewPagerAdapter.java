package com.mredrock.freshmanspecial.strategy.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.fragment.DailyLifeFragment;
import com.mredrock.freshmanspecial.strategy.fragment.GoodFoodFragment;
import com.mredrock.freshmanspecial.strategy.fragment.QQGroupFragment;
import com.mredrock.freshmanspecial.strategy.fragment.ScenceFragment;
import com.mredrock.freshmanspecial.strategy.fragment.SchoolDinnerFragment;
import com.mredrock.freshmanspecial.strategy.fragment.SchoolEnterNeedKnowFragment;
import com.mredrock.freshmanspecial.strategy.fragment.SchoolEnvironmentFragment;
import com.mredrock.freshmanspecial.strategy.fragment.StudentDormitoryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grantsome on 2017/8/3.
 */

public class StrategyViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] titleList ;

    private List<Fragment> strategyFragmentList;

    private Fragment mCurrentFragment;

    public static final String TAG = "StrategyViewPageAdapter";

    public StrategyViewPagerAdapter(FragmentManager fm) {
        super(fm);
        strategyFragmentList = new ArrayList<>();
        titleList = APP.getContext().getResources().getStringArray(R.array.special_2017_strategy_title_list);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = findFragmentByPosition(position);
        log("getItem:position="+position);
        if(fragment == null){
            log("getItem == null ");
            fragment = new SchoolEnvironmentFragment();
        }
        mCurrentFragment = fragment;
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getTitleList()[position];
    }

    private String[] getTitleList() {
        if (titleList == null) {
            titleList = APP.getContext().getResources().getStringArray(R.array.special_2017_strategy_title_list);
        }
        return titleList;
    }

    @Override
    public int getCount() {
        return titleList.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment) object).getView() == view;
    }

    public Fragment getCurrentFragment(){
        return mCurrentFragment;
    }

    @NonNull
    private Fragment findFragmentByPosition(int position){
        Fragment findFragment;
        switch (position){
            case 0:
                findFragment = new SchoolEnvironmentFragment();
                strategyFragmentList.add(findFragment);
                log("position==0");
                return findFragment;
            case 1:
                findFragment =  new StudentDormitoryFragment();
                strategyFragmentList.add(findFragment);
                log("position==1");
                return findFragment;
            case 2:
                findFragment =  new SchoolDinnerFragment();
                strategyFragmentList.add(findFragment);
                log("position==2");
                return findFragment;
            case 3:
                findFragment = new SchoolEnterNeedKnowFragment();
                strategyFragmentList.add(findFragment);
                log("position==3");
                return findFragment;
            case 4:
                findFragment = new QQGroupFragment();
                strategyFragmentList.add(findFragment);
                log("position==4");
                return findFragment;
            case 5:
                findFragment = new DailyLifeFragment();
                strategyFragmentList.add(findFragment);
                log("position==5");
                return findFragment;
            case 6:
                findFragment = new GoodFoodFragment();
                strategyFragmentList.add(findFragment);
                log("position==6");
                return findFragment;
            case 7:
                findFragment = new ScenceFragment();
                strategyFragmentList.add(findFragment);
                log("position==7");
                return findFragment;
        }
        return null;
    }

    public void log(String message){
        Log.d(TAG,message);
    }
}
