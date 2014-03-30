package com.h2b2.ropascilispock;

import java.util.HashSet;
import java.util.Set;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class Conn {
	BluetoothAdapter cBluetoothAdapter = null;
	MainActivity cActivity = null;
	Set<BluetoothDevice> cBluetoothDevicesSet = null;
	
	// Create a BroadcastReceiver for ACTION_FOUND for discovery
	@SuppressLint("ShowToast")
	private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// When discovery finds a device
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				// Get the BluetoothDevice object from the Intent
				BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				// Add the name and address to an array adapter to show in a ListView
	            cBluetoothDevicesSet.add(device);
	            Toast.makeText(cActivity.getApplicationContext(),"Found device : " + device.getName(), Toast.LENGTH_SHORT);
	        }
	    }
	};

	public Conn(MainActivity mActivity)
	{
		cActivity = mActivity;
		cBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (cBluetoothAdapter == null)
		{
			//Device does not support bluetooth
			//TODO throw error
		}
		// Register the BroadcastReceiver
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		cActivity.registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy
		
		cBluetoothDevicesSet = new HashSet<BluetoothDevice>();
		Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
		cActivity.startActivity(discoverableIntent);
	}

	@SuppressLint("ShowToast")
	public Set<BluetoothDevice> discover()
	{
		cBluetoothAdapter.startDiscovery();
		Toast.makeText(cActivity.getApplicationContext(), "Bluetooth Discovery Started", Toast.LENGTH_SHORT).show();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			Toast.makeText(cActivity.getApplicationContext(),"Sleep interrupted : " + e.getMessage(), Toast.LENGTH_SHORT);
			e.printStackTrace();
		}
		return cBluetoothDevicesSet;
	}

	@Override
	protected void finalize() throws Throwable {
		cActivity.unregisterReceiver(mReceiver);
		super.finalize();
	}
	
	
}
