package com.github.luiguip.ibge_adapter_multi_module.application.adapter;

import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDto;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.BadGatewayException;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.InternalServerErrorException;
import com.github.luiguip.ibge_adapter_multi_module.application.mapper.IbgeUfDtoMapper;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.application.IbgeUfsServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IbgeUfsApplicationAdapter {

    private final IbgeUfsServicePort service;

    private final IbgeUfDtoMapper mapper;

    @Cacheable(value="ibgeUfs")
    public List<IbgeUfDto> findAll() {
        try {
            var ufs = service.findAll();
            return mapper.toDto(ufs);
        } catch (PersistenceServerException e) {
            throw new BadGatewayException(e.getMessage());
        } catch (PersistenceClientException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
