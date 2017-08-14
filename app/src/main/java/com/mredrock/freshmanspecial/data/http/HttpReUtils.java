package com.mredrock.freshmanspecial.data.http;

import com.mredrock.freshmanspecial.data.model.WorkRatio;

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

public class HttpReUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<Float> mWorkRatioList;

    private static List<Float> mUnWorkCourseList;

    public static List<Float> getUnWorkCourseList() {
        if(mUnWorkCourseList == null){
            getFailRatio();
        }
        return mUnWorkCourseList;
    }

    public static List<Float> getWorkRatioList() {
        if(mWorkRatioList == null){
            getFailRatio();
        }
        return mWorkRatioList;
    }

    public static void getFailRatio(){
        mWorkRatioList = new ArrayList<>();
        mWorkRatioList.clear();
        mUnWorkCourseList = new ArrayList<>();
        mWorkRatioList.clear();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WorkRatioApi loginApi = retrofit.create(WorkRatioApi.class);
        Call<WorkRatio> call = loginApi.getData("WorkRatio");
        call.enqueue(new Callback<WorkRatio>() {
            @Override
            public void onResponse(Call<WorkRatio> call, Response<WorkRatio> response) {
                WorkRatio w = response.body();
                for(int i = 0; i < w.getData().size();i++){
                    WorkRatio.DataBean dataBean = w.getData().get(i);
                    mWorkRatioList.add((float) (Math.round(Float.parseFloat(dataBean.getRatio())*100))/100);
                    mUnWorkCourseList.add(1 - (float) (Math.round(Float.parseFloat(dataBean.getRatio())*100))/100);
                }
            }

            @Override
            public void onFailure(Call<WorkRatio> call, Throwable t) {

            }
        });
    }

    public interface WorkRatioApi{

        //FormUrlEncode&POST与Field连用：以表单的方式上传
        @FormUrlEncoded
        @POST ("apiRatio.php")
        Call<WorkRatio> getData(@Field ("RequestType") String requestType);
    }
}
