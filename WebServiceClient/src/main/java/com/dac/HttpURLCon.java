package com.dac;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class HttpURLCon {

	public String echoCuties(String query) throws Exception {
		// Encode the query
		String encodedQuery = URLEncoder.encode(query, "UTF-8");
		// This is the data that is going to be send to itcuties.com via POST request
		// 'e' parameter contains data to echo
		String postData = "e=" + encodedQuery;

		URL url = new URL("http://localhost:8080/employees");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// connection.setRequestProperty("Content-Length",
		// String.valueOf(postData.length()));

		// Write data
		OutputStream os = connection.getOutputStream();
		os.write(postData.getBytes());

		// Read response
		StringBuilder responseSB = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		String line;
		while ((line = br.readLine()) != null)
			responseSB.append(line);

		// Close streams
		br.close();
		os.close();

		return responseSB.toString();

	}

	// Run this example
	public static void main(String[] args) {
		try {

			// GET
			//getRequest();
			
			URL url = new URL("http://localhost:8080/employees/post");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			
			//Set “content-type” request header to “application/json” to send the request content in JSON form. 
			//This parameter has to be set to send the request body in JSON format.
			connection.setRequestProperty("Content-Type", "application/json; utf-8");
			
			// Set the “Accept” request header to “application/json” to read the response in the desired format:
			connection.setRequestProperty("Accept", "application/json");

			//To send request content, let's enable the URLConnection object's doOutput property to true.
			//Otherwise, we'll not be able to write content to the connection output stream
			connection.setDoOutput(true);
			connection.connect();

			// REQUEST 
			Gson gson = new Gson();    
		    String jsonInputString = gson.toJson(new emp(101, "deepak"));

			OutputStream os = connection.getOutputStream();
			byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);
			
		    
		    
//			DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
//			dos.writeChars("param1=value1&param2=value2");
//			dos.flush();
//			dos.close();
			
		    
		    // RESPONSE
		    InputStream ip = connection.getInputStream();
			BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));
			StringBuilder response = new StringBuilder();
			String responseSingle = null;
			while ((responseSingle = br1.readLine()) != null) {
				response.append(responseSingle);
			}
			String xx = response.toString();
			System.out.println(xx);
			
		    Type type = new TypeToken<emp>(){}.getType();
		    emp ep = gson.fromJson(xx, type);
		    //for (emp ep : contactList){
		    	System.out.println("ID: "+ep.getId()+"     name: "+ep.getName());   
		    //}
		    
		    
			
			
			
			
			
			
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}

	// GET
	public static void getRequest() throws Exception {
		URL url = new URL("http://localhost:8080/employees");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responsecode = connection.getResponseCode();
		System.out.println(responsecode);
		System.out.println(connection.getResponseMessage());
		System.out.println("InstanceFollowRedirects:" + connection.getInstanceFollowRedirects());

		InputStream ip = connection.getInputStream();
		BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));
		StringBuilder response = new StringBuilder();
		String responseSingle = null;
		while ((responseSingle = br1.readLine()) != null) {
			response.append(responseSingle);
		}
		String xx = response.toString();
		System.out.println(xx);
		
		
		Gson gson = new Gson();
	    Type type = new TypeToken<List<emp>>(){}.getType();
	    List<emp> contactList = gson.fromJson(xx, type);
	    for (emp ep : contactList){
	    	System.out.println("ID: "+ep.getId()+"     name: "+ep.getName());   
	    }
	}
	
}
