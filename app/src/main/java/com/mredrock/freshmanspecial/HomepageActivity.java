package com.mredrock.freshmanspecial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomepageActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton mCQUPTStrategy; //邮子攻略
    private ImageButton mCQUPTElegant; //重邮风采
    private ImageButton mCQUPTData; //重邮数据
    private ImageButton mCQUPTMilitaryTra; //军训特辑

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_2017_activity_main);

        mCQUPTStrategy = (ImageButton) findViewById(R.id.strategy);
        mCQUPTElegant = (ImageButton) findViewById(R.id.elegant);
        mCQUPTData = (ImageButton) findViewById(R.id.cqupt_data);
        mCQUPTMilitaryTra = (ImageButton) findViewById(R.id.military_training);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.strategy:

                break;
            case R.id.elegant:

                break;
            case R.id.cqupt_data:

                break;
            case R.id.military_training:

                break;
        }
    }
}
