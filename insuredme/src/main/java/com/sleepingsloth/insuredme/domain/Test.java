package com.sleepingsloth.insuredme.domain;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Test {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub

		Map<String, Object> data = new HashMap<String, Object>();
	    data.put( "name", "Mars" );
	    data.put( "age", 32 );
	    data.put( "city", "NY" );
	    JSONObject json = new JSONObject();
	    json.put("data", data);
	    System.out.printf( "JSON: %s", json.toString(2) );
	}

}
