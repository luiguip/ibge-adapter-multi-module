package com.github.luiguip.infrastructure.client;

import com.github.luiguip.infrastructure.client.response.IbgeUfResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class IbgeUfsClient {

    public List<IbgeUfResponse> getAll() {
        log.info("Retrieving all Ufs from Ibge.");
        var uri = String.format("%s%s", IbgeEndpoints.UFS_ENDPOINT, "?orderBy=nome");
        try {
            var response = WebClient.create("https://servicodados.ibge.gov.br/api")
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
