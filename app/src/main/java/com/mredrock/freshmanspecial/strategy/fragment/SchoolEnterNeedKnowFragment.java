package com.mredrock.freshmanspecial.strategy.fragment;

import android.content.Context;
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
import com.mredrock.freshmanspecial.strategy.adapter.SchoolEnterNeedKnowRvAdapter;
import com.mredrock.freshmanspecial.strategy.holder.SchoolEnterNeedKnowViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class SchoolEnterNeedKnowFragment extends Fragment {

    @Bind (R.id.recycler_view)
    RecyclerView mRv;

    private String TAG = "SchoolDinnerFM";

    private int mIndex;

    private SchoolEnterNeedKnowRvAdapter mRvAdapter;

    public SchoolEnterNeedKnowFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setUpSchoolRv(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(APP.getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRv.setLayoutManager(layoutManager);
        mRvAdapter = new SchoolEnterNeedKnowRvAdapter(new SchoolEnterNeedKnowViewHolder.OnRecyclerViewItemClick() {
            @Override
            public void onItemClick(View view) {
                switch (view.getId()) {
                    case R.id.school_enter_know_desc:
                    case R.id.school_enter_know_name:
                        break;
                }

            }
        });
        mRv.setAdapter(mRvAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_enter_school_need_know, container, false);
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


