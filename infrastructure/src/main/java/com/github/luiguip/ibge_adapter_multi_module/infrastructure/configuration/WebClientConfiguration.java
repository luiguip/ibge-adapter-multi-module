package com.github.luiguip.ibge_adapter_multi_module.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientConfiguration {

    @Value("${ibge.url}")
    private String ibgeApiUrl;

    @Bean("ibge-webclient")
    public WebClient ibgeWebClient() {
        return WebClient.create(ibgeApiUrl);
    }
}
