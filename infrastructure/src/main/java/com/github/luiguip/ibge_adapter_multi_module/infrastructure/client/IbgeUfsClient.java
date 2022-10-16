package com.github.luiguip.ibge_adapter_multi_module.infrastructure.client;

import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.response.IbgeUfResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class IbgeUfsClient {

    public IbgeUfsClient(@Qualifier("ibge-webclient") WebClient webClient) {
        this.webClient = webClient;
    }

    private final WebClient webClient;

    public List<IbgeUfResponse> findAll() {
        var uri = String.format("%s%s", IbgeEndpoints.UFS_ENDPOINT, "?orderBy=nome");
        log.info("Retrieving all Ufs from Ibge. uri: {}", uri);
        try {
            var response = webClient
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToFlux(IbgeUfResponse.class)
                    .toStream()
                    .toList();
            log.info("Retrieved from ibge all {} ufs!", response.size());
            return response;
        } catch (Exception e) {
            log.error("Error retrieving ufs!", e);
            return Collections.emptyList();
        }
    }
}
