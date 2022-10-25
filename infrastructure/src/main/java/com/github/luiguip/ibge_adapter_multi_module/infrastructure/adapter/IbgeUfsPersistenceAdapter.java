package com.github.luiguip.ibge_adapter_multi_module.infrastructure.adapter;

import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.infrastructure.IbgeUfsPersistencePort;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.mapper.IbgeUfMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class IbgeUfsPersistenceAdapter implements IbgeUfsPersistencePort {

    private final IbgeUfMapper mapper;
    private final IbgeUfsClient client;

    public List<IbgeUf> findAll() {
        log.debug("Persistence Adapter find all ufs");
        var ufs = client.findAll();
        log.debug("Persistence adapter found all ufs | ufs size {}", ufs.size());
        return mapper.toModel(ufs);
    }

}
