package com.h2b2.ropascilispock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.h2b2.ropascilispock.connectivity.CommServiceImpl;
import com.h2b2.ropascilispock.connectivity.ICommService;
import com.h2b2.ropascilispock.game.GameplayImpl;
import com.h2b2.ropascilispock.game.IGameplay;

/**
 * Main activity for the application
 * Creates the TabView, adds tabs and initializes @IGameplay and @ICommService
 * Also defines a generic event handler for all button clicks in the app; routed to the 
 * appropriate Fragment
 */
public class MainActivity extends Activity implements ActionBar.TabListener {

	/**
	 * Internal logger instance for this class
	 */
	private static final Logger _logger = LoggerFactory
			.getLogger(MainActivity.class);

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v13.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter _sectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	/**
	 * The Gameplay object
	 */
	IGameplay _gameplay;

	public IGameplay get_gameplay() {
		return _gameplay;
	}

	public void set_gameplay(IGameplay _gameplay) {
		this._gameplay = _gameplay;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		_logger.info("onCreate() called for MainActivity");

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		_logger.info("Setting up the action bar...");
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		_sectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(_sectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		_logger.info("Setting up the setOnPageChangeListener...");
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}

				});

		_logger.info("Setting up tabs...");
		String[] tabs = { "Connect", "Play", "Scoreboard" };
		for (String tabTitle : tabs) {
			ActionBar.Tab tab = actionBar.newTab().setText(tabTitle)
					.setTabListener(this);
			actionBar.addTab(tab);
		}
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		_logger.info("GUI Init complete");

		/* Init the Comm Service */
		_sectionsPagerAdapter.get_connectTabFragment().get_commService()
				.set_activity(this);
		_sectionsPagerAdapter.get_connectTabFragment().get_commService()
				.initialize();

		/* Setup the gameplay */
		_logger.info("Setting up the gameplay...");
		setupGame();

	}

	/**
	 * Generic action listener for all buttons in the GUI Uses the Degalation
	 * Pattern to re-route the call to appropriate handlers in other fragments
	 * 
	 * @param view
	 *            Originating View
	 */
	public void buttonListenerHandler(View view) {
		_logger.info("buttonListenerHandler++ with " + view);

		if (view == findViewById(R.id.buttonStartServer)) {
			_sectionsPagerAdapter.get_connectTabFragment().startServer(view);
		} else if (view == findViewById(R.id.buttonJoinServer)) {
			_sectionsPagerAdapter.get_connectTabFragment().joinServer(view);
		} else if (view == findViewById(R.id.buttonStartTimer)) {
			_sectionsPagerAdapter.get_playTabFragment().resetTimer(view);
		} else if (view == findViewById(R.id.buttonRock)) {
			_sectionsPagerAdapter.get_playTabFragment().playRock(view);
		} else if (view == findViewById(R.id.buttonPaper)) {
			_sectionsPagerAdapter.get_playTabFragment().playPaper(view);
		} else if (view == findViewById(R.id.buttonScissors)) {
			_sectionsPagerAdapter.get_playTabFragment().playScissors(view);
		} else if (view == findViewById(R.id.buttonLizard)) {
			_sectionsPagerAdapter.get_playTabFragment().playLizard(view);
		} else if (view == findViewById(R.id.buttonSpock)) {
			_sectionsPagerAdapter.get_playTabFragment().playSpock(view);
		}

		_logger.info("buttonListenerHandler--");
	}

	/**
	 * Setup and initialize the Gameplay
	 */
	private void setupGame() {
		/* Create a single game instance for now */
		_gameplay = new GameplayImpl(this);
		_logger.info("Single game instance created for MainActivity");

		/* Pass the gameplay instance to the PlayTab fragment */
		_sectionsPagerAdapter.get_playTabFragment().set_gameplay(_gameplay);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// @Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	// @Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	// @Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}
}
