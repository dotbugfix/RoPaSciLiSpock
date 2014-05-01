package com.h2b2.ropascilispock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.h2b2.ropascilispock.connectivity.CommServiceImpl;
import com.h2b2.ropascilispock.connectivity.ICommService;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ConnectTabFragment extends Fragment {
	
	/**
	 * Internal logger instance for this class
	 */
	private static final Logger _logger = LoggerFactory.getLogger(ConnectTabFragment.class); 
	
	/**
	 * The Communications Service
	 */
	ICommService _commService = new CommServiceImpl(getActivity());

	public ICommService get_commService() {
		return _commService;
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.connect_tab, container, false);

        return rootView;
    }
	
	/**
	 * Tell the Comm Service to start the server
	 * TODO: Pass callback for incoming connections that triggers a GUI update
	 * 
	 * @param view The originating view
	 */
	public void startServer(View view) {
		_logger.info("Starting server...");
		/* Tell the Comm service to start the server with max 1 connection */
		_commService.startServer(1);
	}
	
	/**
	 * Display a list of servers using the @ServerListActivity
	 * This class itself implements the callback, @onActivityResult
	 * 
	 * @param view The originating view
	 */
	public void joinServer(View view) {
		_logger.info("Diaplaying list of available servers...");
		Intent serverListIntent = new Intent(getActivity(), ServerListActivity.class);
        startActivityForResult(serverListIntent, ApplicationConstants.SERVER_LIST_RESULT_CODE);
	}
	
	/**
	 * Callback once the user has selected a server
	 */
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((resultCode == Activity.RESULT_OK) && (requestCode == ApplicationConstants.SERVER_LIST_RESULT_CODE)) {
            _logger.info("Received data from the ServerListActivity intent");
        	String device = data.getStringExtra(ServerListActivity.EXTRA_SELECTED_ADDRESS);
            _logger.debug("Intent data: [{}]", device);
            
            /* Tell the Comm service to connect to the selected device */
            Toast.makeText(getActivity(), "Connecting to device: " + device, Toast.LENGTH_SHORT);
            try {
				_commService.connectDevice(device);
			} catch (Exception e) {
				Toast.makeText(getActivity(), "Could not connect to device: " + device, Toast.LENGTH_SHORT);
				_logger.error("Failed to connect to selected server", e);
				return;
			}
            
            // TODO: If the connection was sucessful, then add this device as a rival to the Gameplay object
            _logger.info("Comm service connected to the device, adding it to the gameplay");
            
            // TODO: Automatically switch to PLAY tab and start the game!
            return;
		}
	}
}
