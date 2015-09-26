package com.wideatech.location.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.wideatech.location.R;


public class SlidingMenuRightFragment extends PreferenceFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);

		// Load the preferences from an XML resource
		// addPreferencesFromResource(R.);

		// ArrowPreference arrowPreference = (ArrowPreference)
		// getPreferenceScreen().findPreference("arrowItem");

		// arrowPreference.setListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// Log.i("hatcher", "打开另一个activity");
		// }
		// });
	}

	
}
