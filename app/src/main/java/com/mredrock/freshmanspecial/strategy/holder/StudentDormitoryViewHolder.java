package com.mredrock.freshmanspecial.strategy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/5.
 */

public class StudentDormitoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @Bind(R.id.student_dor_image)
    ImageView mDorImage;

    @Bind(R.id.student_dor_name)
    TextView mDorName;

    @Bind(R.id.student_dor_desc)
    TextView mDorDesc;

    public ImageView getDorImage() {
        return mDorImage;
    }

    public void setDorName(String dorName) {
        mDorName.setText(dorName);
    }

    public void setDorDesc(String dorDesc) {
        mDorDesc.setText(dorDesc);
    }

    private OnRecyclerViewItemClick mItemClick;

    public StudentDormitoryViewHolder(View itemView,OnRecyclerViewItemClick viewItemClick) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mItemClick = viewItemClick;
        mDorImage.setOnClickListener(this);
    }

    public StudentDormitoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mDorImage.setOnClickListener(this);
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
