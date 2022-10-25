package com.github.luiguip.ibge_adapter_multi_module.application.adapter;

import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDto;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.BadGatewayException;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.InternalServerErrorException;
import com.github.luiguip.ibge_adapter_multi_module.application.mapper.IbgeUfDtoMapper;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.application.IbgeUfsServicePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class IbgeUfsApplicationAdapter {

    private final IbgeUfsServicePort service;

    private final IbgeUfDtoMapper mapper;

    @Cacheable(value="ibgeUfs")
    public List<IbgeUfDto> findAll() {
        try {
            log.debug("Application Adapter find all ufs");
            var ufs = service.findAll();
            log.debug("Application adapter found all ufs | ufs size {}", ufs.size());
            return mapper.toDto(ufs);
        } catch (PersistenceServerException e) {
            log.error("Application Adapter | Persistence server error", e);
            throw new BadGatewayException(e.getMessage());
        } catch (PersistenceClientException e) {
            log.error("Application Adapter | Persistence client error", e);
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
