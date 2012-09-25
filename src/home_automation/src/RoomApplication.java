package home_automation.src;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class RoomApplication extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnSeekBarChangeListener,
		OnItemSelectedListener {
	Switch sideLightSwitch;
	TextView tv;
	ImageView bulb;
	String URLSwitching;
	String URLBrightness;
	private Spinner spinnerOnOff;
	private Spinner spinnerBrightness;
	SeekBar brightnessCeilingLights;
	Button tryAnimation;
	ArrayList<NameAndURL> switchingList;
	ArrayList<NameAndURL> brightnessList;

	public void setOnCreate() {
		sideLightSwitch = (Switch) findViewById(R.id.switch_main_bedroom);
		bulb = (ImageView) findViewById(R.id.imageView_bulb);
		sideLightSwitch.setOnCheckedChangeListener(this);
		tv = (TextView) findViewById(R.id.tvWindKts);
		tryAnimation = (Button) findViewById(R.id.button_try);
		tryAnimation.setOnClickListener(this);
		brightnessCeilingLights = (SeekBar) findViewById(R.id.sbWind);
		brightnessCeilingLights.setOnSeekBarChangeListener(this);
		spinnerOnOff = (Spinner) findViewById(R.id.spinner_on_off_application);
		spinnerOnOff.setOnItemSelectedListener(this);
		spinnerBrightness = (Spinner) findViewById(R.id.spinner_brightness);
		spinnerBrightness.setOnItemSelectedListener(this);
	}

	public void addItemsOnSpinnerSwitch(ArrayList<NameAndURL> switchingList) {
		this.switchingList = switchingList;
		ArrayList<String> adapterSwitchingList = new ArrayList<String>();
		for (NameAndURL l : switchingList)
			adapterSwitchingList.add(l.getName());
		ArrayAdapter<String> dataSwitchingAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item,
				adapterSwitchingList);
		dataSwitchingAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerOnOff.setAdapter(dataSwitchingAdapter);
	}

	public void addItemsOnSpinnerBrightness(ArrayList<NameAndURL> brightnessList) {
		this.brightnessList = brightnessList;
		ArrayList<String> adapterBrightnessList = new ArrayList<String>();
		for (NameAndURL l : brightnessList)
			adapterBrightnessList.add(l.getName());
		ArrayAdapter<String> dataBrightnessAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item,
				adapterBrightnessList);
		dataBrightnessAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerBrightness.setAdapter(dataBrightnessAdapter);
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.switch_main_bedroom:
			if (isChecked) {
				if (isChecked)
					bulb.setImageResource(R.drawable.bulb_on);
				Toast.makeText(this, URLSwitching + "/true", Toast.LENGTH_LONG)
						.show();
				WebServiceTask task = new WebServiceTask();
				task.execute(new String[] { URLSwitching + "/true" });

			} else {
				bulb.setImageResource(R.drawable.bulb_off);
				WebServiceTask task = new WebServiceTask();
				task.execute(new String[] { URLSwitching + "/false" });
				Toast.makeText(this, URLSwitching + "/false", Toast.LENGTH_LONG)
						.show();
			}
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
		Toast.makeText(this, String.valueOf(seekBar.getProgress()),
				Toast.LENGTH_SHORT).show();
		WebServiceTask task = new WebServiceTask();
		task.execute(new String[] { URLBrightness + "/" + seekBar.getProgress() });
	}

	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long arg3) {
		switch (parent.getId()) {
		case R.id.spinner_on_off_application:
			URLSwitching = switchingList.get(pos).getURL();
			Toast.makeText(this, URLSwitching, Toast.LENGTH_SHORT).show();
			break;
		case R.id.spinner_brightness:

			URLBrightness = brightnessList.get(pos).getURL();
			Toast.makeText(this, URLBrightness, Toast.LENGTH_SHORT).show();
			break;
		}

	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	public void onClick(View v) {
		// switch(v.getId()){
		// case (R.id.button_try):
		// animate();
		// break;
		// }
	}

	// private void animate() {
	//
	// bulb.setBackgroundResource(R.drawable.animation);
	// bulb.setVisibility(ImageView.INVISIBLE);
	// AnimationDrawable frameAnimation = (AnimationDrawable) bulb
	// .getBackground();
	// frameAnimation.setCallback(bulb);
	// frameAnimation.setVisible(true, true);
	// frameAnimation.start();
	// if (frameAnimation.isRunning()) {
	// frameAnimation.stop();
	// tv.setText("Start");
	// } else {
	// frameAnimation.start();
	// tv.setText("Stop");
	// }
	// }
}