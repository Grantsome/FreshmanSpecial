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
import com.mredrock.freshmanspecial.strategy.adapter.StudentDormitoryRvAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/7.
 */

public class StudentDormitoryFragment extends Fragment {

        @Bind (R.id.recycler_view)
        RecyclerView mRv;

        private String TAG = "StudentDormitoryFM";

        private int mIndex;

        private StudentDormitoryRvAdapter mRvAdapter;

        public StudentDormitoryFragment() {

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        private void setUpSchoolRv(){
            LinearLayoutManager layoutManager = new LinearLayoutManager(APP.getContext());
            layoutManager.setOrientation(LinearLayout.VERTICAL);
            mRv.setLayoutManager(layoutManager);
            mRvAdapter = new StudentDormitoryRvAdapter(getActivity());
            mRv.setAdapter(mRvAdapter);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.special_2017_fragment_student_dormitory, container, false);
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
