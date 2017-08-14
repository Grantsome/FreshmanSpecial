package com.mredrock.freshmanspecial.training.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingSuggestHolder extends RecyclerView.ViewHolder {

    @Bind (R.id.suggestion_title)
    TextView mSuggestTitle;

    @Bind (R.id.suggestion_content)
    TextView mSuggestContent;


    public TrainingSuggestHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setSuggestContent(String suggestContent) {
        mSuggestContent.setText(suggestContent);
    }

    public void setSuggestTitle(String suggestTitle) {
        mSuggestTitle.setText(suggestTitle);
    }

}

