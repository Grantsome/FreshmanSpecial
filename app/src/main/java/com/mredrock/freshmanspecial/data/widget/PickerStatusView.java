package com.mredrock.freshmanspecial.data.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.View;

import com.mredrock.freshmanspecial.R;
import com.mredrock.freshmanspecial.strategy.utils.DensityUtils;

/**
 * Created by Grantsome on 2017/8/9.
 */

public class PickerStatusView extends View {

    private String text;

    private Paint mLongPaint;

    private Paint mCirclePaint;

    private Paint mWritePaint;

    private int mScreenWidth = DensityUtils.getScreenWidth();

    private int mScreenHeight = DensityUtils.getScreenHeight();

    Path mPath = new Path();

    float x = (float) (mScreenWidth*0.1);

    float y = (float) (mScreenHeight*0.1);

    float r = (float) (mScreenWidth*0.05);

    float w = (float) (mScreenWidth*0.8);

    public PickerStatusView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        initPaint();
    }

    public PickerStatusView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        initPaint();
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PickerStatusView, 0, 0);
        try {
            text = typedArray.getString(R.styleable.PickerStatusView_text);
        }catch (Exception e){
            text = "请选择学院";
        }finally {
            typedArray.recycle();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.translate(0,-60);
        super.draw(canvas);
        drawLong(canvas);
        drawText(canvas);
        drawCircle(canvas);
    }

    private void initPaint(){
        mLongPaint = new Paint();
        mLongPaint.setAntiAlias(true);
        mLongPaint.setColor(getResources().getColor(R.color.colorPaintLong));
        mLongPaint.setAlpha(101);
        mLongPaint.setStyle(Paint.Style.FILL);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(getResources().getColor(R.color.colorTheme));
        mCirclePaint.setAlpha(203);
        mWritePaint = new Paint();
        mWritePaint.setTextSize(30);
        mWritePaint.setAntiAlias(true);
        mWritePaint.setColor(getResources().getColor(R.color.colorPaintWrite));
        mWritePaint.setStyle(Paint.Style.FILL);
    }

    private void drawLong(Canvas canvas){
        RectF mFirstRectF = newRectF(x,y,r);
        mPath.arcTo(mFirstRectF,90,180);
        canvas.drawPath(mPath,mLongPaint);
        canvas.drawLine(x,y-r,x+w,y-r,mLongPaint);
        RectF mSecondRectF = newRectF(x+w,y,r);
        Path path = new Path();
        path.addArc(mSecondRectF,270,180);
        canvas.drawPath(path,mLongPaint);
        canvas.drawLine(x+w,y+r,x,y+r,mLongPaint);
    }

    private void drawCircle(Canvas canvas){
        canvas.drawCircle(x+w,y,r,mCirclePaint);
        Bitmap bitmap = getBitmapFromVectorDrawable();
        canvas.drawBitmap(bitmap,(float) (x+w-0.6*r),(float) (y-0.6*r),mCirclePaint);
    }

    private void drawText(Canvas canvas){
        canvas.drawText(text,(float) (x+0.5*r),(float) (y+0.2*r),mWritePaint);
    }

    private RectF newRectF(float centerX,float centerY,float radius){
        return new RectF(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
    }

    private Bitmap getBitmapFromVectorDrawable() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_white_24dp);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

}
