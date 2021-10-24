package com.supervisor.registration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONObject;
import org.json.JSONArray;

public class SupervisorList {
	
	private static String SUPERURL = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";

	public static String getSupers() {
		try {
			URL url = new URL(SUPERURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = input.readLine()) != null) {
				content.append(inputLine);
			}
			input.close();
			conn.disconnect();
			return content.toString();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public static ArrayList<Supervisor> listSupers(){
		String json = getSupers(); //Retrieves supervisor string from url
		JSONArray arr = new JSONArray(json); //Converts JSON formatted String to JSONArray
		ArrayList<Supervisor> results = new ArrayList<Supervisor>();
		for(int i=0; i<arr.length(); i++) {
			JSONObject obj = arr.getJSONObject(i);
			if(!obj.getString("jurisdiction").matches(".*\\d.*")) { //Filters out numeric jurisdictions
				Supervisor s = new Supervisor(obj.getString("jurisdiction"), obj.getString("lastName"), obj.getString("firstName"));
				results.add(s);
			}
		}
		Collections.sort(results); //Sorts results list using supervisor's compareTo function
		return results;
	}
	
	//
	public static ArrayList<String> parseSupers(){
		ArrayList<Supervisor> supers = listSupers();
		ArrayList<String> results = new ArrayList<String>();
		supers.forEach((sup)->results.add(sup.toString())); //Converts arraylist of supervisors to arraylist of strings
		return results;
	}
	
}
