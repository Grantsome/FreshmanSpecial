package com.mredrock.freshmanspecial.strategy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mredrock.freshmanspecial.APP;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.adapter.SchoolEnvironmentRvAdapter;
import com.mredrock.freshmanspecial.strategy.adapter.SearchRvAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Grantsome on 2017/8/3.
 */

public class TailViewHolder extends RecyclerView.ViewHolder{

    @Bind(R.id.load)
    TextView mLoadText;
    public static final int TYPE_SCHOOL_ENVIRONMRNT = 0;

    //其他类型需到时候补充,7个Fragment,应该是7个TYPE

    public boolean isloading;

    public TailViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        isloading = false;
    }

    public TextView getLoadText(){
        return mLoadText;
    }

    public void load(RecyclerView.Adapter adapter){
        int n = 1;
        if((adapter.getItemCount()-n)%2!=0){
            mLoadText.setText(APP.getContext().getString(R.string.special_2017_load_finish_no_more));
            return;
        }
        if(isloading){
            return;
        }
        if(adapter instanceof SearchRvAdapter){
            mLoadText.setText(R.string.special_2017_search_result_no_more);
            return;
        }
        if(adapter instanceof SchoolEnvironmentRvAdapter){
            mLoadText.setText(APP.getContext().getString(R.string.special_2017_load_finish_no_more));
           ((SchoolEnvironmentRvAdapter) adapter).notifyDataSetChanged();
            return;
        }
        mLoadText.setText(APP.getContext().getString(R.string.special_2017_load_finish_no_more));//真正加载的时候要改了
        isloading = true;
        //进行网络请求,然后在根据不同的type进行add到不同的adapter里面

    }
}
