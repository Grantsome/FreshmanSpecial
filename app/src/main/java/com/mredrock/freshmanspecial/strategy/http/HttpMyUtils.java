package com.mredrock.freshmanspecial.strategy.http;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.strategy.holder.SchoolDinnerViewHolder;
import com.mredrock.freshmanspecial.strategy.model.Canteen;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Grantsome on 2017/8/13.
 */

public class HttpMyUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mNameList = new ArrayList<>();

    private static List<String> mResumeList = new ArrayList<>();

    private static List<String> mUrlList = new ArrayList<>();

    private static List<String> mFirstList = new ArrayList<>();

    private static List<String> mSecondList = new ArrayList<>();

    private static List<String> mThirdList = new ArrayList<>();

    private static List<String> mFourthList = new ArrayList<>();

    private static List<String> mFifthList = new ArrayList<>();

    private static List<String> mSexthList = new ArrayList<>();

    public static void getCanteen(final Context context, final SchoolDinnerViewHolder holder, final int position){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        CanteenApi canteenApi = retrofit.create(CanteenApi.class);
        Observable<Canteen> observable = canteenApi.getData("Canteen");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Canteen>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Canteen canteen) {
                       for(int i =0; i < canteen.getData().size();i++){
                           Canteen.DataBean dataBean = canteen.getData().get(i);
                           mNameList.add(dataBean.getName());
                           mResumeList.add(dataBean.getResume());
                           if(i == 0){
                               mFirstList.addAll(dataBean.getUrl());
                           }
                           if(i == 1){
                               mSecondList.addAll(dataBean.getUrl());
                           }
                           if(i == 2){
                               mThirdList.addAll(dataBean.getUrl());
                           }
                           if(i == 3){
                               mFourthList.addAll(dataBean.getUrl());
                           }
                           if(i == 4){
                               mFifthList.addAll(dataBean.getUrl());
                           }
                           if(i == 5){
                               mSexthList.addAll(dataBean.getUrl());
                           }
                       }
                       holder.setDinName(mNameList.get(position));
                       holder.setDinDesc(mResumeList.get(position));
                        if(position == 0){
                            Glide.with(context).load(mFirstList.get(0)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getDinImage());
                            Log.d("HttpMyUtils", "onNext: "+mFirstList.get(0));
                        }
                        if(position == 1){
                            Glide.with(context).load(mSecondList.get(0)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getDinImage());
                            Log.d("HttpMyUtils", "onNext: "+mSecondList.get(0));
                        }
                        if(position == 2){
                            Glide.with(context).load(mThirdList.get(0)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getDinImage());
                            Log.d("HttpMyUtils", "onNext: "+mThirdList.get(0));
                        }
                        if(position == 3){
                            Glide.with(context).load(mFourthList.get(0)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getDinImage());
                            Log.d("HttpMyUtils", "onNext: "+mFourthList.get(0));
                        }
                        if(position == 4){
                            Glide.with(context).load(mFifthList.get(0)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getDinImage());
                            Log.d("HttpMyUtils", "onNext: "+mFifthList.get(0));
                        }
                        if(position == 5){
                            Glide.with(context).load(mSexthList.get(0)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getDinImage());
                            Log.d("HttpMyUtils", "onNext: "+mSexthList.get(0));
                        }
                        ((SchoolDinnerViewHolder) holder).setItemClick(new SchoolDinnerViewHolder.OnRecyclerViewItemClick() {
                            @Override
                            public void onItemClick(View view) {
                                switch (view.getId()){
                                    case R.id.school_din_image:
                                        ArrayList<Rect> mRectList = new ArrayList<Rect>();
                                        if(position == 0){
                                            for(int i = 0; i < mFirstList.size();i++){
                                                Rect rect = new Rect();
                                                view.getGlobalVisibleRect(rect);
                                                mRectList.add(rect);
                                            }
                                            Intent intent = new Intent(context, ImageDetailActivity.class);
                                            intent.putParcelableArrayListExtra("rectList",mRectList);
                                            ArrayList<String> list = new ArrayList<>();
                                            list.addAll(mFirstList);
                                            intent.putStringArrayListExtra("urlList",list);
                                            intent.putExtra("index",0);
                                            context.startActivity(intent);
                                        }
                                        if(position == 1){
                                            for(int i = 0; i < mSecondList.size();i++){
                                                Rect rect = new Rect();
                                                view.getGlobalVisibleRect(rect);
                                                mRectList.add(rect);
                                            }
                                            Intent intent = new Intent(context, ImageDetailActivity.class);
                                            intent.putParcelableArrayListExtra("rectList",mRectList);
                                            ArrayList<String> list = new ArrayList<>();
                                            list.addAll(mSecondList);
                                            intent.putStringArrayListExtra("urlList",list);
                                            intent.putExtra("index",0);
                                            context.startActivity(intent);
                                        }
                                        if(position == 2){
                                            for(int i = 0; i < mThirdList.size();i++){
                                                Rect rect = new Rect();
                                                view.getGlobalVisibleRect(rect);
                                                mRectList.add(rect);
                                            }
                                            Intent intent = new Intent(context, ImageDetailActivity.class);
                                            intent.putParcelableArrayListExtra("rectList",mRectList);
                                            ArrayList<String> list = new ArrayList<>();
                                            list.addAll(mThirdList);
                                            intent.putStringArrayListExtra("urlList",list);
                                            intent.putExtra("index",0);
                                            context.startActivity(intent);
                                        }
                                        if(position == 3){
                                            for(int i = 0; i < mFourthList.size();i++){
                                                Rect rect = new Rect();
                                                view.getGlobalVisibleRect(rect);
                                                mRectList.add(rect);
                                            }
                                            Intent intent = new Intent(context, ImageDetailActivity.class);
                                            intent.putParcelableArrayListExtra("rectList",mRectList);
                                            ArrayList<String> list = new ArrayList<>();
                                            list.addAll(mFourthList);
                                            intent.putStringArrayListExtra("urlList",list);
                                            intent.putExtra("index",0);
                                            context.startActivity(intent);
                                        }
                                        if(position == 4){
                                            for(int i = 0; i <mFifthList.size();i++){
                                                Rect rect = new Rect();
                                                view.getGlobalVisibleRect(rect);
                                                mRectList.add(rect);
                                            }
                                            Intent intent = new Intent(context, ImageDetailActivity.class);
                                            intent.putParcelableArrayListExtra("rectList",mRectList);
                                            ArrayList<String> list = new ArrayList<>();
                                            list.addAll(mFifthList);
                                            intent.putStringArrayListExtra("urlList",list);
                                            intent.putExtra("index",0);
                                            context.startActivity(intent);
                                        }
                                        if(position == 5){
                                            for(int i = 0; i < mSexthList.size();i++){
                                                Rect rect = new Rect();
                                                view.getGlobalVisibleRect(rect);
                                                mRectList.add(rect);
                                            }
                                            Intent intent = new Intent(context, ImageDetailActivity.class);
                                            intent.putParcelableArrayListExtra("rectList",mRectList);
                                            ArrayList<String> list = new ArrayList<>();
                                            list.addAll(mSexthList);
                                            intent.putStringArrayListExtra("urlList",list);
                                            intent.putExtra("index",0);
                                            context.startActivity(intent);
                                        }
                                }
                            }
                        });
                    }
                });
    }

//    public static void getCanteen(final Context context, final SchoolDinnerViewHolder holder, final int position){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        CanteenApi canteenApi = retrofit.create(CanteenApi.class);
//        Observable<Canteen> observable = canteenApi.getData("Canteen");
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Canteen>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Canteen canteen) {
//                        for (int i = 0; i < canteen.getData().size(); i++) {
//                            Canteen.DataBean dataBean = canteen.getData().get(i);
//                            mNameList.add(dataBean.getName());
//                            mResumeList.add(dataBean.getResume());
//                            mUrlList.addAll(dataBean.getUrl());
//                        }
//                        holder.setDinName(mNameList.get(position));
//                        holder.setDinDesc(mResumeList.get(position));
//                        Glide.with(context).load("http://hongyan.cqupt.edu.cn/welcome/2017/photoForWelcome/yzgl_xsst/红高粱.jpg").override(100,100).into(holder.getDinImage());
//                        Log.d("HttpMtUtils", "onNext: "+mUrlList.get(position));
//                    }
//                });
//    }

    public interface CanteenApi {

        @GET("apiForGuide.php")
        Observable<Canteen> getData(@Query ("RequestType") String RequestType);
    }

}
