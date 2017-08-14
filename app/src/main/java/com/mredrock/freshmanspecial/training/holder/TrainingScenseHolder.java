package com.mredrock.freshmanspecial.training.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingScenseHolder extends RecyclerView.ViewHolder {

    @Bind (R.id.training_scense_image)
    ImageView mTrainImage;

    @Bind (R.id.training_scense_content)
    TextView mTrainContent;

    public TrainingScenseHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    public void update() {
        //到时候这样写即可，其他同理
        //mBuildDecription.setText();
    }

}


