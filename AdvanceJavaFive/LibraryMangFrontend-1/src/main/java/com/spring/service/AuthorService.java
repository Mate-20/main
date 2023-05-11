package com.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entities.Author;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class AuthorService {
    
    public List<Author> fetchAuthors() throws IOException {
        String apiUrl = "http://localhost:8080/authors";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiUrl);
        request.addHeader("accept", "application/json");
        HttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        ObjectMapper mapper = new ObjectMapper();
        Author[] authors = mapper.readValue(entity.getContent(), Author[].class);
        return Arrays.asList(authors);
    }
}
