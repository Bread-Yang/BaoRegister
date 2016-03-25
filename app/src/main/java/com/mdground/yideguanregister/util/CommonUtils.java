package com.mdground.yideguanregister.util;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

import com.mdground.yideguanregister.R;

public class CommonUtils {

	public static void showPageTab(Resources resources,TextView showTab, View showView,
			TextView hiddenOneTab, View hiddenOneView, TextView hiddenTwoTab,
			View hiddenTwoView, TextView hiddenThreeTab,
			View hiddenThreeView) {
		
		showTab.setTextColor(resources.getColor(R.color.color_237ef3));
		showView.setVisibility(View.VISIBLE);
		
		hiddenOneTab.setTextColor(resources.getColor(R.color.color_374043));
		hiddenOneView.setVisibility(View.INVISIBLE);
		hiddenTwoTab.setTextColor(resources.getColor(R.color.color_374043));
		hiddenTwoView.setVisibility(View.INVISIBLE);
		hiddenThreeTab.setTextColor(resources.getColor(R.color.color_374043));
		hiddenThreeView.setVisibility(View.INVISIBLE);
	}

}
