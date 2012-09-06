package home_automation.src;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;

public class MainKitchen extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnSeekBarChangeListener {
	Switch sideLightSwitch;
	TextView tv;
	ImageView bulb;
	SeekBar brightnessCeilingLights;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.applications);
		sideLightSwitch = (Switch) findViewById(R.id.switch_main_bedroom);
		bulb=(ImageView) findViewById(R.id.imageView_bulb);
		sideLightSwitch.setOnCheckedChangeListener(this);
		tv = (TextView) findViewById(R.id.tvWindKts);
		brightnessCeilingLights = (SeekBar)findViewById(R.id.sbWind);
        brightnessCeilingLights.setOnSeekBarChangeListener(this);
	}

	public void onClick(View v) {
		// switch(v.getId()){
		// case R.id.bedroomPWM:
		//
		// break;
		// case R.id.bedroomONOFF:
		// text.setText("http://localhost:8182/mainBedroom/light/sideLights/true");
		// break;
		// }
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.switch_main_bedroom:
			if (isChecked)
			bulb.setImageResource(R.drawable.bulb_on);
			else 
				bulb.setImageResource(R.drawable.bulb_off);
			break;
		}
	}

	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		tv.setText(String.valueOf(progress));
	}

	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
