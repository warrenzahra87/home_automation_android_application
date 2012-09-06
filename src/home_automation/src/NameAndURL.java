package home_automation.src;

public class NameAndURL {

	String URL;
	String name;
	public NameAndURL(String name, String URL){
		this.name = name;
		this.URL = URL;
	}
	public String getName(){
		return name;
	}
	public String getURL(){
		return URL;
	}
}
