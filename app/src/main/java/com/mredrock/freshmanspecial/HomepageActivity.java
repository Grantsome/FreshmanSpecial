package com.mredrock.freshmanspecial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.mredrock.freshmanspecial.data.activity.DataActivity;
import com.mredrock.freshmanspecial.strategy.activity.StrategyActivity;
import com.mredrock.freshmanspecial.strategy.utils.StatusUtils;
import com.mredrock.freshmanspecial.training.activity.TrainingActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomepageActivity extends AppCompatActivity{

    @Bind(R.id.strategy)
    ImageButton mCQUPTStrategy; //邮子攻略

    @Bind(R.id.elegant)
    ImageButton mCQUPTElegant; //重邮风采

    @Bind(R.id.cqupt_data)
    ImageButton mCQUPTData; //重邮数据

    @Bind (R.id.military_training)
    ImageButton mCQUPTMilitaryTra; //军训特辑

    @OnClick (R.id.strategy)
    public void ClickOnStrategy(){
        Intent intent = new Intent(HomepageActivity.this, StrategyActivity.class);
        startActivity(intent);
    }

    @OnClick (R.id.cqupt_data)
    public void ClickOnData(){
        Intent intent = new Intent(HomepageActivity.this, DataActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.military_training)
    public void ClickOnTraining(){
        Intent intent = new Intent(HomepageActivity.this, TrainingActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_main);
        ButterKnife.bind(this);
        StatusUtils.changeStatus(this);
    }


}
