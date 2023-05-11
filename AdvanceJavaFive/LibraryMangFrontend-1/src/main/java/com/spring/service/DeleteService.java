package com.spring.service;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class DeleteService {

    public void deleteBook(int bookCode) throws IOException {
        String apiUrl = "http://localhost:8080/books/"+bookCode;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete request = new HttpDelete(apiUrl);
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            throw new RuntimeException("Failed to Delete book, status code: " + statusCode);
        }
        
    }    
    
}
