package server;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    public static void main(String[] args) {
        HttpClient cl = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:4446"))
                .header("Type", "Hello")
                .build();

        HttpResponse<String> respons = null;

        try {
            respons = cl.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(respons.body());
        getSome();
    }

    public static void getSome(){
        try {
            com.mashape.unirest.http.HttpResponse<String> response = Unirest
                    .get("http://localhost:4446")
                    .header("Type", "Help")
                    .asString();
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
