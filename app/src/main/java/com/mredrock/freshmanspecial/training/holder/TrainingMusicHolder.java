package com.mredrock.freshmanspecial.training.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingMusicHolder extends RecyclerView.ViewHolder {


    public TrainingMusicHolder (View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}



