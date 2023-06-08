package com.example.clienapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import  java.io.IOException;
import  java.net.http.*;
import  java.net.URI;
import java.io.File;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;

public class ClienApiApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        //first (time)
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/time")).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String apiResponse = response.body();
        System.out.println(apiResponse);

        //second (json)
        HttpRequest requetip = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/json")).GET().build();
        HttpResponse<String> ip = httpClient.send(requetip, HttpResponse.BodyHandlers.ofString());
        String apipp = ip.body();
        System.out.println(apipp);


        //third (image)
        String path="http://localhost:8080/api/image";
        HttpClient client=HttpClient.newHttpClient();
        try {

            HttpRequest httpRequest=HttpRequest.newBuilder()
                    .uri(new URI(path))
                    .header("Content-Type","application/json")
                    .GET().build();
            HttpResponse<byte[]> reque=client.send(httpRequest,HttpResponse.BodyHandlers.ofByteArray());
            System.out.println(reque.body().length);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}