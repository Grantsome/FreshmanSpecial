package com.mredrock.freshmanspecial.strategy.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.adapter.SchoolPictureViewPagerAdapter;
import com.mredrock.freshmanspecial.strategy.utils.StatusUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Grantsome on 2017/8/5.
 */
public class ImageDetailActivity extends AppCompatActivity {

    private ArrayList<Rect> mRectList;

    private ArrayList<String> mUrlList;

    private String mUrl;

    private int mIndex;

    private String desc;

    private SchoolPictureViewPagerAdapter mAdpater;

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(R.id.toolbar_iv_left)
    ImageView mImageView;

    @Bind(R.id.desc)
    TextView mDesc;

    private boolean isList;

    @OnClick(R.id.toolbar_iv_left)
    public void clickOnToolbarIV(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_image_detail);
        ButterKnife.bind(this);
        mRectList = getIntent().getParcelableArrayListExtra("rectList");
        try{
            mUrl = getIntent().getStringExtra("url");
            Log.d("ImageDetailActivity", "onCreate:  得到url");
        }catch (Exception e){
            e.printStackTrace();
        }
        try{
            mUrlList = getIntent().getStringArrayListExtra("urlList");
            Log.d("ImageDetailActivity", "onCreate:  得到urlList");
        }catch (Exception e){
            e.printStackTrace();
        }
        mIndex = getIntent().getIntExtra("index",0);
        Log.d("ImageDetailActivity","start之后的intent里面：rectList"+mRectList.size());
        FragmentManager manager = getSupportFragmentManager();
        if(null != mUrlList){
            mAdpater = new SchoolPictureViewPagerAdapter(manager,mRectList,mUrlList);
            Log.d("ImageDetailActivity", "onCreate:  得到urlList打印第一项"+mUrlList.get(0));
        }
        if(null != mUrl){
            mAdpater = new SchoolPictureViewPagerAdapter(manager,mRectList,mUrl);
            Log.d("ImageDetailActivity", "onCreate:  得到url之后打印"+mUrl);
        }
        mViewPager.setAdapter(mAdpater);
        mViewPager.setCurrentItem(mIndex);
        try{
             desc = getIntent().getStringExtra("desc");
             mDesc.setText(desc);
             mAdpater.notifyDataSetChanged();
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("ImageDetailActivity", "一切正常");
        StatusUtils.changeStatus(this);
    }

}
