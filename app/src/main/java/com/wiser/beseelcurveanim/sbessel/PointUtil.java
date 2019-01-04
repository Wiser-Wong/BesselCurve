package com.wiser.beseelcurveanim.sbessel;

import android.content.Context;
import android.view.View;

/**
 * @author Wiser
 * 
 *         点工具
 */
public class PointUtil {

	public static final int	X	= 1;

	public static final int	Y	= 2;

	/**
	 * 计算手指按在屏幕坐标
	 * 
	 * @param view
	 * @param type
	 * @return
	 */
	public static int pointXY(View view, int type) {
		if (view == null) return -1;
		int position[] = new int[2];
		view.getLocationInWindow(position);
		int value = -1;
		switch (type) {
			case X:
				value = position[0];
				break;
			case Y:
				value = position[1];
				break;
			default:
				break;
		}
		return value;
	}

	/**
	 * dip转换成px
	 *
	 * @param dpValue
	 * @return
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
