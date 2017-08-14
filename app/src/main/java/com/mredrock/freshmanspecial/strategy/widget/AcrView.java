package com.mredrock.freshmanspecial.strategy.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.utils.DensityUtils;

/**
 * Created by Grantsome on 2017/8/3.
 */

public class AcrView extends View{

    private float mPercent;

    private float mCurrentPercent;

    private float mCurrentAngle;

    private float mCurrentRadius;

    private float mAngle;

    private int mFillColor;

    private int mBackgroundColor;

    private float mBigRadius;

    private float mGapRadius;

    private float mRadians;

    private Paint mFillPaint = new Paint();

    private Paint mStrokenPaint = new Paint();

    private Paint mBackgroundPaint = new Paint();

    private Paint mWhitePaint = new Paint();

    private Paint mTextPaint = new Paint();

    private Paint mBlackPaint = new Paint();

    private int mScreenWidth = DensityUtils.getScreenWidth();

    private int mScreenHeight = DensityUtils.getScreenHeight();

    private String TAG = "ArcView";

    @Override
    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
    }

    public void setPercent(float percent) {
        mPercent = (float) (Math.round(percent*100))/100;
        mAngle = (float) (mPercent * 0.01 * 360) ;
        mRadians = (float) (mAngle*Math.PI/180);
        setAnimation();
    }

    public void setFillColor(int fillColor) {
        mFillColor = fillColor;
    }

    public void setGapRadius(float gapRadius) {
        mGapRadius = gapRadius;
    }

    public void setBigRadius(float bigRadius) {
        mBigRadius = bigRadius;
    }

    public AcrView(Context context) {
        super(context);
    }

    public AcrView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributeSet(context,attrs);
        initPaint();
        setAnimation();
    }

    public AcrView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttributeSet(context,attrs);
        initPaint();
        setAnimation();
    }

    private void initAttributeSet(Context context,AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.acrView, 0, 0);
        try {
            mPercent = typedArray.getFloat(R.styleable.acrView_percent,0);
            mAngle = (float) (mPercent * 0.01 * 360) ;
            mRadians = (float) (mAngle*Math.PI/180);
            mFillColor = typedArray.getColor(R.styleable.acrView_fillColor, Color.BLUE);
            mBackgroundColor = typedArray.getColor(R.styleable.acrView_backgroundColor,Color.GREEN);
            mBigRadius = typedArray.getFloat(R.styleable.acrView_bigRadius, 100);
            mGapRadius = typedArray.getFloat(R.styleable.acrView_gapRadius, 10);
        }finally {
            typedArray.recycle();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.translate(0,-300);
        super.draw(canvas);
        drawFirstAcr(canvas);
        drawPercent(canvas);
        log("圆弧绘制完成");
    }

    private void initPaint(){
        mFillPaint.setAntiAlias(true);
        mFillPaint.setStyle(Paint.Style.FILL);
        mFillPaint.setColor(mFillColor);
        mFillPaint.setAlpha(203);
        mStrokenPaint.setAntiAlias(true);
        mStrokenPaint.setStyle(Paint.Style.STROKE);
        mStrokenPaint.setColor(mFillColor);
        mBackgroundPaint.setAntiAlias(true);
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setColor(mBackgroundColor);
        mWhitePaint.setAntiAlias(true);
        mWhitePaint.setStyle(Paint.Style.FILL);
        mWhitePaint.setColor(Color.WHITE);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.RED);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setAlpha(101);
        mTextPaint.setTextSize(16);
        mBlackPaint.setAntiAlias(true);
        mBlackPaint.setColor(Color.BLACK);
        mBlackPaint.setStyle(Paint.Style.FILL);
        mBlackPaint.setTextSize(25);
    }

    //画圆环
    private void drawFirstAcr(Canvas canvas){
        Path mFirstPath = new Path();
        RectF mFirstRectF = newRectF(mScreenWidth/2,mScreenHeight/2-(mBigRadius-mGapRadius),mGapRadius);
        mFirstPath.arcTo(mFirstRectF,90,180);
        RectF mSecondRectF = newRectF(mScreenWidth/2,mScreenHeight/2,mBigRadius);
        mFirstPath.arcTo(mSecondRectF,270,mCurrentAngle);
        //RectF mThirdRectF = newRectF((float) (mScreenWidth/2-(mBigRadius-mGapRadius)*Math.cos(mRadians)),(float) (mScreenHeight/2+(mBigRadius-mGapRadius)*Math.sin(mRadians)),mGapRadius);
        RectF mThirdRectF = newRectF((float) (mScreenWidth/2+(mBigRadius-mGapRadius)*Math.sin(mCurrentRadius)),(float) (mScreenHeight/2-(mBigRadius-mGapRadius)*Math.cos(mCurrentRadius)),mGapRadius);
        mFirstPath.arcTo(mThirdRectF,270+mCurrentAngle,180);
        RectF mFourthRectF = newRectF(mScreenWidth/2,mScreenHeight/2,mBigRadius-2*mGapRadius);
        mFirstPath.arcTo(mFourthRectF,mCurrentAngle+270,-mCurrentAngle);
        canvas.drawCircle(mScreenWidth/2,mScreenHeight/2,mBigRadius,mBackgroundPaint);
        canvas.drawCircle(mScreenWidth/2,mScreenHeight/2,mBigRadius-2*mGapRadius,mWhitePaint);
        canvas.drawCircle(mScreenWidth/2,mScreenHeight/2,mBigRadius,mStrokenPaint);
        canvas.drawCircle(mScreenWidth/2,mScreenHeight/2,mBigRadius-2*mGapRadius,mStrokenPaint);
        canvas.drawPath(mFirstPath,mFillPaint);
        canvas.drawPath(mFirstPath,mStrokenPaint);
    }

    //画比例
    private void drawPercent(Canvas canvas){
        log(mPercent+"%");
        canvas.drawText(mPercent+"%",mScreenWidth/2-70,mScreenHeight/2-(mBigRadius-mGapRadius)+15,mTextPaint);
    }

    private RectF newRectF(float centerX,float centerY,float radius){
        return new RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
    }

    private void log(String message){
        Log.d(TAG,message);
    }

    private void setAnimation(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < Math.min(mPercent,0.9*100);i++){
                    try{
                        Thread.sleep(20);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    mCurrentPercent = i;
                    mCurrentAngle = (float) (mCurrentPercent * 0.01 * 360);
                    mCurrentRadius = (float) (mCurrentAngle*Math.PI/180);
                    AcrView.this.postInvalidate();
                    Log.d(TAG, "run: setAnimation: 完成");
                }
            }
        }).start();
    }

}
