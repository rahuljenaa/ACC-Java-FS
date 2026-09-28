package com.accenture.ltt.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("feedValuesBean")
public class FeedValuesBean {

	private Map<String, String> mapPropertyFromFeeder;
	private List<String> listPropertyFromFeeder;

	public FeedValuesBean() {
		mapPropertyFromFeeder = new HashMap<String, String>();
		mapPropertyFromFeeder.put("tom", "tom@gmail.com");
		mapPropertyFromFeeder.put("mike", "mike@gmail.com");
 
		listPropertyFromFeeder = new ArrayList<String>();
		listPropertyFromFeeder.add("apple");
		listPropertyFromFeeder.add("boy");
 
	}

	public Map<String, String> getMapPropertyFromFeeder() {
		return mapPropertyFromFeeder;
	}

	public void setMapPropertyFromFeeder(Map<String, String> mapPropertyFromFeeder) {
		this.mapPropertyFromFeeder = mapPropertyFromFeeder;
	}

	public List<String> getListPropertyFromFeeder() {
		return listPropertyFromFeeder;
	}

	public void setListPropertyFromFeeder(List<String> listPropertyFromFeeder) {
		this.listPropertyFromFeeder = listPropertyFromFeeder;
	}

	

}