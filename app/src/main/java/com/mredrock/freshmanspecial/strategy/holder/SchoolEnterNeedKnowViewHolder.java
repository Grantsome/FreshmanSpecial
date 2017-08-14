package com.mredrock.freshmanspecial.strategy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class SchoolEnterNeedKnowViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind (R.id.school_enter_know_name)
    TextView mKnowName;

    @Bind (R.id.school_enter_know_desc)
    TextView mKnowDesc;

    public void setKnowName(String knowName) {
        mKnowName.setText(knowName);
    }

    public void setKnowDesc(String knowDesc) {
        mKnowDesc.setText(knowDesc);
    }

    private SchoolEnterNeedKnowViewHolder.OnRecyclerViewItemClick mItemClick;

    public SchoolEnterNeedKnowViewHolder(View itemView, SchoolEnterNeedKnowViewHolder.OnRecyclerViewItemClick viewItemClick) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mItemClick = viewItemClick;
        mKnowDesc.setOnClickListener(this);
        mKnowName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mItemClick != null) {
            mItemClick.onItemClick(v);
        }
    }

    public interface OnRecyclerViewItemClick {
        void onItemClick(View view);
    }

    public void update() {
        //到时候这样写即可，其他同理
        //mBuildDecription.setText();
    }

}