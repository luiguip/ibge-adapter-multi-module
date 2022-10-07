package com.github.luiguip.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class IbgeUfsClient {

    public IbgeUfResponse[] getAll(){
        var uri = String.format("%s%s", IbgeEndpoints.UFS_ENDPOINT, "?orderBy=nome");
        return WebClient.create("https://servicodados.ibge.gov.br/api")
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(IbgeUfResponse[].class)
                .block();
    }
}
