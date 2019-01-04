package com.wiser.beseelcurveanim.sbessel;

import com.wiser.beseelcurveanim.R;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.library.helper.WISERHelper;

import android.content.Intent;
import android.graphics.Point;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Wiser
 */
public class SBesselActivity extends WISERActivity {

	@BindView(R.id.iv_start) StartImageView	ivStart;

	@BindView(R.id.iv_end) EndImageView		ivEnd;

	public static void intent() {
		WISERHelper.display().intent(SBesselActivity.class);
	}

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.second_beseel_act);
		return wiserBuilder;
	}

	@Override protected void initData(Intent intent) {

	}

	@OnClick(value = { R.id.iv_start }) public void onClickView(View view) {
		switch (view.getId()) {
			case R.id.iv_start:
				ivStart.startAnim(new Point(PointUtil.pointXY(ivStart, PointUtil.X), (int) ivStart.getY()), new Point(PointUtil.pointXY(ivEnd, PointUtil.X), (int) ivEnd.getY()));
				break;
		}
	}

}
