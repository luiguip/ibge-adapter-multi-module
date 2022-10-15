package com.github.luiguip.ibge_adapter_launcher.configuration;

import com.github.luiguip.ibge_adapter_multi_module.domain.port.application.IbgeUfsServicePort;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.infrastructure.IbgeUfsPersistencePort;
import com.github.luiguip.ibge_adapter_multi_module.domain.service.IbgeUfsService;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.adapter.IbgeUfsAdapter;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.mapper.IbgeUfMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IbgeUfsConfiguration {

    @Bean
    public IbgeUfsPersistencePort ibgesUfsInfraConfiguration() {
        return new IbgeUfsAdapter(new IbgeUfMapperImpl(), new IbgeUfsClient());
    }

    @Bean
    public IbgeUfsServicePort ibgeUfsService() {
        return new IbgeUfsService(ibgesUfsInfraConfiguration());
    }


}
