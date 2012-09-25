package home_automation.src;

import java.util.ArrayList;

import android.os.Bundle;

public class MainKitchen extends RoomApplication {

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

	public void addSwitchingList() {
		switchingList.add(new NameAndURL("switch 1", Constants.MAIN_BEDROOM_URL
				+ Constants.LIGHT + "/REGULAR/switch1"));
		switchingList.add(new NameAndURL("switch 2", Constants.MAIN_BEDROOM_URL
				+ Constants.LIGHT + "/REGULAR/switch2"));
		switchingList.add(new NameAndURL("switch 3", Constants.MAIN_BEDROOM_URL
				+ Constants.LIGHT + "/REGULAR/switch3"));
		super.addItemsOnSpinnerSwitch(switchingList);
	}

	public void addBrightnessList() {
		brightnessList.add(new NameAndURL("brightness 1",
				Constants.MAIN_BEDROOM_URL + Constants.LIGHT
						+ "/PWM/ceilingLight1"));
		brightnessList.add(new NameAndURL("brightness 2",
				Constants.MAIN_BEDROOM_URL + Constants.LIGHT
						+ "/PWM/ceilingLight2"));
		brightnessList.add(new NameAndURL("brightness 3",
				Constants.MAIN_BEDROOM_URL + Constants.LIGHT
						+ "/PWM/ceilingLight3"));
		super.addItemsOnSpinnerBrightness(brightnessList);
	}

}