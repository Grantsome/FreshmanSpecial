package com.mredrock.freshmanspecial.strategy.http;

import android.util.Log;

import com.mredrock.freshmanspecial.strategy.model.QQGroup;

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
 * Created by Grantsome on 2017/8/12.
 */

public class HttpUtils {

    public static final String BASE_URL = "http://www.yangruixin.com/test/";

    private static List<String> mGroupNameList  = new ArrayList<>();

    private static List<Integer> mGroupNumberList = new ArrayList<>();

    private static List<String> dbData  = new ArrayList<>();

    private static QQGroup mQQGroup;

    public static List<String> getRatio(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QQGroupApi loginApi = retrofit.create(QQGroupApi.class);
        Call<QQGroup> call = loginApi.getData("QQGroup");
        call.enqueue(new Callback<QQGroup>() {
            @Override
            public void onResponse(Call<QQGroup> call,Response<QQGroup> response) {
                mQQGroup = response.body();
                Log.d("HttpUtils", "onResponse: 获取Group对象成功");
                if(mQQGroup!=null){
                    Log.d("HttpUtils", "内容为"+mQQGroup.toString());
                    for(int i = 0;i < mQQGroup.getData().size();i++){
                        QQGroup.DataBean dataBean = mQQGroup.getData().get(i);
                        mGroupNameList.add(dataBean.getGroupName());
                        mGroupNumberList.add((Integer.parseInt(dataBean.getNumber())));
                        dbData.add(mGroupNameList.get(i)+mGroupNumberList.get(i));
                    }
                    Log.d("HttpUtils", "onResponse: 列表创建完成"+mGroupNameList.size());
                }
            }

            @Override
            public void onFailure(Call<QQGroup> call, Throwable t) {

            }
        });
        Log.d("HttpUtils", "getRatio: 返回的列表大小"+dbData.size());
        return dbData;
    }


    public interface QQGroupApi{

        //FormUrlEncode&POST与Field连用
        @FormUrlEncoded
        @POST ("apiRatio.php")
        Call<QQGroup> getData(@Field ("RequestType") String requestType);
    }


}
