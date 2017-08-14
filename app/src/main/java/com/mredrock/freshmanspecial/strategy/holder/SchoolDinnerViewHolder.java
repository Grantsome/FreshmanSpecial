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

public class SchoolDinnerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind (R.id.school_din_image)
    ImageView mDinImage;

    @Bind(R.id.school_din_name)
    TextView mDinName;

    @Bind(R.id.school_din_desc)
    TextView mDinDesc;

    public ImageView getDinImage() {
        return mDinImage;
    }

    public void setDinDesc(String dinDesc) {
        mDinDesc.setText(dinDesc);
    }

    public void setDinName(String dinName) {
        mDinName.setText(dinName);
    }

    private SchoolDinnerViewHolder.OnRecyclerViewItemClick mItemClick;

    public SchoolDinnerViewHolder(View itemView,SchoolDinnerViewHolder.OnRecyclerViewItemClick viewItemClick) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mItemClick = viewItemClick;
        mDinImage.setOnClickListener(this);
    }

    public SchoolDinnerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
        mDinImage.setOnClickListener(this);
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
