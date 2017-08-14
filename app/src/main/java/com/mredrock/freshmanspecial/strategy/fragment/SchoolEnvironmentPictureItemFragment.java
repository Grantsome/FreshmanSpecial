package com.mredrock.freshmanspecial.strategy.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.activity.ImageDetailActivity;
import com.mredrock.freshmanspecial.strategy.widget.TransformImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Grantsome on 2017/8/4.
 */

public class SchoolEnvironmentPictureItemFragment extends Fragment{

    @Bind (R.id.school_transform_image)
    TransformImageView mTransformImage;

    @Bind(R.id.fraction)
    TextView mFraction;

    private static Rect mBound;//需要实例化

    private static String mUrl;

    private static int position;

    private static int size;

    private Activity mActivity = new ImageDetailActivity();

    public static SchoolEnvironmentPictureItemFragment newInstance(Rect bound, String url,int mPosition,int mSize){
        Bundle bundle = new Bundle();
        bundle.putParcelable("bound",bound);
        mBound = bound;
        bundle.putString("url",url);
        mUrl = url;
        position = mPosition+1;
        size = mSize;
        SchoolEnvironmentPictureItemFragment fragment = new SchoolEnvironmentPictureItemFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public SchoolEnvironmentPictureItemFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_2017_fragment_school_picture_item, container, false);
        ButterKnife.bind(this,view);
        mActivity = getActivity();
        mTransformImage.setVisibility(View.VISIBLE);
        mFraction.setVisibility(View.VISIBLE);
        mFraction.setText(position+"/"+size);
        Log.d("PicItem", "onCreateView: "+mFraction.getText());
        mTransformImage.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float v, float v1) {
                try {

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        mTransformImage.setMinimumScale(0.5f);
        Log.d("ImageDetailActivity", "onCreateView: 要显示的图片url为"+mUrl);
        Glide.with(getActivity()).load(mUrl).into(mTransformImage);
        mTransformImage.bringToFront();
        mTransformImage.setTransformEnabled(true);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void transformIn(TransformImageView.onTransformListener listener){
        mTransformImage.transformIn(mBound,listener);
    }

    public void transformOut(TransformImageView.onTransformListener listener){
        mTransformImage.transformOut(mBound,listener);
    }

}
