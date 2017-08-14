package com.mredrock.freshmanspecial.training.http;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.training.holder.TrainingPictureHolder;
import com.mredrock.freshmanspecial.training.model.TrainingPhoto;

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

public class HttpUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mTitleList = new ArrayList<>();

    private static List<String> mUrlList = new ArrayList<>();

    public static void getPhoto(final Context context, final TrainingPictureHolder holder, final int position){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        PhotoApi api = retrofit.create(PhotoApi.class);
        Observable<TrainingPhoto> observable = api.getData("MilitaryTrainingPhoto");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<TrainingPhoto>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(TrainingPhoto trainingPhoto) {
                        mUrlList.addAll(trainingPhoto.getData().getUrl());
                        mTitleList.addAll(trainingPhoto.getData().getTitle());
                        Glide.with(context).load(mUrlList.get(position)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getFirstTrainImage());
                        Glide.with(context).load(mUrlList.get(position + 1)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getSecondTrainImage());
                        Glide.with(context).load(mUrlList.get(position + 2)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getThirdTrainImage());
                        Glide.with(context).load(mUrlList.get(position + 3)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getFourthTrainImage());
                        Glide.with(context).load(mUrlList.get(position + 4)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getFifthTrainImage());
                        Glide.with(context).load(mUrlList.get(position + 5)).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.getSixTrainImage());
                        holder.setRvItemClick(new TrainingPictureHolder.OnRecyclerViewItemClick() {
                            @Override
                            public void onItemClick(View view) {
                                switch (view.getId()) {
                                    case R.id.training_image_first:
                                        repsonse(context,view, mTitleList.get(position),position);
                                        break;
                                    case R.id.training_image_second:
                                        repsonse(context,view,mTitleList.get(position+1),position+1);
                                        break;
                                    case R.id.training_image_third:
                                        repsonse(context,view,mTitleList.get(position+2),position+2);
                                        break;
                                    case R.id.training_image_fourth:
                                        repsonse(context,view, mTitleList.get(position+3),position+3);
                                        break;
                                    case R.id.training_image_fifth:
                                        repsonse(context,view,mTitleList.get(position+4),position+4);
                                        break;
                                    case R.id.training_image_sixth:
                                        repsonse(context,view, mTitleList.get(position+5),position+5);
                                        break;
                                }
                            }
                        });
                    }
                });
        }

    private static void repsonse(Context context,View view,String desc,int j){
        ArrayList<Rect> mRectList = new ArrayList<Rect>();
        for(int i = 0; i < 1;i++){
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            mRectList.add(rect);
        }
        Intent intent = new Intent(context, ImageDetailActivity.class);
        intent.putParcelableArrayListExtra("rectList",mRectList);
        intent.putExtra("url",mUrlList.get(j));
        intent.putExtra("index",0);
        intent.putExtra("desc",desc);
        context.startActivity(intent);
    }

    public interface PhotoApi{

        @GET ("apiForGuide.php")
        Observable<TrainingPhoto> getData(@Query("RequestType") String requestType);
    }
}
