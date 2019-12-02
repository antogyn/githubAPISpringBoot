package com.stage.SwanTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
	
	@GetMapping(value= "/swantest/{userName}")
	public User user(@PathVariable String userName) throws IOException
	{
		
		String readLine;
		User user=new User(userName);
		URL url = new URL("https://api.github.com/users/"+userName+"/repos");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responseCode = conn.getResponseCode() ;

		ArrayList<String> array = new ArrayList<String>();
		 if (responseCode != HttpURLConnection.HTTP_OK) {
			 array.add("NO Repos");
			 user.setRepo(array);
			 return user;

		    } else {
		      
		        
		        BufferedReader in = new BufferedReader(
			    new InputStreamReader(conn.getInputStream()));
			    StringBuffer response = new StringBuffer();
			       
					while ((readLine = in .readLine()) != null) {
			            response.append(readLine);
			        } in .close();
			        
			        JSONArray obj = new JSONArray(response.toString());
			        for(int i=0 ;i<obj.length();i++)
			        {
			        	String name = obj.getJSONObject(i).getString("name");
			        	array.add(name);
					}			        
					
					user.setRepo(array);
					return user;
		    }
			
	}
	
	
	
	
	
	

}
