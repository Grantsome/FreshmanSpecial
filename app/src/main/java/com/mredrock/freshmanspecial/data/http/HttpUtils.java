package com.mredrock.freshmanspecial.data.http;

import android.util.Log;

import com.mredrock.freshmanspecial.data.model.SexRatio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Grantsome on 2017/8/11.
 */

public class HttpUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mCollegeList;

    private static List<Float> mMenRatioFloatList;

    private static List<Float> mWomenRatioFloatList;

    public static void getRatio(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SexRatioApi loginApi = retrofit.create(SexRatioApi.class);
        Call<SexRatio> call = loginApi.getData("SexRatio");
        call.enqueue(new Callback<SexRatio>() {
            @Override
            public void onResponse(Call<SexRatio> call,Response<SexRatio> response) {
                SexRatio s = response.body();
                if(s!=null){
                    mCollegeList = new ArrayList<>();
                    mMenRatioFloatList = new ArrayList<>();
                    mWomenRatioFloatList = new ArrayList<>();
                    for(int i = 0;i < 16; i++){
                        SexRatio.DataBean mDataBean = s.getData().get(i);
                        mCollegeList.add(mDataBean.getCollege());
                        mMenRatioFloatList.add((float) (Math.round(Float.parseFloat(mDataBean.getMenRatio())*100))/100);
                        mWomenRatioFloatList.add((float) (Math.round(Float.parseFloat(mDataBean.getWomenRatio())*100))/100);
                        Log.d("Httptils", "for循环: "+i);
                    }
                }
                Log.d("Httptils", "onResponse: "+mCollegeList.size()+"第15个为"+mCollegeList.get(14));
                Log.d("Httptils", "onResponse: "+response.body().toString());
            }

            @Override
            public void onFailure(Call<SexRatio> call, Throwable t) {

            }
        });

    }

    public static List<String> getmCollegeList() {
        if(null == mCollegeList){
            getRatio();
        }
        return mCollegeList;
    }

    public static List<Float> getmMenRatioFloatList() {
        if(null == mMenRatioFloatList){
            getRatio();
        }
        return mMenRatioFloatList;
    }

    public static List<Float> getmWomenRatioFloatList() {
        if(mWomenRatioFloatList == null){
            getRatio();
        }
        return mWomenRatioFloatList;
    }

    public interface SexRatioApi{

        //FormUrlEncode&POST与Field连用：以表单的方式上传
        @FormUrlEncoded
        @POST ("apiRatio.php")
        Call<SexRatio> getData(@Field ("RequestType") String requestType);
    }



}
