package com.example.udpex;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
        /* Kickoff the Server, it will
         * be 'listening' for one client packet */
        new Thread(new Server()).start();
        /* GIve the Server some time for startup */
		
		// new Thread(new SinpleUDPServer()).start();
	
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) { }
		
        // Kickoff the Client
      new Thread(new Client()).start();
        
       
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
