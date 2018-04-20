package com.assignment.Jersey;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JersryClientDelete {
	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://qas.qmetry.com/struts2-rest-showcase-2.3.16.3/orders/95.json");

			ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);
			System.out.println(output);
			System.out.println("Output from Server .... \n");
			System.out.println("Status Code " + response.getStatus());
			System.out.println("Status Code " + response.getClientResponseStatus());

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
