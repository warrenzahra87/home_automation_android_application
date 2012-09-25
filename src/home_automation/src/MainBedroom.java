package home_automation.src;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
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

public class MainBedroom extends RoomApplication {


	ArrayList<NameAndURL> switchingList;
	ArrayList<NameAndURL> brightnessList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.applications);
		super.setOnCreate();
		switchingList = new ArrayList<NameAndURL>();
		brightnessList = new ArrayList<NameAndURL>();
		addSwitchingList();
		addBrightnessList();
	}
	
	public void addSwitchingList(){
		switchingList.add(new NameAndURL("main bedroom switch 1",	Constants.MAIN_BEDROOM_URL + Constants.LIGHT + "/REGULAR/switch1"));
		switchingList.add(new NameAndURL(" main bedroom switch 2",	Constants.MAIN_BEDROOM_URL + Constants.LIGHT + "/REGULAR/switch2"));
		switchingList.add(new NameAndURL("main bedroom  switch 3",	Constants.MAIN_BEDROOM_URL + Constants.LIGHT + "/REGULAR/switch3"));
		super.addItemsOnSpinnerSwitch(switchingList);
	}
	
	public void addBrightnessList(){
		brightnessList.add(new NameAndURL("main bedroom  brightness 1",Constants.MAIN_BEDROOM_URL + Constants.LIGHT + "/PWM/ceilingLight1"));
		brightnessList.add(new NameAndURL("main bedroom brightness 2",Constants.MAIN_BEDROOM_URL + Constants.LIGHT + "/PWM/ceilingLight2"));
		brightnessList.add(new NameAndURL("main bedroom brightness 3",Constants.MAIN_BEDROOM_URL + Constants.LIGHT + "/PWM/ceilingLight3"));
		super.addItemsOnSpinnerBrightness(brightnessList);
	}
	
	
}