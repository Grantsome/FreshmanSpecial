package com.mredrock.freshmanspecial.strategy.http;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.strategy.holder.DailyLifeViewHolder;
import com.mredrock.freshmanspecial.strategy.model.LifeInNear;

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

public class HttpLiUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mNameList = new ArrayList<>();

    private static List<String> mResumeList = new ArrayList<>();

    private static List<String> mLocationList = new ArrayList<>();

    private static List<String> mUrlList = new ArrayList<>();

    public static void getNearLife(final Context context, final DailyLifeViewHolder viewHolder, final int position){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        LifeNearApi api = retrofit.create(LifeNearApi.class);
        Observable<LifeInNear> observable = api.getData("LifeInNear");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LifeInNear>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LifeInNear lifeInNear) {
                        for(int i = 0; i < lifeInNear.getData().size();i++){
                            LifeInNear.DataBean dataBean = lifeInNear.getData().get(i);
                            mNameList.add(dataBean.getName());
                            mLocationList.add(dataBean.getLocation());
                            mResumeList.add(dataBean.getResume());
                            mUrlList.addAll(dataBean.getUrl());
                        }
                        viewHolder.setDailyName(mNameList.get(position));
                        viewHolder.setDailyDesc(mResumeList.get(position));
                        viewHolder.setDailyLoc(mLocationList.get(position));
                        viewHolder.setItemClick(new DailyLifeViewHolder.OnRecyclerViewItemClick() {
                            @Override
                            public void onItemClick(View view) {
                                switch (view.getId()){
                                    case R.id.daily_life_image:
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
                                }
                            }
                        });
                        Glide.with(context).load(mUrlList.get(position)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(viewHolder.getDailyImage());
                    }
                });
    }

    public interface LifeNearApi{

        @GET ("apiForGuide.php")
        Observable<LifeInNear> getData(@Query ("RequestType") String RequestType);
    }

}
