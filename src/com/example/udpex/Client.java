package com.example.udpex;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.util.Log;

public class Client implements Runnable {
	@Override
	public void run() {
		try {
			// Retrieve the ServerName
			InetAddress serverAddr = InetAddress.getByName(Server.SERVERIP);
			
			Log.d("UDP", "C: Connecting...");
			/* Create new UDP-Socket */
			DatagramSocket socket = new DatagramSocket();
			
			/* Prepare some data to be sent. */
			byte[] buf = ("Hello from hema").getBytes();
			
			/* Create UDP-packet with 
			 * data & destination(url+port) */
			DatagramPacket packet = new DatagramPacket(buf, buf.length,	serverAddr, Server.SERVERPORT);
			Log.d("UDP", "C: Sending: '" + new String(buf) + "'");
			
			/* Send out the packet */
			socket.send(packet);
			Log.d("UDP", "C: Sent.");
			Log.d("UDP", "C: Done.");
		} catch (Exception e) {
			Log.e("UDP", "C: Error", e);
		}
	}
}
