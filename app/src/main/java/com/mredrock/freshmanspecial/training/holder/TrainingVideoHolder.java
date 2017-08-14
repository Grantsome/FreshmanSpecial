package com.mredrock.freshmanspecial.training.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingVideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind (R.id.training_video_first)
    ImageView mFirstVideoImage;

    @Bind (R.id.training_video_second)
    ImageView mSecondVideoImage;

    @Bind(R.id.play_video_first)
    ImageView mPlayFirst;

    @Bind(R.id.play_video_second)
    ImageView mPlaySecond;

    private TrainingVideoHolder.OnRecyclerViewItemClick mRvItemClick;

    public TrainingVideoHolder(View itemView,TrainingVideoHolder.OnRecyclerViewItemClick rvItemClick) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mRvItemClick = rvItemClick;
        itemView.setOnClickListener(this);
        mPlayFirst.setOnClickListener(this);
        mPlaySecond.setOnClickListener(this);
    }

    public ImageView getFirstVideoImage() {
        return mFirstVideoImage;
    }

    public ImageView getSecondVideoImage() {
        return mSecondVideoImage;
    }

    public void update() {
        //到时候这样写即可，其他同理
        //mBuildDecription.setText();
    }

    public interface OnRecyclerViewItemClick{
        void onItemClick(View view);
    }

    @Override
    public void onClick(View v) {
        if(mRvItemClick!=null){
            mRvItemClick.onItemClick(v);
        }
    }

}




