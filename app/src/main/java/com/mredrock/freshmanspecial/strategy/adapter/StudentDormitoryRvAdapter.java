package com.mredrock.freshmanspecial.strategy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.holder.StudentDormitoryViewHolder;
import com.mredrock.freshmanspecial.strategy.holder.TailViewHolder;
import com.mredrock.freshmanspecial.strategy.http.HttpReUtils;

import java.util.ArrayList;

/**
 * Created by Grantsome on 2017/8/7.
 */

public class StudentDormitoryRvAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ITEM = 0;

    private static final int TYPE_TAIL = 1;

    private ArrayList<Integer> mList;  //Integer需要被替换掉,替换成学生寝室的model

    private Context mContext;

    public StudentDormitoryRvAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getItemViewType(int position){
        if(position != getItemCount()-1){
//              Log.d("StudentDormitoryAdapter", "getItemViewType: if"+TYPE_ITEM);
              return TYPE_ITEM;
        }else {
//            Log.d("StudentDormitoryAdapter", "getItemViewType: else"+TYPE_TAIL);
            return TYPE_TAIL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        int number = 0;
        switch (viewType){
            case TYPE_ITEM:
                StudentDormitoryViewHolder holderTwo = new StudentDormitoryViewHolder(inflater.inflate(R.layout.special_2017_item_student_dormitory,parent,false));
                Log.d("StudentDormitoryAdapter", "onCreateViewHolder: "+number++);
                return holderTwo;
            case TYPE_TAIL:
                final TailViewHolder tailViewHolder = new TailViewHolder(inflater.inflate(R.layout.special_2017_item_school_tail,parent,false));
                tailViewHolder.getLoadText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tailViewHolder.load(StudentDormitoryRvAdapter.this);
                        //也许要添加其他东西
                    }
                });
                return tailViewHolder;
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_ITEM:
                StudentDormitoryViewHolder mHolder = (StudentDormitoryViewHolder) holder;
                HttpReUtils.getDormitroy(mContext,mHolder,position);
                break;
            case TYPE_TAIL:
                ((TailViewHolder) holder).load(StudentDormitoryRvAdapter.this);
                break;
            default:
                break;
        }
    }

    public void refreshRv(){

    }

    @Override
    public int getItemCount() {
        return 4+1;
    }
}
