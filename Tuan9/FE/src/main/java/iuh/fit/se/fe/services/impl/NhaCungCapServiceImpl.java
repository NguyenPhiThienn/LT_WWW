package iuh.fit.se.fe.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.fe.entities.NhaCungCap;
import iuh.fit.se.fe.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081/api/nhacungcap";

    @Autowired
    public NhaCungCapServiceImpl(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<NhaCungCap> findAll() {
        return restClient.get().uri(ENDPOINT)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((req, res) -> {
                    try (InputStream body = res.getBody()) {
                        if (body == null) return Collections.emptyList();
                        return objectMapper.readValue(body, new TypeReference<List<NhaCungCap>>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Collections.emptyList();
                    }
                });
    }

    @Override
    public List<NhaCungCap> search(String keyword) {
        return restClient.get().uri(ENDPOINT + "?keyword={kw}", keyword)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((req, res) -> {
                    try (InputStream body = res.getBody()) {
                        if (body == null) return Collections.emptyList();
                        return objectMapper.readValue(body, new TypeReference<List<NhaCungCap>>() {});
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Collections.emptyList();
                    }
                });
    }
}