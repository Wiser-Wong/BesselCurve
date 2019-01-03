package com.wiser.beseelcurveanim;

import com.wiser.library.base.WISERBiz;

import java.util.ArrayList;
import java.util.List;

public class HomeBiz extends WISERBiz<HomeActivity> {

	public void setData() {
		List<BesselModel> besselModels = new ArrayList<>();
		BesselModel besselModel1 = new BesselModel(BesselType.S_BESSEL, "二阶贝塞尔曲线");
		BesselModel besselModel2 = new BesselModel(BesselType.T_BESSEL, "三阶贝塞尔曲线");
		besselModels.add(besselModel1);
		besselModels.add(besselModel2);
		ui().setItems(besselModels);
	}

}
