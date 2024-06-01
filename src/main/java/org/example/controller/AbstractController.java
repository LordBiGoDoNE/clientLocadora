package org.example.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.example.singleton.Configuracao;

public abstract class AbstractController<ENTITY> {

    ObjectMapper mapper = new ObjectMapper();

    private final String ENDPOINT_BASE;
    private final String HOST_PORT;

    public AbstractController(String endPointBase) {
        this.ENDPOINT_BASE = endPointBase;
        this.HOST_PORT = String.format("http://%s:%s/", Configuracao.getConfig().getHost(), Configuracao.getConfig().getPort());
    }

    public <T> List<T> get(Class<T> clazz) {
        final HttpGet request = new HttpGet(HOST_PORT + ENDPOINT_BASE);

        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {
            try {
                return mapper.readValue(response.getEntity().getContent(), new TypeReference<List<T>>() {
                });
            } catch (JacksonException ex) {
                throw new RuntimeException(response.getEntity().getContent().toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public <T> T get(Class<T> clazz, int id) {
        final HttpGet request = new HttpGet(String.format("%s%s/%d", HOST_PORT, ENDPOINT_BASE, id));

        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {
            try {
                return mapper.readValue(response.getEntity().getContent(), new TypeReference<T>() {
                });
            } catch (JacksonException ex) {
                throw new RuntimeException(response.getEntity().getContent().toString());
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String insert(ENTITY entity) throws JsonProcessingException {
        final HttpPost request = new HttpPost(HOST_PORT + ENDPOINT_BASE);

        String json = mapper.writeValueAsString(entity);

        HttpEntity httpEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        request.setEntity(httpEntity);

        return processRequest(request);
    }

    public String update(ENTITY entity) throws JsonProcessingException {
        final HttpPatch request = new HttpPatch(HOST_PORT + ENDPOINT_BASE);

        String json = mapper.writeValueAsString(entity);

        HttpEntity httpEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        request.setEntity(httpEntity);

        return processRequest(request);
    }

    /**
     * Metodo responsavel por chamar endpoint de exclusão de fabricante!
     *
     * @param id - Id do Fabricante a ser deletado!
     * @return Mensagem do Servidor!
     * @throws JsonProcessingException
     */
    public String delete(int id) throws JsonProcessingException {
        final HttpDelete request = new HttpDelete(String.format("%s%s/%d", HOST_PORT, ENDPOINT_BASE, id));

        return processRequest(request);
    }

    private String processRequest(HttpRequestBase request) {
        try (CloseableHttpClient client = HttpClientBuilder.create().build(); CloseableHttpResponse response = (CloseableHttpResponse) client
                .execute(request)) {

            String resposta = EntityUtils.toString(response.getEntity());

            return resposta;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
