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
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.adapter.SearchRvAdapter;
import com.mredrock.freshmanspecial.strategy.http.HttpUtils;
import com.mredrock.freshmanspecial.strategy.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class QQGroupFragment extends Fragment {


    @Bind(R.id.recycler_view)
    RecyclerView mResultRv;

    @Bind(R.id.search)
    SearchView mSearchView;

    private ArrayAdapter<String> hintAdapter;

    private ArrayAdapter<String> autoCompletedAdapter;

    private SearchRvAdapter mRvAdapter;

    private List<String> dbData;

    private List<String> autoCompleteData;

    private List<String> resultData;

    private List<String> mGroupNameList;

    private List<Integer> mGroupNumberList;

//    private static int DEFAULT_HINT_SIZE = 8;
//
//    private int hintSize = DEFAULT_HINT_SIZE;
//
//    public void setHintSize(int mHintSize) {
//        this.hintSize = mHintSize;
//    }

    public QQGroupFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_qq_group, container, false);
        ButterKnife.bind(this,view);
        setData();
        setListener();
        return view;
    }

    private void setListener(){
        mSearchView.setSearchListener(new SearchView.SearchViewListener() {
            @Override
            public void onRefreshAutoComplete(String text) {
//                setAutoCompleteData(text);
            }

            @Override
            public void onSearch(String query) {
                setResultData(query);
                mResultRv.setVisibility(View.VISIBLE);
                LinearLayoutManager layoutManager = new LinearLayoutManager(APP.getContext());
                layoutManager.setOrientation(LinearLayout.VERTICAL);
                mResultRv.setLayoutManager(layoutManager);
                mResultRv.setAdapter(mRvAdapter);
                if(null == mResultRv.getAdapter()){
                    mResultRv.setAdapter(mRvAdapter);
                    Log.d("QQFragment", "onSearch: 设置Adapter完成");
                }else {
                    mRvAdapter.notifyDataSetChanged();
                }
            }
        });
//        mSearchView.setSearchHintAdapter(hintAdapter);
//        mSearchView.setSearchAutoCompleteAdapter(autoCompletedAdapter);
    }

    private void setData(){
        setDbData();
        setResultData(null);
    }

    private void setDbData(){
        dbData = new ArrayList<>();
        dbData = HttpUtils.getRatio();
        Log.d("QQFragment", "setDbData: "+dbData.size());
    }


//    private void setAutoCompleteData(String text){
//        if(null == autoCompletedAdapter){
//            autoCompleteData = new ArrayList<>();
//        }else {
//            autoCompleteData.clear();
//            for(int i = 0;i < Math.min(dbData.size(),hintSize);i++){
//                if(dbData.get(i).contains(text)){
//                    autoCompleteData.add(dbData.get(i));
//                }
//            }
//        }
//        if(null == autoCompletedAdapter){
//            autoCompletedAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,autoCompleteData);
//        }else {
//            autoCompletedAdapter.notifyDataSetChanged();
//        }
//    }

    private void setResultData(String query){
        if(null == resultData){
            resultData = new ArrayList<>();
        }else {
            resultData.clear();
            for(int i = 0;i < dbData.size();i++){
                if(dbData.get(i).contains(query)){
                    resultData.add(dbData.get(i));
                    Log.d("QQFragment", "setResultData: 第i个"+dbData.get(i));
                }
            }
            if(resultData.size() == 0||query == null){
                resultData.clear();
                resultData = dbData;
            }
        }
        Log.d("QQFragment", "setResultData: 大小："+resultData.size());
        if(null == mRvAdapter){
            mRvAdapter = new SearchRvAdapter(resultData);
        }else {
            mRvAdapter.notifyDataSetChanged();
        }
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