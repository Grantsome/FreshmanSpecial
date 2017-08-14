package com.mredrock.freshmanspecial.strategy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.holder.SchoolEnterNeedKnowViewHolder;
import com.mredrock.freshmanspecial.strategy.holder.TailViewHolder;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class SchoolEnterNeedKnowRvAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ITEM = 0;

    private static final int TYPE_TAIL = 1;

    private String[] mTitleList;  //Integer需要被替换掉,替换成入学需知的model

    private String[] mContentList;

    private SchoolEnterNeedKnowViewHolder.OnRecyclerViewItemClick mRvItemClick;

    public SchoolEnterNeedKnowRvAdapter(SchoolEnterNeedKnowViewHolder.OnRecyclerViewItemClick rvItemClick) {
        initData();//初始化数据,本来不应该在这里完成的，但是没有数据迫不得已这样做。
        mRvItemClick = rvItemClick;
    }

    private void initData() {
        mTitleList = APP.getContext().getResources().getStringArray(R.array.special_2017_need_know_title_list);
        mContentList = APP.getContext().getResources().getStringArray(R.array.special_2017_need_know_content_list);
    }

    @Override
    public int getItemViewType(int position) {
        if (position != getItemCount() - 1) {
            return TYPE_ITEM;
        } else {
            return TYPE_TAIL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_ITEM:
                SchoolEnterNeedKnowViewHolder holderTwo = new SchoolEnterNeedKnowViewHolder(inflater.inflate(R.layout.special_2017_item_enter_need_known, parent, false), mRvItemClick);
                return holderTwo;
            case TYPE_TAIL:
                final TailViewHolder tailViewHolder = new TailViewHolder(inflater.inflate(R.layout.special_2017_item_school_tail, parent, false));
                tailViewHolder.getLoadText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tailViewHolder.load(SchoolEnterNeedKnowRvAdapter.this);
                        //也许要添加其他东西
                    }
                });
                return tailViewHolder;
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_ITEM:
                SchoolEnterNeedKnowViewHolder mHolder = (SchoolEnterNeedKnowViewHolder) holder;
                mHolder.setKnowName(mTitleList[position]);
                mHolder.setKnowDesc(mContentList[position]);
                break;
            case TYPE_TAIL:
                ((TailViewHolder) holder).load(SchoolEnterNeedKnowRvAdapter.this);
                break;
            default:
                break;
        }
    }

    public void refreshRv() {

    }

    @Override
    public int getItemCount() {
        int size = 3 + 1;
        return size;
    }
}