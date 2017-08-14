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
import com.mredrock.freshmanspecial.strategy.holder.SchoolEnvironmentViewHolder;
import com.mredrock.freshmanspecial.strategy.model.SchoolBuildings;

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
 * Created by Grantsome on 2017/8/12.
 */

public class HttpOkUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mContentList = new ArrayList<>();

    private static List<String> mTitleList = new ArrayList<>();

    private static List<String> mUrlList = new ArrayList<>();

    public static List<String> getContentList() {
        if(mContentList.size() == 0){

        }
        return mContentList;
    }

    public static List<String> getTitleList() {
        Log.d("Buildings", "getTitleList: "+mTitleList.size());
        return mTitleList;
    }

    public static List<String> getUrlList() {
        return mUrlList;
    }

    public static void getSchoolBuildings(final SchoolEnvironmentViewHolder viewHolder,final Context mContext,final int i){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        final SchoolBuildingApi buildingApi = retrofit.create(SchoolBuildingApi.class);
        Observable<SchoolBuildings> call = buildingApi.getData("SchoolBuildings");
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SchoolBuildings>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SchoolBuildings schoolBuildings) {
                        SchoolBuildings buildings = schoolBuildings;
                        if(mContentList.size() == 0){
                            mContentList.clear();
                            mTitleList.clear();
                            mUrlList.clear();
                            for(int i = 0; i < buildings.getData().size();i++){
                                SchoolBuildings.DataBean dataBean = buildings.getData().get(i);
                                mTitleList.add(dataBean.getTitle());
                                mContentList.add(dataBean.getContent());
                                mUrlList.addAll(dataBean.getUrl());
                            }
                        }
                        viewHolder.setBuildNameText(mTitleList.get(i));
                        viewHolder.setBuildDecription(mContentList.get(i));
                        ((SchoolEnvironmentViewHolder) viewHolder).setRvItemClick(new SchoolEnvironmentViewHolder.OnRecyclerViewItemClick() {
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
                                        Intent intent = new Intent(mContext, ImageDetailActivity.class);
                                        intent.putParcelableArrayListExtra("rectList",mRectList);
                                        intent.putExtra("url",((ArrayList<String>) mUrlList).get(i));
                                        intent.putExtra("index",0);
                                        mContext.startActivity(intent);
                                        break;
                                }
                            }
                        });
                        Glide.with(mContext).load(mUrlList.get(i)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(viewHolder.getmageView());


                    }
                });
//        call.enqueue(new Callback<SchoolBuildings>() {
//            @Override
//            public void onResponse(Call<SchoolBuildings> call, Response<SchoolBuildings> response) {
//                 SchoolBuildings buildings = response.body();
//                 mContentList.clear();
//                 mTitleList.clear();
//                 mUrlList.clear();
//                for(int i = 0; i < buildings.getData().size();i++){
//                    SchoolBuildings.DataBean dataBean = buildings.getData().get(i);
//                    mTitleList.add(dataBean.getTitle());
//                    mContentList.add(dataBean.getContent());
//                    mUrlList.addAll(dataBean.getUrl());
//                }
//                Log.d("Buildings", "onResponse: "+mUrlList.size());
//            }
//
//            @Override
//            public void onFailure(Call<SchoolBuildings> call, Throwable t) {
//
//            }
//        });
    }

    public interface SchoolBuildingApi{

        @GET("apiForGuide.php")
        Observable<SchoolBuildings> getData(@Query("RequestType") String RequestType);
    }

}
