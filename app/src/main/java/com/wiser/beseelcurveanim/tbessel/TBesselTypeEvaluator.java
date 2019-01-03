package com.wiser.beseelcurveanim.tbessel;

import android.animation.TypeEvaluator;
import android.graphics.Point;

public class TBesselTypeEvaluator implements TypeEvaluator<Point> {

    private Point point1;
    private Point point2;

    public TBesselTypeEvaluator(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        //三阶贝塞尔曲线
        int x = (int) (startValue.x * (1 - fraction) * (1 - fraction) * (1 - fraction) + 3 * point1.x * fraction * (1 - fraction) * (1 - fraction) + 3 * point2.x * fraction * fraction * (1 - fraction) + endValue.x * fraction * fraction * fraction);
        int y = (int) (startValue.y * (1 - fraction) * (1 - fraction) * (1 - fraction) + 3 * point1.y * fraction * (1 - fraction) * (1 - fraction) + 3 * point2.y * fraction * fraction * (1 - fraction) + endValue.y * fraction * fraction * fraction);
        return new Point(x, y);
    }
}
