package com.wiser.beseelcurveanim.sbessel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * @author Wiser
 * 
 *         球自定义控件 加贝塞尔动画
 */
public class StartImageView extends AppCompatImageView implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

	private Paint	paint		= new Paint(Paint.ANTI_ALIAS_FLAG);

	private int		radius		= 30;

	private boolean	isRunning	= false;

	public StartImageView(Context context, AttributeSet attrs) {
		super(context, attrs);

		paint.setColor(Color.RED);

	}

	@Override protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawCircle(radius, radius, radius, paint);
	}

	@Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);

		int width = 0;
		int height = 0;

		switch (widthMode) {
			case MeasureSpec.EXACTLY:
			case MeasureSpec.AT_MOST:
				width = 2 * radius;
				break;
			case MeasureSpec.UNSPECIFIED:
				width = widthSize;
				break;
		}

		switch (heightMode) {
			case MeasureSpec.EXACTLY:
			case MeasureSpec.AT_MOST:
				height = 2 * radius;
				break;
			case MeasureSpec.UNSPECIFIED:
				height = heightSize;
				break;
		}
		setMeasuredDimension(width, height);
	}

	public void startAnim(Point startPoint, Point endPoint) {
		if (isRunning) return;
		isRunning = true;
		int pointX = (startPoint.x + endPoint.x) / 2;
		int pointY = startPoint.y - PointUtil.dip2px(getContext(), 40);
		Point controlPoint = new Point(pointX, pointY);
		ValueAnimator animator = ValueAnimator.ofObject(new SBesselTypeEvaluator(controlPoint), startPoint, endPoint).setDuration(2000);
		animator.addUpdateListener(this);
		animator.addListener(this);
		animator.start();
	}

	@Override public void onAnimationUpdate(ValueAnimator animation) {
		Point point = (Point) animation.getAnimatedValue();
		setX(point.x);
		setY(point.y);
		invalidate();
	}

	@Override public void onAnimationStart(Animator animation) {

	}

	@Override public void onAnimationEnd(Animator animation) {
		animation.cancel();
		ViewGroup viewGroup = (ViewGroup) getParent();
		viewGroup.removeView(this);
		isRunning = false;
	}

	@Override public void onAnimationCancel(Animator animation) {

	}

	@Override public void onAnimationRepeat(Animator animation) {

	}
}
