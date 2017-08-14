package com.mredrock.freshmanspecial.strategy.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.strategy.holder.SchoolEnvironmentViewHolder;
import com.mredrock.freshmanspecial.strategy.holder.TailViewHolder;
import com.mredrock.freshmanspecial.strategy.http.HttpOkUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grantsome on 2017/8/3.
 */

public class SchoolEnvironmentRvAdapter extends RecyclerView.Adapter {

    private static final int TYPE_IMAGE_LEFT = 0;

    private static final int TYPE_TAIL = 2;

    private static List<String> mContentList;

    private static List<String> mTitleList;

    private static List<String> mUrlList;

    private Context mContext;

    private ArrayList<Integer> mList;  //Integer需要被替换掉,替换成学校建筑的model

    private SchoolEnvironmentViewHolder.OnRecyclerViewItemClick mRvItemClick;

    public SchoolEnvironmentViewHolder.OnRecyclerViewItemClick getRvItemClick(final Context context,final int position){
        return new SchoolEnvironmentViewHolder.OnRecyclerViewItemClick() {
            @Override
            public void onItemClick(View view) {
                switch (view.getId()){
                    case R.id.school_image:
                        ArrayList<Rect> mRectList = new ArrayList<Rect>();
                        for(int i = 0; i < 1;i++){
                            Rect rect = new Rect();
                            view.getGlobalVisibleRect(rect);
                            mRectList.add(rect);
                        }
                        Intent intent = new Intent(context, ImageDetailActivity.class);
                        intent.putParcelableArrayListExtra("rectList",mRectList);
                        intent.putExtra("url",((ArrayList<String>) mUrlList).get(position));
                        intent.putExtra("index",0);
                        context.startActivity(intent);
                        break;
                }
            }
        };
    }


    public SchoolEnvironmentRvAdapter(Context context,List<String> contentList,List<String> titleList,List<String> urlList){
        mContext = context;
//        mContentList = contentList;
//        mTitleList = titleList;
//        mUrlList = urlList;
    }

    public SchoolEnvironmentRvAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getItemViewType(int position){
        if(position != getItemCount()-1){
            return TYPE_IMAGE_LEFT;
        }else {
            return TYPE_TAIL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case TYPE_IMAGE_LEFT:
                SchoolEnvironmentViewHolder holderOne = new SchoolEnvironmentViewHolder(inflater.inflate(R.layout.special_2017_item_school_left,parent,false),mRvItemClick);
                //holderOne.addOnClickListener();
                return holderOne;
            case TYPE_TAIL:
                final TailViewHolder tailViewHolder = new TailViewHolder(inflater.inflate(R.layout.special_2017_item_school_tail,parent,false));
                tailViewHolder.getLoadText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tailViewHolder.load(SchoolEnvironmentRvAdapter.this);
                       //也许要添加其他东西
                    }
                });
                return tailViewHolder;

        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)){
            case TYPE_IMAGE_LEFT:
                SchoolEnvironmentViewHolder viewHolder = (SchoolEnvironmentViewHolder) holder;
//                viewHolder.setBuildNameText(mTitleList.get(position));
//                viewHolder.setBuildDecription(mContentList.get(position));
//                ((SchoolEnvironmentViewHolder) holder).setRvItemClick(new SchoolEnvironmentViewHolder.OnRecyclerViewItemClick() {
//                    @Override
//                    public void onItemClick(View view) {
//                        switch (view.getId()){
//                            case R.id.school_image:
//                                ArrayList<Rect> mRectList = new ArrayList<Rect>();
//                                for(int i = 0; i < 1;i++){
//                                    Rect rect = new Rect();
//                                    view.getGlobalVisibleRect(rect);
//                                    mRectList.add(rect);
//                                }
//                                Intent intent = new Intent(mContext, ImageDetailActivity.class);
//                                intent.putParcelableArrayListExtra("rectList",mRectList);
//                                intent.putExtra("url",((ArrayList<String>) mUrlList).get(position));
//                                intent.putExtra("index",0);
//                                mContext.startActivity(intent);
//                                break;
//                        }
//                    }
//                });
//                Glide.with(mContext).load(mUrlList.get(position)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(viewHolder.getmageView());
//
                HttpOkUtils.getSchoolBuildings(viewHolder,mContext,position);
                   break;
            case TYPE_TAIL:
                TailViewHolder tailViewHolder = (TailViewHolder) holder;
                break;
            default:
                break;
        }
    }

    public void refreshRv(){
       notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
//        Log.d("Adapter","getItemCount() "+mContentList.size());
        return 7+1;
    }
}
