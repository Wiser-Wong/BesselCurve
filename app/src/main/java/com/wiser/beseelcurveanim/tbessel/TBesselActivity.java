package com.wiser.beseelcurveanim.tbessel;

import com.wiser.beseelcurveanim.R;
import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;
import com.wiser.library.helper.WISERHelper;

import android.content.Intent;

/**
 * @author Wiser
 */
public class TBesselActivity extends WISERActivity {

	public static void intent() {
		WISERHelper.display().intent(TBesselActivity.class);
	}

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.thrid_beseel_act);
		return wiserBuilder;
	}

	@Override protected void initData(Intent intent) {

	}
}
