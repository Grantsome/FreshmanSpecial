package com.mredrock.freshmanspecial.strategy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class DailyLifeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind (R.id.daily_life_image)
    ImageView mDailyImage;

    @Bind (R.id.daily_life_name)
    TextView mDailyName;

    @Bind (R.id.daily_life_loc)
    TextView mDailyLoc;

    @Bind(R.id.daily_life_desc)
    TextView mDailyDesc;

    public ImageView getDailyImage() {
        return mDailyImage;
    }

    public void setDailyName(String dailyName) {
        mDailyName.setText(dailyName);
    }

    public void setDailyLoc(String dailyLoc) {
        mDailyLoc.setText(dailyLoc);
    }

    public void setDailyDesc(String dailyDesc) {
        mDailyDesc.setText(dailyDesc);
    }

    private OnRecyclerViewItemClick mItemClick;

    public DailyLifeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        mDailyImage.setOnClickListener(this);
    }

    public void setItemClick(OnRecyclerViewItemClick itemClick) {
        mItemClick = itemClick;
    }

    @Override
    public void onClick(View v) {
        if(mItemClick!=null){
            mItemClick.onItemClick(v);
        }
    }

    public interface OnRecyclerViewItemClick{
        void onItemClick(View view);
    }

    public void update(){
        //到时候这样写即可，其他同理
        //mBuildDecription.setText();
    }
}