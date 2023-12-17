package com.example.broadwayroulette;

import java.util.ArrayList;
import java.util.List;

public class TicketInfo {
	private String selectedShow1;
	private String selectedShow2;
	private String selectedShow3;
	
	private List<String> choices; 
	public TicketInfo() {
		choices = new ArrayList<>();
	}
	
	public void addChoice (String choice) {
		choices.add(choice); 
	}
	
	public List<String> getChoices() {
		return choices;
	}
}
