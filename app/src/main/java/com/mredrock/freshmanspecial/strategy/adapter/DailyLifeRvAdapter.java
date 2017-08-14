package com.mredrock.freshmanspecial.strategy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.holder.DailyLifeViewHolder;
import com.mredrock.freshmanspecial.strategy.holder.TailViewHolder;
import com.mredrock.freshmanspecial.strategy.http.HttpLiUtils;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class DailyLifeRvAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ITEM = 0;

    private static final int TYPE_TAIL = 1;

    private Context mContext;

    public DailyLifeRvAdapter(Context context) {
        mContext = context;
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
                DailyLifeViewHolder holderTwo = new  DailyLifeViewHolder(inflater.inflate(R.layout.special_2017_item_normal_life, parent, false));
                return holderTwo;
            case TYPE_TAIL:
                final TailViewHolder tailViewHolder = new TailViewHolder(inflater.inflate(R.layout.special_2017_item_school_tail, parent, false));
                tailViewHolder.getLoadText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tailViewHolder.load(DailyLifeRvAdapter.this);
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
                DailyLifeViewHolder mHolder = (DailyLifeViewHolder) holder;
                HttpLiUtils.getNearLife(mContext,mHolder,position);
                break;
            case TYPE_TAIL:
                ((TailViewHolder) holder).load(DailyLifeRvAdapter.this);
                break;
            default:
                break;
        }
    }

    public void refreshRv() {

    }

    @Override
    public int getItemCount() {
        int size = 9 + 1;
        return size;
    }
}
