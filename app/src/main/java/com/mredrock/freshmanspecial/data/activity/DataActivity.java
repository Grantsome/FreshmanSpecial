package com.mredrock.freshmanspecial.data.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.data.adapter.DataViewPagerAdapter;
import com.mredrock.freshmanspecial.strategy.utils.StatusUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataActivity extends AppCompatActivity {

    @Bind (R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.tab_layout)
    TabLayout mTabLayout;

    @Bind(R.id.toolbar_iv_left)
    ImageView mImageView;

    @Bind(R.id.spilt_line)
    View mSpiltLine;

    private DataViewPagerAdapter mAdapter;

    @OnClick (R.id.toolbar_iv_left)
    public void ClickOnToolbarIvLeft(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_data);
        ButterKnife.bind(this);
        StatusUtils.changeStatus(this);
        initData();
    }

    private void initData(){
        mAdapter = new DataViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager,true);
    }
}
