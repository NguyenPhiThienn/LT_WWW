package iuh.fit.se.fe.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.fe.entities.DienThoai;
import iuh.fit.se.fe.services.DienThoaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081/api/dienthoai";

    @Autowired
    public DienThoaiServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<DienThoai> findAll() {
        return restClient.get().uri(ENDPOINT)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((req, res) -> {
                    try (InputStream body = res.getBody()) {
                        if (body == null) return Collections.emptyList();
                        return objectMapper.readValue(body, new TypeReference<List<DienThoai>>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Collections.emptyList();
                    }
                });
    }

    @Override
    public void delete(String id) {
        restClient.delete().uri(ENDPOINT + "/{id}", id).retrieve();
    }

    @Override
    public void save(DienThoai dienThoai) {
        restClient.post()
                .uri(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dienThoai)
                .retrieve();
    }
}