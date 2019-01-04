package com.wiser.beseelcurveanim;

import com.wiser.library.base.WISERActivity;
import com.wiser.library.base.WISERBuilder;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;

/**
 * @author Wiser
 */
public class HomeActivity extends WISERActivity<HomeBiz> {

	@Override protected WISERBuilder build(WISERBuilder wiserBuilder) {
		wiserBuilder.layoutId(R.layout.home_act);
		wiserBuilder.recycleView().recycleViewId(R.id.rlv_bessel);
		wiserBuilder.recycleView().recycleViewLinearManager(LinearLayoutManager.VERTICAL, true, null);
		wiserBuilder.recycleView().recycleAdapter(new BesselAdapter(this));
		return wiserBuilder;
	}

	@Override protected void initData(Intent intent) {
		biz().setData();
	}
}
