package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        String url ="https://jsonplaceholder.typicode.com/posts/1/comments";
        HttpRequest httpRequest=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient httpClient=HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse=httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body());
    }
}