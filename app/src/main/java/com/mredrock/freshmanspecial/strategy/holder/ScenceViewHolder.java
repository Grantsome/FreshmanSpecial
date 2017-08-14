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

public class ScenceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind (R.id.scence_image)
    ImageView mScenceImage;

    @Bind (R.id.scence_name)
    TextView mScenceName;

    @Bind (R.id.scence_loc)
    TextView mScenceLoc;

    @Bind(R.id.scence_desc)
    TextView mScenceDesc;

    private GoodFoodViewHolder.OnRecyclerViewItemClick mItemClick;

    public void setItemClick(GoodFoodViewHolder.OnRecyclerViewItemClick itemClick) {
        mItemClick = itemClick;
    }

    public ImageView getScenceImage() {
        return mScenceImage;
    }

    public void setScenceDesc(String scenceDesc) {
        mScenceDesc.setText(scenceDesc);
    }

    public void setScenceLoc(String scenceLoc) {
        mScenceLoc.setText(scenceLoc);
    }

    public void setScenceName(String scenceName) {
        mScenceName.setText(scenceName);
    }

    public ScenceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
        mScenceImage.setOnClickListener(this);
    }

    public void update() {
        //到时候这样写即可，其他同理
        //mBuildDecription.setText();
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

}
