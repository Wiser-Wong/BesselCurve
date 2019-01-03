package com.wiser.beseelcurveanim.sbessel;

import android.animation.TypeEvaluator;

public class SBesselTypeEvaluator implements TypeEvaluator<ControlPoint> {
    private ControlPoint point;

    public SBesselTypeEvaluator(ControlPoint point) {
        this.point = point;
    }

    @Override
    public ControlPoint evaluate(float fraction, ControlPoint startValue, ControlPoint endValue) {
        //二阶贝塞尔曲线
        float x = (1 - fraction) * (1 - fraction) * startValue.x + 2 * fraction * (1 - fraction) * point.x + fraction * fraction * endValue.x;
        float y = (1 - fraction) * (1 - fraction) * startValue.y + 2 * fraction * (1 - fraction) * point.y + fraction * fraction * endValue.y;
        return new ControlPoint(x, y);
    }
}
