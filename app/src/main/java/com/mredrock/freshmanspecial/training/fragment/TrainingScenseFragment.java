package com.mredrock.freshmanspecial.training.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.training.adapter.TrainingScenseAdapter;
import com.mredrock.freshmanspecial.training.holder.TrainingVideoHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingScenseFragment extends Fragment {

    @Bind (R.id.recycler_view)
    RecyclerView mRv;

    private String TAG = "StudentDormitoryFM";

    private int mIndex;

    private TrainingScenseAdapter mRvAdapter;

    public TrainingScenseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setUpSchoolRv(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(APP.getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRv.setLayoutManager(layoutManager);
        mRvAdapter = new TrainingScenseAdapter(new TrainingVideoHolder.OnRecyclerViewItemClick() {
            @Override
            public void onItemClick(View view) {
                switch (view.getId()) {
                    case R.id.play_video_first:
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse("https://v.qq.com/x/page/f0526oi2zyx.html"));
                        startActivity(intent);
                        break;
                    case R.id.play_video_second:
                        Intent i = new Intent();
                        i.setAction("android.intent.action.VIEW");
                        i.setData(Uri.parse("https://v.qq.com/x/page/p0522eqzqzz.html"));
                        startActivity(i);
                        break;
                }
            }
        },getActivity());
        mRv.setAdapter(mRvAdapter);
    }

    private void repsonse(View view,String desc){
        ArrayList<Rect> mRectList = new ArrayList<Rect>();
        for(int i = 0; i < 4;i++){
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            mRectList.add(rect);
        }
        ArrayList<Integer> mResIDList = new ArrayList<Integer>();
        mResIDList.add(R.drawable.ic_training_first);
        mResIDList.add(R.drawable.ic_training_second);
        mResIDList.add(R.drawable.ic_training_first);
        mResIDList.add(R.drawable.ic_training_second);
        Intent intent = new Intent(getActivity(), ImageDetailActivity.class);
        intent.putParcelableArrayListExtra("rectList",mRectList);
        intent.putIntegerArrayListExtra("resIDList",mResIDList);
        mIndex = 0;
        intent.putExtra("index",0);
        intent.putExtra("desc",desc);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_training_scense, container, false);
        ButterKnife.bind(this,view);
        setUpSchoolRv();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void log(String message){
        Log.d(TAG,message);
    }

}

