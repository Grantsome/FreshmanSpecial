package com.mredrock.freshmanspecial.training.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.holder.TailViewHolder;
import com.mredrock.freshmanspecial.training.holder.TrainingMusicHolder;
import com.mredrock.freshmanspecial.training.holder.TrainingPictureHolder;
import com.mredrock.freshmanspecial.training.holder.TrainingVideoHolder;
import com.mredrock.freshmanspecial.training.http.HttpUtils;

import java.util.ArrayList;

/**
 * Created by Grantsome on 2017/8/10.
 */

public class TrainingScenseAdapter extends RecyclerView.Adapter {

    private static final int TYPE_PICTURE = 0;

    private static final int TYPE_TAIL = 1;

    private static final int TYPE_VIDEO = 2;

    private static final int TYPE_MUSIC = 3;

    private ArrayList<Integer> mList;  //Integer需要被替换掉,替换成入学需知的model

    private TrainingVideoHolder.OnRecyclerViewItemClick mItemClick;

    private String URL_ONE = "http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/jxfc/cover/重庆邮电大学2016级学生军训回顾.png";

    private String URL_TWO = "http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/jxfc/cover/重庆邮电大学2016级学生军训纪实.png";

    private Context mContext;

    public TrainingScenseAdapter(TrainingVideoHolder.OnRecyclerViewItemClick itemClick, Context context) {
        mList = new ArrayList<>();
        mItemClick = itemClick;
        mContext = context;
        initData();
    }

    private void initData() {
        if (mList != null) {
            mList.add(1);
            mList.add(2);
            mList.add(3);
        }
    }

    @Override
    public int getItemViewType(int position) {
       if(position == 0){
           return TYPE_PICTURE;
       }
       if(position == 1){
           return TYPE_VIDEO;
       }
       if(position == 2){
           return TYPE_MUSIC;
       }else {
           return TYPE_TAIL;
       }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_PICTURE:
                TrainingPictureHolder holderTwo = new TrainingPictureHolder(inflater.inflate(R.layout.special_2017_item_training_picture, parent, false));
                return holderTwo;
            case TYPE_VIDEO:
                TrainingVideoHolder holderOne = new TrainingVideoHolder(inflater.inflate(R.layout.special_2017_item_training_video,parent,false),mItemClick);
                Glide.with(mContext).load(URL_ONE).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holderOne.getSecondVideoImage());
                Glide.with(mContext).load(URL_TWO).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holderOne.getFirstVideoImage());
                return holderOne;
            case TYPE_MUSIC:
                TrainingMusicHolder holderThree = new TrainingMusicHolder(inflater.inflate(R.layout.special_2017_item_training_music,parent,false));
                return holderThree;
            case TYPE_TAIL:
                final TailViewHolder tailViewHolder = new TailViewHolder(inflater.inflate(R.layout.special_2017_item_school_tail, parent, false));
                tailViewHolder.getLoadText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tailViewHolder.load(TrainingScenseAdapter.this);
                        //也许要添加其他东西
                    }
                });
                return tailViewHolder;
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_PICTURE:
                TrainingPictureHolder mHolder = (TrainingPictureHolder) holder;
                HttpUtils.getPhoto(mContext,mHolder,position);
                break;
            case TYPE_VIDEO:
                TrainingVideoHolder videoHolder = (TrainingVideoHolder) holder;
                //videoHolder.update();
                break;
            case TYPE_MUSIC:
                TrainingMusicHolder musicHolder = (TrainingMusicHolder) holder;
                break;
            case TYPE_TAIL:
                ((TailViewHolder) holder).load(TrainingScenseAdapter.this);
                break;
            default:
                break;
        }
    }

    public void refreshRv() {

    }

    @Override
    public int getItemCount() {
        int size = mList.size() + 1;
        return size;
    }

}


