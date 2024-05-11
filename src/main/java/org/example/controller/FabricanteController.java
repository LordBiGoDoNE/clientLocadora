package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.example.model.Fabricante;

public class FabricanteController {

    ObjectMapper mapper = new ObjectMapper();

    private final String ENDPOINT_BASE = "api/fabricante";

    public List<Fabricante> obterFabricantesDoServidor() {
        final HttpGet request = new HttpGet("http://localhost:8080/" + ENDPOINT_BASE);

        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {
            return mapper.readValue(response.getEntity().getContent(), new TypeReference<List<Fabricante>>() {
            });
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Fabricante obterFabricanteDoServidor(int id) {
        final HttpGet request = new HttpGet(String.format("http://localhost:8080/%s/%d", ENDPOINT_BASE, id));

        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {
            return mapper.readValue(response.getEntity().getContent(), Fabricante.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String inserirFabricante(Fabricante fabricante) throws JsonProcessingException {
        final HttpPost request = new HttpPost("http://localhost:8080/" + ENDPOINT_BASE);

        String json = mapper.writeValueAsString(fabricante);

        HttpEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        request.setEntity(entity);

        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {

            String resposta = EntityUtils.toString(response.getEntity());

            return resposta;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String editarFabricante(Fabricante fabricante) throws JsonProcessingException {
        final HttpPatch request = new HttpPatch("http://localhost:8080/" + ENDPOINT_BASE);

        String json = mapper.writeValueAsString(fabricante);

        HttpEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        request.setEntity(entity);

        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {

            String resposta = EntityUtils.toString(response.getEntity());

            return resposta;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Metodo responsavel por chamar endpoint de exclusão de fabricante!
     * 
     * @param id - Id do Fabricante a ser deletado!
     * @return Mensagem do Servidor!
     * @throws JsonProcessingException 
     */
    public String deletarFabricante(int id) throws JsonProcessingException {
        final HttpDelete request = new HttpDelete(String.format("http://localhost:8080/%s/%d", ENDPOINT_BASE, id));

        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {

            String resposta = EntityUtils.toString(response.getEntity());

            return resposta;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
