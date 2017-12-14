package com.simtlix.java9.experience.http2;

import java.net.URI;
import java.util.List;
import java.util.Map;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;


/*
 * This class generates a new HTTPClient, HTTPRequest and the HTTPResponse to show how is the
 * new HTTP 2.0 features as a starter point. The programmer would need more investigation.
 */
public class HTTP2Java {

	
	public static void checkHTTP2Feature() {
        try {
        	//Creates a HTTPClient object
            HttpClient httpClient = HttpClient.newHttpClient();
            System.out.println(httpClient.version());
            //Build a HTTPRequest
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("http://www.simtlix.com/")).GET().build(); //Create a GET request for the given URI
            Map<String,List<String>> headers = httpRequest.headers().map();
            headers.forEach((k, v) -> System.out.println(k + "-" + v));
            
            //Send the request.
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
            System.out.println("Response: " + httpResponse.body()); //Output the body of the response
        } catch (Exception e) {
            System.out.println("message " + e);
        }
        
        
        
        
        
    }
	
}
