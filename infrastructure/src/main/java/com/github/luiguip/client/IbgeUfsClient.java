package com.github.luiguip.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Slf4j
@Component
public class IbgeUfsClient {

    public Optional<IbgeUfResponse[]> getAll() {
        log.info("Retrieving all Ufs from Ibge.");
        var uri = String.format("%s%s", IbgeEndpoints.UFS_ENDPOINT, "?orderBy=nome");
        try {
            var response = WebClient.create("https://servicodados.ibge.gov.br/api")
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(IbgeUfResponse[].class)
                    .block();
            return Optional.ofNullable(response);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
