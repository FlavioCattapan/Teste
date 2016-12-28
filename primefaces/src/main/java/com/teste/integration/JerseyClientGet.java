package com.teste.integration;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.teste.model.Vehicle;
import com.teste.model.VehicleJsonWrapper;
	

public class JerseyClientGet {

	public void run () {

		Client c = Client.create();
		WebResource wr = c.resource("http://swapi.co/api/vehicles/");
		ClientResponse resp = wr.accept("application/json").header("user-agent", "").get(ClientResponse.class);
		if (resp.getStatus() != 200) {
			throw new RuntimeException("Failed http error code :" + resp.getStatus());
		}
		String output = resp.getEntity(String.class);
		System.out.println(output);
		
		
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
			VehicleJsonWrapper user = mapper.readValue(output,  VehicleJsonWrapper.class);
			
			for(Vehicle vehicle : user.getResults()){
				System.out.println(vehicle);
			}
			

			// Convert JSON string to Object
			
			System.out.println(user);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
