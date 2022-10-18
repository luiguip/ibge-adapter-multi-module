package com.github.luiguip.ibge_adapter_multi_module.ibge_adapter_launcher.configuration;

import com.github.luiguip.ibge_adapter_multi_module.domain.service.IbgeUfsService;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.adapter.IbgeUfsPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IbgeAdapterConfiguration {

    @Bean
    public IbgeUfsService ibgeUfsService(IbgeUfsPersistenceAdapter ibgeUfsPersistenceAdapter) {
        return new IbgeUfsService(ibgeUfsPersistenceAdapter);
    }

}
