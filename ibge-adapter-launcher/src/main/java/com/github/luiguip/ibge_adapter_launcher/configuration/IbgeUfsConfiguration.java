package com.github.luiguip.ibge_adapter_launcher.configuration;

import com.github.luiguip.domain.port.application.IbgeUfsServicePort;
import com.github.luiguip.domain.port.infrastructure.IbgeUfsInfraPort;
import com.github.luiguip.domain.service.IbgeUfsService;
import com.github.luiguip.infrastructure.adapter.IbgeUfsAdapter;
import com.github.luiguip.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.infrastructure.mapper.IbgeUfMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IbgeUfsConfiguration {

    @Bean
    public IbgeUfsInfraPort ibgesUfsInfraConfiguration() {
        return new IbgeUfsAdapter(new IbgeUfMapperImpl(), new IbgeUfsClient());
    }

    @Bean
    public IbgeUfsServicePort ibgeUfsService() {
        return new IbgeUfsService(ibgesUfsInfraConfiguration());
    }


}
