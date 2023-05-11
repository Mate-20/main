package com.spring.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entities.Book;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class EditService {
    
    public void editBook(Book book) throws IOException {
        String apiUrl = "http://localhost:8080/books";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut(apiUrl);
        request.addHeader("content-type", "application/json");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(book);
        StringEntity entity = new StringEntity(json);
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("Failed to add book, status code: " + statusCode);
        }
        
    }    
}
