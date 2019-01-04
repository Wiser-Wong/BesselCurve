package com.wiser.beseelcurveanim.sbessel;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/**
 * @author Wiser
 *
 *         贝塞尔曲线轨迹计算
 */
public class SBesselTypeEvaluator implements TypeEvaluator<Point> {

	private Point point;

	public SBesselTypeEvaluator(Point point) {
		this.point = point;
	}

	@Override public Point evaluate(float fraction, Point startValue, Point endValue) {
		// 二阶贝塞尔曲线
		int x = (int) ((1 - fraction) * (1 - fraction) * startValue.x + 2 * fraction * (1 - fraction) * point.x + fraction * fraction * endValue.x);
		int y = (int) ((1 - fraction) * (1 - fraction) * startValue.y + 2 * fraction * (1 - fraction) * point.y + fraction * fraction * endValue.y);
		return new Point(x, y);
	}
}
