package com.exercise45restclient2.app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.exercise45restclient2.model.Product;

public class RestClient2 {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient( );
		 
		WebTarget webTarget = client.target("http://localhost:8080/Exercise45Rest/").path("Product");
		 
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Product myProduct = new Product();
		myProduct.setIdProduct(1);
		myProduct.setNameProduct("Uva");
		myProduct.setPriceProduct(50.5);
		Response response = invocationBuilder.post(Entity.entity(myProduct, MediaType.APPLICATION_JSON));
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));

	}

}
