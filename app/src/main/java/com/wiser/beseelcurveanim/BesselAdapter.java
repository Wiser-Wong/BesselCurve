package com.wiser.beseelcurveanim;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wiser.beseelcurveanim.sbessel.SBesselActivity;
import com.wiser.beseelcurveanim.tbessel.TBesselActivity;
import com.wiser.library.adapter.WISERHolder;
import com.wiser.library.adapter.WISERRVAdapter;
import com.wiser.library.base.WISERActivity;

import butterknife.BindView;

/**
 * @author Wiser
 */
public class BesselAdapter extends WISERRVAdapter<BesselModel, BesselAdapter.HomeHolder> {

	public BesselAdapter(WISERActivity mWiserActivity) {
		super(mWiserActivity);
	}

	@Override public HomeHolder newViewHolder(ViewGroup viewGroup, int i) {
		return new HomeHolder(inflate(viewGroup, R.layout.home_item));
	}

	public class HomeHolder extends WISERHolder<BesselModel> {

		@BindView(R.id.tv_select_bessel) TextView tvSelectBessel;

		public HomeHolder(@NonNull View itemView) {
			super(itemView);
		}

		@Override public void bindData(final BesselModel model, int i) {
			if (model == null) return;
			tvSelectBessel.setText(model.text == null ? "" : model.text);
			itemView.setOnClickListener(new View.OnClickListener() {

				@Override public void onClick(View v) {
					switch (model.type) {
						case BesselType.S_BESSEL:
							SBesselActivity.intent();
							break;
						case BesselType.T_BESSEL:
							TBesselActivity.intent();
							break;
					}
				}
			});
		}

	}
}
