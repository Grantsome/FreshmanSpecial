package com.mredrock.freshmanspecial.strategy.http;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.strategy.holder.StudentDormitoryViewHolder;
import com.mredrock.freshmanspecial.strategy.model.Dormitory;

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

public class HttpReUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    public static List<String> mNameList;

    public static List<String> mResumeList;

    private static List<String> mUrlList;

    public static void getDormitroy(final Context context,final StudentDormitoryViewHolder holder, final int position){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        DormitoryApi api = retrofit.create(DormitoryApi.class);
        Observable<Dormitory> observable = api.getData("Dormitory");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Dormitory>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Dormitory dormitory) {
                        if(mNameList == null){
                            mNameList = new ArrayList<>();
                            mNameList.clear();
                            mResumeList = new ArrayList<>();
                            mResumeList.clear();
                            mUrlList = new ArrayList<>();
                            mUrlList.clear();
                        }
                        for(int i = 0; i < dormitory.getData().size();i++){
                            Dormitory.DataBean dataBean = dormitory.getData().get(i);
                            mNameList.add(dataBean.getName());
                            mResumeList.add(dataBean.getResume());
                            mUrlList.addAll(dataBean.getUrl());
                        }
                        holder.setDorName(mNameList.get(position));
                        holder.setDorDesc(mResumeList.get(position));
                        ((StudentDormitoryViewHolder) holder).setItemClick(new StudentDormitoryViewHolder.OnRecyclerViewItemClick() {
                            @Override
                            public void onItemClick(View view) {
                                switch (view.getId()){
                                    case R.id.student_dor_image:
                                        ArrayList<Rect> mRectList = new ArrayList<Rect>();
                                        for(int i = 0; i < 4;i++){
                                            Rect rect = new Rect();
                                            view.getGlobalVisibleRect(rect);
                                            mRectList.add(rect);
                                        }
                                        Intent intent = new Intent(context, ImageDetailActivity.class);
                                        intent.putParcelableArrayListExtra("rectList",mRectList);
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add(mUrlList.get(4*position));
                                        list.add(mUrlList.get(4*position+1));
                                        list.add(mUrlList.get(4*position+2));
                                        list.add(mUrlList.get(4*position+3));
                                        intent.putStringArrayListExtra("urlList",list);
                                        intent.putExtra("index",0);
                                        context.startActivity(intent);
                                }
                            }
                        });
                        Glide.with(context).load(mUrlList.get(4*position)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getDorImage());
                    }
                });
    }

    public interface DormitoryApi{

        @GET("apiForGuide.php")
        Observable<Dormitory> getData(@Query ("RequestType") String RequestType);
    }
}
