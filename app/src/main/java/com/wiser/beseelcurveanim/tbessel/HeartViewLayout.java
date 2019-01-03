package com.wiser.beseelcurveanim.tbessel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.wiser.beseelcurveanim.sbessel.ControlPoint;

import java.util.Random;

public class HeartViewLayout extends FrameLayout implements View.OnTouchListener {

    private Random mRandom = new Random();

    public HeartViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    private void addHeartView(Point point) {
        HeartView heartView = new HeartView(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.leftMargin = (int) (point.x - heartView.heartWidth() / 2);
        params.topMargin = (int) (point.y - heartView.heartHeight() / 2);
        addView(heartView, params);
        AnimatorSet animatorSet = objectAnimator(heartView, point);
        animatorSet.start();
    }

    private AnimatorSet objectAnimator(HeartView heartView, Point point) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(heartView, "scaleX", 0.2f, 1.5f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(heartView, "scaleY", 0.2f, 1.5f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(heartView, "alpha", 0.2f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY, alpha);
        animatorSet.setDuration(500);

        ValueAnimator valueAnimator = valueAnimator(point, heartView);
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(animatorSet, valueAnimator);
        set.setTarget(heartView);
        return set;
    }

    private ValueAnimator valueAnimator(Point point, final HeartView heartView) {
        Point startPoint = new Point((int) (point.x - heartView.heartWidth() / 2), (int) (point.y - heartView.heartHeight() / 2));
        Point endPoint = new Point(mRandom.nextInt(getMeasuredWidth()), 0);
        Point point1 = new Point(mRandom.nextInt(getMeasuredWidth()), point.y / 2 + mRandom.nextInt(point.y / 2));
        Point point2 = new Point(mRandom.nextInt(getMeasuredWidth()), mRandom.nextInt(point.y / 2));
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new TBesselTypeEvaluator(point1, point2), startPoint, endPoint);
        valueAnimator.setDuration(3000);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animation.cancel();
                removeView(heartView);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                heartView.setX(point.x);
                heartView.setY(point.y);
                heartView.setAlpha(1 - animation.getAnimatedFraction());
            }
        });
        return valueAnimator;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            Point point = new Point();
            point.x = (int) event.getX();
            point.y = (int) event.getY();
            addHeartView(point);
        }
        return true;
    }
}
