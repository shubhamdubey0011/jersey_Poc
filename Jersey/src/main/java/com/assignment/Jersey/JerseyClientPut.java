package com.assignment.Jersey;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPut 
{

	public static void main(String[] args) 
	{
	
		Client client = Client.create();

		WebResource webresource = client.resource("http://qas.qmetry.com/struts2-rest-showcase-2.3.16.3/orders/.json");
		String body = "{\"clientName\":\"Metallica_updated\",\"amount\":\"421\"}";
		
		ClientResponse response = webresource.type("application/json").put(ClientResponse.class, body);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(response.getStatus());
		System.out.println(response.getClientResponseStatus());
		
		
		
	}
}
