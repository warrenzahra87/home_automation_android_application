package home_automation.src;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Rooms extends Activity implements OnClickListener {
	Button mainKitchen;
	Button frontGarage;
	Button mainBedroom;
	Intent room;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room);
		mainBedroom = (Button) findViewById(R.id.button_main_bedroom);
		frontGarage = (Button) findViewById(R.id.button_front_garage);
		mainKitchen = (Button) findViewById(R.id.button_main_kitchen);

		mainBedroom.setOnClickListener(this);
		mainKitchen.setOnClickListener(this);
		frontGarage.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_front_garage:
			room = new Intent(this, FrontGarage.class);
			startActivity(room);

			break;

		case R.id.button_main_bedroom:
			room = new Intent(this, MainBedroom.class);
			startActivity(room);
			break;

		case R.id.button_main_kitchen:
			room = new Intent(this, MainKitchen.class);
			startActivity(room);
			break;
		}
	}

}
