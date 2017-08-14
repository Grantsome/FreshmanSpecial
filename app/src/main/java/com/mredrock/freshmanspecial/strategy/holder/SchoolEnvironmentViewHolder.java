package com.mredrock.freshmanspecial.strategy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/3.
 */

public class SchoolEnvironmentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind(R.id.school_image)
    ImageView mImageView;

    @Bind(R.id.school_build_name)
    TextView mBuildNameText;

    public ImageView getmageView() {
        return mImageView;
    }

    public void setBuildNameText(String buildNameText) {
        mBuildNameText.setText(buildNameText);
    }

    public void setBuildDecription(String buildDecription) {
        mBuildDecription.setText(buildDecription);
    }

    @Bind(R.id.school_build_description)
    TextView mBuildDecription;

    private OnRecyclerViewItemClick mRvItemClick;

    public SchoolEnvironmentViewHolder(View itemView,OnRecyclerViewItemClick onRecyclerViewItemClick) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mRvItemClick = onRecyclerViewItemClick;
        itemView.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    public SchoolEnvironmentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    public void setRvItemClick(OnRecyclerViewItemClick rvItemClick) {
        mRvItemClick = rvItemClick;
    }

    public void update(){
        //到时候这样写即可，其他同理
        //mBuildDecription.setText();
    }

    @Override
    public void onClick(View v) {
        if(mRvItemClick!=null){
            mRvItemClick.onItemClick(v);
        }
    }

    public static int getIndex(){
        return new SchoolEnvironmentViewHolder(new TextView(APP.getContext())).getLayoutPosition();
    }

    public interface OnRecyclerViewItemClick{
        void onItemClick(View view);
    }
}
