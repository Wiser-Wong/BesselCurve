package com.wiser.beseelcurveanim;

import android.app.Application;

import com.wiser.library.helper.WISERHelper;

/**
 * @author Wiser
 */
public class MApplication extends Application {

	@Override public void onCreate() {
		super.onCreate();
		WISERHelper.newBind().Inject(this, BuildConfig.DEBUG);
	}
}
