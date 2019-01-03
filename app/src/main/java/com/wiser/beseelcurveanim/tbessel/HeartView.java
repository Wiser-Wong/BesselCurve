package com.wiser.beseelcurveanim.tbessel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.util.Random;

public class HeartView extends AppCompatImageView {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int colors[] = new int[]{Color.BLUE, Color.RED, Color.GREEN};

    private Random mRandom = new Random();

    private float width = 100;
    private float height = 130;

    public HeartView(Context context) {
        super(context);
        init();
    }

    public HeartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint.setColor(colors[mRandom.nextInt(colors.length)]);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
    }

    public float heartWidth() {
        return width;
    }

    public float heartHeight() {
        return height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.TRANSPARENT);

        Path pathLeft = new Path();
        pathLeft.moveTo(width / 2, height / 4);
        pathLeft.cubicTo(width / 7, height / 9, width / 13, (height * 2) / 5, width / 2, (height * 7) / 12);
        canvas.drawPath(pathLeft, paint);

        Path pathRight = new Path();
        pathRight.moveTo(width / 2, height / 4);
        pathRight.cubicTo((width * 6) / 7, height / 9, (width * 12) / 13, (height * 2) / 5, width / 2, (height * 7) / 12);
        canvas.drawPath(pathRight, paint);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                width = (int) this.width;
                break;
            case MeasureSpec.UNSPECIFIED:
                width = widthSize;
                break;
        }
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                height = (int) this.height;
                break;
            case MeasureSpec.UNSPECIFIED:
                height = heightSize;
                break;
        }

        setMeasuredDimension(width, height);
    }
}
