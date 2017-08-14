package com.mredrock.freshmanspecial.strategy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.adapter.GoodFoodRvAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class GoodFoodFragment extends Fragment {

    @Bind (R.id.recycler_view)
    RecyclerView mRv;

    private int mIndex;

    private GoodFoodRvAdapter mRvAdapter;

    public GoodFoodFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setUpSchoolRv(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(APP.getContext());
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        mRv.setLayoutManager(layoutManager);
        mRvAdapter = new GoodFoodRvAdapter(getActivity());
        mRv.setAdapter(mRvAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_good_food, container, false);
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

}

