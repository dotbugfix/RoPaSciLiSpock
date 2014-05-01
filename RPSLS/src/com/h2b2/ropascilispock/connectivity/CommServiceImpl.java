package com.h2b2.ropascilispock.connectivity;

import net.clc.bt.Connection;
import net.clc.bt.Connection.OnConnectionLostListener;
import net.clc.bt.Connection.OnConnectionServiceReadyListener;
import net.clc.bt.Connection.OnIncomingConnectionListener;
import net.clc.bt.Connection.OnMaxConnectionsReachedListener;
import net.clc.bt.Connection.OnMessageReceivedListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import android.app.Activity;

import com.h2b2.ropascilispock.MainActivity;

/**
 * Implementation of the @ICommService interface, using the BTCLC library
 * as an abstraction over Bluetooth
 */
public class CommServiceImpl implements ICommService {

	/**
	 * Internal logger instance for this class
	 */
	private static final Logger _logger = LoggerFactory
			.getLogger(MainActivity.class);

	/**
	 * Handle to the BTCLC connection object
	 */
	private Connection _connection = null; // Wait to init till we get the
											// ApplicationContext

	/**
	 * Reference to the MainActiity
	 */
	Activity _activity = null;

	public Activity get_activity() {
		return _activity;
	}

	public void set_activity(Activity _activity) {
		this._activity = _activity;
	}

	/**
	 * Listener used by the BTCLC connection handle
	 */
	private OnMessageReceivedListener _dataReceivedListener = new OnMessageReceivedListener() {
		public void OnMessageReceived(String device, String message) {
			_logger.info(
					"Comm module received message: [{}] from device: [{}]",
					message, device);
		}
	};

	/**
	 * Listener used by the BTCLC connection handle
	 */
	private OnMaxConnectionsReachedListener _maxConnectionsListener = new OnMaxConnectionsReachedListener() {
		public void OnMaxConnectionsReached() {

		}
	};

	/**
	 * Listener used by the BTCLC connection handle
	 */
	private OnIncomingConnectionListener _connectedListener = new OnIncomingConnectionListener() {
		public void OnIncomingConnection(String device) {
			_logger.info(
					"Comm module received incoming connection from device: [{}]",
					device);
		}
	};

	/**
	 * Listener used by the BTCLC connection handle
	 */
	private OnConnectionLostListener _disconnectedListener = new OnConnectionLostListener() {
		public void OnConnectionLost(String device) {
			_logger.info("Comm module lost connection with device: [{}]",
					device);
		}
	};

	/**
	 * Listener used by the BTCLC connection handle
	 */
	private OnConnectionServiceReadyListener _serviceReadyListener = new OnConnectionServiceReadyListener() {
		public void OnConnectionServiceReady() {
			_logger.info("Comm module ConnectionService is ready!");
		}
	};

	/**
	 * Constructor that saves an instance of the @MainActivity as a member
	 */
	public CommServiceImpl(Activity activity) {
		_logger.info("Creating an instance of the CommServiceImpl...");
		/* Save the reference to MainActivity */
		_activity = activity;		
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void initialize() {
		/* Instantiate the BTCLC connection handle */
		_connection = new Connection(_activity.getApplicationContext(),
				_serviceReadyListener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void startServer(int maxConnections) {
		_logger.info("Starting Comm Server...");
		try {
			_connection.startServer(maxConnections, _connectedListener,
					_maxConnectionsListener, _dataReceivedListener,
					_disconnectedListener);
		} catch (Exception ex) {
			_logger.error("Failed to start server: ", ex);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void connectDevice(String device) throws Exception {
		_logger.info("Connecting to device: [{}]", device);
		try {
			Integer status = _connection.connect(device, _dataReceivedListener, _disconnectedListener);
			if (status != Connection.SUCCESS) {
				throw new Exception("Connection status was returned to be: " + status.toString());
			} else {
				_logger.info("Successfully connected to device: [{}]", device);
			}
		} catch (Exception ex) {
			_logger.error("Failed to connect to device [{}]", device);
			_logger.error("EXCEPTION OCCURED", ex);
			throw ex;
		}
	}
}
