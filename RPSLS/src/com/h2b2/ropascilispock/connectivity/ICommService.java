package com.h2b2.ropascilispock.connectivity;

import android.app.Activity;

public interface ICommService {
	
	public Activity get_activity();
	public void set_activity(Activity _activity);
	
	/**
	 * Creates a connection handle with the BTCLC library and saves it as a member
	 */
	public void initialize();
	
	/**
	 * Starts the server and listens to incoming connections as per the callback
	 * 
	 * @param maxConnections Max number of connections to accept
	 */
	public void startServer(int maxConnections);
	
	/**
	 * Connect to the given device
	 * 
	 * @param device MAC address of the device to connect to
	 * @throws Exception
	 */
	public void connectDevice(String device) throws Exception;
}
