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
import com.mredrock.freshmanspecial.strategy.model.Cate;

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

public class HttpCaUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mNameList = new ArrayList<>();

    private static List<String> mResumeList = new ArrayList<>();

    private static List<String> mLocationList = new ArrayList<>();

    private static List<String> mUrlList = new ArrayList<>();

    public static void getDailyLife(final Context context, final GoodFoodViewHolder holder, final int position){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        CateApi api = retrofit.create(CateApi.class);
        Observable<Cate> observable = api.getData("Cate");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Cate>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Cate cate) {
//                        Log.d("HttpCaUtils", "onNext: "+cate.getData().size());
                        for(int i = 0; i < cate.getData().size();i++){
                            Cate.DataBean dataBean = cate.getData().get(i);
                            mNameList.add(dataBean.getName());
                            mLocationList.add(dataBean.getLocation());
                            mResumeList.add(dataBean.getResume());
                            mUrlList.addAll(dataBean.getUrl());
                        }
                        Glide.with(context).load(mUrlList.get(position)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getFoodImage());
                        holder.setFoodName(mNameList.get(position));
                        holder.setFoodLoc(mLocationList.get(position));
                        holder.setFoodDesc(mResumeList.get(position));
                        holder.setItemClick(new GoodFoodViewHolder.OnRecyclerViewItemClick() {
                            @Override
                            public void onItemClick(View view) {
                                switch (view.getId()){
                                    case R.id.good_food_image:
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

    public interface CateApi{

        @GET ("apiForGuide.php")
        Observable<Cate> getData(@Query ("RequestType") String RequestType);
    }

}
