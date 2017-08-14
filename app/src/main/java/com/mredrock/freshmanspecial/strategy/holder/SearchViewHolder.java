package com.mredrock.freshmanspecial.strategy.holder;

import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class SearchViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.search_result_item)
    TextView mItemResult;

    public SearchViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setResultText(String result){
        mItemResult.setText(result);
    }

}

