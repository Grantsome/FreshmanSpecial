package com.mredrock.freshmanspecial.strategy.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.holder.SearchViewHolder;

import java.util.List;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class SearchRvAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ITEM = 0;

    private static final int TYPE_TAIL = 1;

    private List<String> mList;  //Integer需要被替换掉,替换成学校食堂的model

    public SearchRvAdapter(List<String> resultList){
        mList = resultList;
    }

    @Override
    public int getItemViewType(int position){
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case TYPE_ITEM:
                SearchViewHolder holderTwo = new SearchViewHolder(inflater.inflate(R.layout.special_2017_item_search_result,parent,false));
                return holderTwo;
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_ITEM:
                SearchViewHolder mHolder = (SearchViewHolder) holder;
                mHolder.setResultText(mList.get(position));
                Log.d("SearchRvAdapter", "onBindViewHolder: "+mList.get(position));
                break;
            default:
                break;
        }
    }

    public void refreshRv(){

    }

    @Override
    public int getItemCount() {
        int size = mList.size();
        return size;
    }
}


