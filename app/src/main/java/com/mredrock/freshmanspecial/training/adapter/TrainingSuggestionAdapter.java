package com.mredrock.freshmanspecial.training.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.holder.TailViewHolder;
import com.mredrock.freshmanspecial.training.holder.TrainingSuggestHolder;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingSuggestionAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ITEM = 0;

    private static final int TYPE_TAIL = 1;

    private String[] mTitleList;

    private String[] mContentList;

    public TrainingSuggestionAdapter() {
        initData();//初始化数据,本来不应该在这里完成的，但是没有数据迫不得已这样做。
    }

    private void initData() {
        mTitleList =  APP.getContext().getResources().getStringArray(R.array.special_2017_training_suggest_title);
        mContentList =  APP.getContext().getResources().getStringArray(R.array.special_2017_training_suggest_content);
    }

    private String[] getTitleList() {
        return mTitleList;
    }

    private String[] getContentList() {
        return mContentList;
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
                TrainingSuggestHolder holderTwo = new TrainingSuggestHolder(inflater.inflate(R.layout.special_2017_item_training_suggestion, parent, false));
                return holderTwo;
            case TYPE_TAIL:
                final TailViewHolder tailViewHolder = new TailViewHolder(inflater.inflate(R.layout.special_2017_item_school_tail, parent, false));
                tailViewHolder.getLoadText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tailViewHolder.load(TrainingSuggestionAdapter.this);
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
                TrainingSuggestHolder mHolder = (TrainingSuggestHolder) holder;
                mHolder.setSuggestTitle(getTitleList()[position]);
                mHolder.setSuggestContent(getContentList()[position]);
                break;
            case TYPE_TAIL:
                ((TailViewHolder) holder).load(TrainingSuggestionAdapter.this);
                break;
            default:
                break;
        }
    }

    public void refreshRv() {

    }

    @Override
    public int getItemCount() {
        int size = mContentList.length + 1;
        return size;
    }
}

