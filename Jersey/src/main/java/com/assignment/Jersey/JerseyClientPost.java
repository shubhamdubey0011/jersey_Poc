package com.assignment.Jersey;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	public static void main(String[] args) {

		Client client = Client.create();

		WebResource webresource = client.resource("http://qas.qmetry.com/struts2-rest-showcase-2.3.16.3/orders.json");
		String body = "{\"clientName\":\"Metallica\",\"amount\":\"420\"}";

		ClientResponse response = webresource.type("application/json").post(ClientResponse.class, body);

		if (response.getStatus() != 201) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(response.getClientResponseStatus());
		System.out.println(output);

	}

}
