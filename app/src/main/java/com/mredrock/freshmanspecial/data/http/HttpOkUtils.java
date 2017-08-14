package com.mredrock.freshmanspecial.data.http;

import android.util.Log;

import com.mredrock.freshmanspecial.data.model.FailRatio;

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

public class HttpOkUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mCollegeList;

    private static List<String> mMajorList;

    private static List<Float> mRatioList;

    private static List<String> mCourseList;

    private static FailRatio mFailRatio;

    public static List<String> getMajorList(String college) {
        mMajorList = new ArrayList<>();
        mMajorList.clear();
        getFailRatio(college,null);
        return mMajorList;
    }

//    public static List<Float> getRatioList(String college,String major) {
//        if(null == mRatioList){
//            mRatioList = new ArrayList<>();
//            mRatioList.clear();
//            getFailRatio(college,major);
//        }
//        Log.d("HttpOkUtils", "getRatioList: "+mRatioList.size());
//        return mRatioList;
//    }

    public static List<String> getCollegeList() {
        if(null == mCollegeList){
            mCollegeList = HttpUtils.getmCollegeList();
        }
        return mCollegeList;

   }

    public static List<String> getCourseList(String college,String major){
        if(mFailRatio == null){
            getFailRatio(college,null);
        }
        if(null != mFailRatio){
            mCourseList = new ArrayList<>();
            int count = 0;
            for(int i = 0;i < mFailRatio.getData().size();i++){
                FailRatio.DataBean dataBean = mFailRatio.getData().get(i);
                if(college.equals(dataBean.getCollege())){
                    Log.d("HttpOkUtils", "进入第一层if");
                    if(major.equals(dataBean.getMajor())){
                        count++;
                        Log.d("HttpOkUtils", "addList: "+count);
                        mCourseList.add(dataBean.getCourse());
                    }
                }
            }
        }
        return mCourseList;
    }

    public static List<Float> getRatioList(String college,String major){
        if(mFailRatio == null){
            getFailRatio(college,null);
        }
        if(null != mFailRatio){
            mRatioList = new ArrayList<>();
            int count = 0;
            for(int i = 0;i < mFailRatio.getData().size();i++){
                FailRatio.DataBean dataBean = mFailRatio.getData().get(i);
                if(college.equals(dataBean.getCollege())){
                    Log.d("HttpOkUtils", "进入第一层if");
                    if(major.equals(dataBean.getMajor())){
                        count++;
                        Log.d("HttpOkUtils", "addList: "+count);
                        mRatioList.add((float) (Math.round(Float.parseFloat(dataBean.getRatio())*100))/100);
                    }
                }
            }
        }
        return mRatioList;
    }



    public static void getFailRatio(final String college,final String major){

        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        FailRatioApi loginApi = retrofit.create(FailRatioApi.class);
        Call<FailRatio> call = loginApi.getData("FailRatio");
        call.enqueue(new Callback<FailRatio>() {
            @Override
            public void onResponse(Call<FailRatio> call, Response<FailRatio> response) {
                FailRatio f = response.body();
                mFailRatio = f;
                int count = 0;
                if(null != f){
                    for(int i = 0;i < f.getData().size();i++){
                        FailRatio.DataBean dataBean = f.getData().get(i);
                        if(null == major){
                            if(college.equals(dataBean.getCollege())){
                                if(mMajorList.contains(dataBean.getMajor())){

                                }else {
                                    mMajorList.add(dataBean.getMajor());
                                    count++;
                                    Log.d("HttpOkUtils", "onResponse: "+count);
                                }
                            }
                        }else {
                            if(college.equals(dataBean.getCollege())){
                                Log.d("HttpOkUtils", "进入第一层if");
                                if(major.equals(dataBean.getMajor())){
                                    count++;
                                    Log.d("HttpOkUtils", "addList: "+count);
                                    mRatioList.add((float) (Math.round(Float.parseFloat(dataBean.getRatio())*100))/100);
                                    mCourseList.add(dataBean.getCourse());
                                }
                            }
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<FailRatio> call, Throwable t) {

            }
        });
    }

    public interface FailRatioApi{

        @FormUrlEncoded
        @POST("apiRatio.php")
        Call<FailRatio> getData(@Field("RequestType") String requestType);
    }
}
