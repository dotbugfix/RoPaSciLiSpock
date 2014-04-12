package com.h2b2.ropascilispock;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

	/**
	 * Internal logger instance for this class
	 */
	private static final Logger _logger = LoggerFactory.getLogger(SectionsPagerAdapter.class); 
	
	/**
	 * Instance of the parent Activity
	 */
	private Activity _activity;
	
	/**
	 * Instance of the ConnectTab fragment
	 */
	private ConnectTabFragment _connectTabFragment = new ConnectTabFragment();
	
	/**
	 * Instance of the PlayTab fragment
	 */
	private PlayTabFragment _playTabFragment = new PlayTabFragment();
	
	
	public ConnectTabFragment get_connectTabFragment() {
		return _connectTabFragment;
	}

	public PlayTabFragment get_playTabFragment() {
		return _playTabFragment;
	}

	public SectionsPagerAdapter( FragmentManager fm) {
		super(fm);
	}

	/**
	 * Return instances of tabs as requested by the FragmentManager
	 */
	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class
		// below).
		
		switch(position) {
		case 0:
			return _connectTabFragment;
		case 1:
			return _playTabFragment;
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
			return _activity.getString(R.string.title_section1).toUpperCase(l);
		case 1:
			return _activity.getString(R.string.title_section2).toUpperCase(l);
		case 2:
			return _activity.getString(R.string.title_section3).toUpperCase(l);
		}
		return null;
	}
	
	/**
	 * A placeholder fragment containing a simple view.
	 * TODO: Remove this class when no longer used (currently used for tab 3)
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			TextView textView = (TextView) rootView
					.findViewById(R.id.section_label);
			textView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}
}
