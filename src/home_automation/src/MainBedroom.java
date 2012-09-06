package home_automation.src;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainBedroom extends Activity implements OnClickListener,
		OnCheckedChangeListener, OnSeekBarChangeListener,OnItemSelectedListener {
	Switch sideLightSwitch;
	TextView tv;
	ImageView bulb;
	String URL;
	private Spinner spinnerOnOff;
	private Spinner spinnerBrightness;
	SeekBar brightnessCeilingLights;
	ArrayList<NameAndURL> list;
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
        spinnerOnOff = (Spinner) findViewById(R.id.spinner_on_off_application);
        spinnerOnOff.setOnItemSelectedListener(this);
        spinnerBrightness= (Spinner) findViewById(R.id.spinner_brightness);
        spinnerBrightness.setOnItemSelectedListener(this);
        addItemsOnSpinner2();
	}

	public void onClick(View v) {
		Toast.makeText(this,"You choose "+String.valueOf(spinnerOnOff.getSelectedItem()),
					Toast.LENGTH_SHORT).show();
	}

	 public void addItemsOnSpinner2() {
		 list = new ArrayList<NameAndURL>();
		 list.add(new NameAndURL("cabin Light",Constants.MAIN_BEDROOM_URL+Constants.LIGHT+"\\sideLights"));
			list.add(new NameAndURL("floor light",Constants.MAIN_BEDROOM_URL+Constants.LIGHT+"\\floorLights"));
			list.add(new NameAndURL("ceiling light",Constants.MAIN_BEDROOM_URL+Constants.LIGHT+"\\ceilingLights"));
			ArrayList<String> adapterList = new ArrayList<String>();
			for(NameAndURL l :list)
			adapterList.add(l.getName());
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item,adapterList);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			spinnerOnOff.setAdapter(dataAdapter);
		  }
	
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.switch_main_bedroom:
			if (isChecked){
				Toast.makeText(this,URL+"\\true",
						Toast.LENGTH_LONG).show();
			bulb.setImageResource(R.drawable.bulb_on);
			}
			else {
				Toast.makeText(this,URL+"\\false",
						Toast.LENGTH_LONG).show();
				bulb.setImageResource(R.drawable.bulb_off);
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
		// TODO Auto-generated method stub
		
	}

	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long arg3) {
		URL = list.get(pos).getURL();		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
