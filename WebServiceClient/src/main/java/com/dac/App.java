package com.dac;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

//		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFilter.class ) );
//		WebTarget webTarget = client.target("http://localhost:8080/employees");
//		 
//		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
//		Response response = invocationBuilder.get();
//		 
//		Employees employees = response.readEntity(Employees.class);
//		List<Employees> listOfEmployees = employees.getEmployeeList();
//		     
//		System.out.println(response.getStatus());
//		System.out.println(Arrays.toString( listOfEmployees.toArray(new Employees[listOfEmployees.size()]) ));
//		 
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/employees");
		
		/*
		System.out.println(
				webTarget.request(MediaType.APPLICATION_JSON).get(String.class)
				
				);
		*/
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		@SuppressWarnings("unchecked")
		List<emp> employees = response.readEntity(List.class);
		System.out.println(employees);
		
		System.out.println(response.getStatus());

	}
}


