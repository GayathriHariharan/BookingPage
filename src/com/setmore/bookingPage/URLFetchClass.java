package com.setmore.bookingPage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;


import com.fasterxml.jackson.databind.ObjectMapper;

public class URLFetchClass {

           public static void main(String[] args) throws Exception{
		
			URLFetchClass ClassObj = new URLFetchClass();
			ClassObj.getService();
	    } 
//PubString getAccessToken(){
//		
//		
//           String AuthURL =  "https://setmore.fullauth.com/0/oauth2/v1/auth?response_type=code"
//           		+ "&client_id=5e32a-c3d49a5861445b78680798f3c7a8eec9&client_secret=fKZJ-rmo3mCvZERgkfojN_WS9jGiBG&"
//           		+ "refresh_token=e22260dfea6sx4nPUH_13rO6gDkShZkSJureAgo_vP5Uv";			
//		 return "";
//	}
	
	
	
	
	String accessToken = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzZXRtb3JlLmZ1bGxhdXRoLmNvbSIsImlhdCI6MTUwOTEwNDgwOCwidXNlcl9pZCI6IjJmZTZmMTdkLWQxNjEtNGRlNy04ZWQ1LTQ2YzUzYjM1NDBkOSIsImV4cCI6MTUwOTExMjAwOCwianRpIjoiZGQ4ZWQuOE1PaDVCWmp1NCJ9.JXgTk8CdjjIBkHCep4VEteOp8hTqtwTBh3PB085cMCg";
	
	//ObjectMapper objMap = new ObjectMapper();
	//HashMap<String,String> hashmap = new HashMap<>();
	
	
	public String getService() throws Exception {
		
		String url = "https://developer.setmore.com/api/v1/bookingapi/services";
		String response="";
		
		try{	
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		
		con.setRequestMethod("GET");		
        con.setRequestProperty("Content-Type", "application/json");	 
        con.setRequestProperty("Authorization", accessToken);
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			response += inputLine;
		
		System.out.println("response is " + response);
			
		}
		//hashmap = objMap.readValue("data", new TypeReference<HashMap<String, String>>(){});
		
		
		}catch(Exception e){
			System.out.println("Exception " + e);
		}
		return response;

	}
	
	
	
	
	
}
