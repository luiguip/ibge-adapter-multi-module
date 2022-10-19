package com.github.luiguip.ibge_adapter_multi_module.infrastructure.client;

import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.response.IbgeUfResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

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
        var response = webClient
                .get()
                .uri(uri)
                .retrieve()
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                        Mono.error(new PersistenceServerException(uri)))
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new PersistenceClientException(uri)))
                .bodyToFlux(IbgeUfResponse.class)
                .toStream()
                .toList();
        Objects.requireNonNull(response);
        log.info("Retrieved from ibge all {} ufs!", response.size());
        return response;
    }
}
