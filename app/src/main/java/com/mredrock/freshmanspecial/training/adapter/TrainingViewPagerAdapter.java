package com.mredrock.freshmanspecial.training.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.fragment.SexRadioFragment;
import com.mredrock.freshmanspecial.training.fragment.TrainingScenseFragment;
import com.mredrock.freshmanspecial.training.fragment.TrainingSuggestionFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] titleList ;

    private List<Fragment> dataFragmentList;

    public static final String TAG = "TrainingViewPagerAdapte";

    public TrainingViewPagerAdapter(FragmentManager fm) {
        super(fm);
        dataFragmentList = new ArrayList<>();
        titleList = APP.getContext().getResources().getStringArray(R.array.special_2017_training_title_list);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = findFragmentByPosition(position);
        log("getItem:position="+position);
        if(fragment == null){
            log("getItem == null ");
            fragment = new SexRadioFragment();
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return getTitleList()[position];
    }

    private String[] getTitleList() {
        if (titleList == null) {
            titleList = APP.getContext().getResources().getStringArray(R.array.special_2017_training_title_list);
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

    @NonNull
    private Fragment findFragmentByPosition(int position){
        Fragment findFragment;
        switch (position){
            case 0:
                findFragment = new TrainingSuggestionFragment();
                dataFragmentList.add(findFragment);
                log("position==0");
                return findFragment;
            case 1:
                findFragment = new TrainingScenseFragment();
                dataFragmentList.add(findFragment);
                log("position==0");
                return findFragment;
        }
        return null;
    }

    public void log(String message){
        Log.d(TAG,message);
    }

}

