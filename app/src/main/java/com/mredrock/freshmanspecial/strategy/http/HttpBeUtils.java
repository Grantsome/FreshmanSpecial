package com.mredrock.freshmanspecial.strategy.http;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.strategy.holder.GoodFoodViewHolder;
import com.mredrock.freshmanspecial.strategy.holder.ScenceViewHolder;
import com.mredrock.freshmanspecial.strategy.model.BeautyInNear;

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

public class HttpBeUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mNameList = new ArrayList<>();

    private static List<String> mResumeList = new ArrayList<>();

    private static List<String> mLocationList = new ArrayList<>();

    private static List<String> mUrlList = new ArrayList<>();

    public static void getBeauty(final Context context, final ScenceViewHolder holder,final int position){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        BeautyApi api = retrofit.create(BeautyApi.class);
        Observable<BeautyInNear> observable = api.getData("BeautyInNear");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BeautyInNear>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BeautyInNear beautyInNear) {
                        for(int i = 0; i < beautyInNear.getData().size();i++){
                            BeautyInNear.DataBean dataBean = beautyInNear.getData().get(i);
                            mNameList.add(dataBean.getName());
                            mLocationList.add(dataBean.getLocation());
                            mResumeList.add(dataBean.getResume());
                            mUrlList.addAll(dataBean.getUrl());
                        }
                        Glide.with(context).load(mUrlList.get(position)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getScenceImage());
                        holder.setScenceName(mNameList.get(position));
                        holder.setScenceLoc(mLocationList.get(position));
                        holder.setScenceDesc(mResumeList.get(position));
                        holder.setItemClick(new GoodFoodViewHolder.OnRecyclerViewItemClick() {
                            @Override
                            public void onItemClick(View view) {
                                switch (view.getId()){
                                    case R.id.scence_image:
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

                    }
                });

    }

    public interface BeautyApi{

        @GET ("apiForGuide.php")
        Observable<BeautyInNear> getData(@Query ("RequestType") String RequestType);
    }
}
