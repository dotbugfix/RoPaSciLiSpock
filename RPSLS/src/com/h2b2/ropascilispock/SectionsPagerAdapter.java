package com.h2b2.ropascilispock;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.h2b2.ropascilispock.MainActivity.PlaceholderFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

	private Activity cActivityInstance;
	
	public Activity getcActivityInstance() {
		return cActivityInstance;
	}

	public void setcActivityInstance(Activity cActivityInstance) {
		this.cActivityInstance = cActivityInstance;
	}

	public SectionsPagerAdapter( FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class
		// below).
		
		switch(position) {
		case 0:
			return new ConnectTabFragment();
		case 1:
			return new PlayTabFragment();
		default:
			return PlaceholderFragment.newInstance(position + 1);
		}
		
	}

	@Override
	public int getCount() {
		// Show 3 total pages.
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		Locale l = Locale.getDefault();
		switch (position) {
		case 0:
			return cActivityInstance.getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return cActivityInstance.getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return cActivityInstance.getString(R.string.title_section3).toUpperCase(l);
		}
		return null;
	}
}
