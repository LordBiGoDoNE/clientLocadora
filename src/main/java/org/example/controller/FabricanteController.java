package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.example.model.Fabricante;

public class FabricanteController {

    public List<Fabricante> obterFabricanteDoServidor() {
        final HttpGet request = new HttpGet("http://localhost:8080/api/fabricante");
        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Fabricante>>(){});
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
