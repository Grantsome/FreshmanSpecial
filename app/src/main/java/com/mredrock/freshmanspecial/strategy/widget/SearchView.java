package com.mredrock.freshmanspecial.strategy.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mredrock.freshmanspecial.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Grantsome on 2017/8/8.
 */

public class SearchView  extends LinearLayout{

    @Bind(R.id.search_input)
    EditText mSearchEdit;

    @Bind(R.id.search_delete)
    ImageView mSearchDelete;

    @Bind(R.id.search_cancel)
    Button mCancelSearch;

    @Bind(R.id.result_head)
    TextView mResultHead;
    private SearchViewListener mSearchListener;

    private Context mContext;

    @OnClick(R.id.search_input)
    public void clickOnInput(){
        mResultHead.setVisibility(View.GONE);
        mSearchDelete.setVisibility(View.VISIBLE);
        mCancelSearch.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.search_delete)
    public void clickOnDelete(){
        mResultHead.setVisibility(View.GONE);
        mSearchEdit.setText("");
        mSearchDelete.setVisibility(View.GONE);
    }

    @OnClick(R.id.search_cancel)
    public void clickOnSubmit(){
        mSearchEdit.setText("");
        mResultHead.setVisibility(View.GONE);
        mCancelSearch.setVisibility(View.GONE);
        mSearchDelete.setVisibility(View.GONE);
    }

    public void setSearchListener(SearchViewListener searchListener) {
        mSearchListener = searchListener;
    }


    public SearchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_search_view,this);
        ButterKnife.bind(this,view);
        mContext = context;
        setListener();
    }

    public SearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.special_2017_item_search_view,this);
        mContext = context;
        ButterKnife.bind(this,view);
        setListener();
    }

    private void setListener(){
        mSearchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                if(!"".equals(s.toString())){
//                    mSearchDelete.setVisibility(VISIBLE);
//                    mTipList.setVisibility(VISIBLE);
//                    if(mSearchAutoCompleteAdapter!=null&&mTipList.getAdapter()!=mSearchAutoCompleteAdapter){
//                        mTipList.setAdapter(mSearchAutoCompleteAdapter);
//                    }
//                    if(mSearchListener!=null){
//                        mSearchListener.onRefreshAutoComplete(s+"");
//                    }
//                }else {
//                    mSearchDelete.setVisibility(View.GONE);
//                    if(mSearchHintAdapter!=null){
//                        mTipList.setAdapter(mSearchHintAdapter);
//                    }
//                    mTipList.setVisibility(View.GONE);
//                }
                notifyNotHideSoftInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mSearchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    notifyStartSearching();
                }
                return true;
            }
        });

    }

    private void notifyStartSearching(){
        if(null!=mSearchListener){
            mResultHead.setVisibility(View.VISIBLE);
            mSearchListener.onSearch(mSearchEdit.getText().toString());
        }
        hideSoftInput();
      }

    private void notifyNotHideSoftInput(){
        if(null!=mSearchListener){
            mResultHead.setVisibility(View.VISIBLE);
            mSearchListener.onSearch(mSearchEdit.getText().toString());
        }
    }

    private void hideSoftInput(){
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public interface SearchViewListener{

        void onRefreshAutoComplete(String text);

        void onSearch(String query);

    }

}
