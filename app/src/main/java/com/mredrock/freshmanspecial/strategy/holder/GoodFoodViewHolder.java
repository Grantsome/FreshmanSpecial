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

public class GoodFoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind (R.id.good_food_image)
    ImageView mFoodImage;

    @Bind (R.id.good_food_name)
    TextView mFoodName;

    @Bind (R.id.good_food_loc)
    TextView mFoodLoc;

    @Bind(R.id.good_food_desc)
    TextView mFoodDesc;

    public ImageView getFoodImage() {
        return mFoodImage;
    }

    public void setFoodDesc(String foodDesc) {
        mFoodDesc.setText(foodDesc);
    }

    public void setFoodLoc(String foodLoc) {
        mFoodLoc.setText(foodLoc);
    }

    public void setFoodName(String foodName) {
        mFoodName.setText(foodName);
    }

    private OnRecyclerViewItemClick mItemClick;

    public void setItemClick(OnRecyclerViewItemClick itemClick) {
        mItemClick = itemClick;
    }

    public GoodFoodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        itemView.setOnClickListener(this);
        mFoodImage.setOnClickListener(this);
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
