package com.github.luiguip.infrastructure.adapter;

import com.github.luiguip.ibge_adapter_multi_module.domain.port.infrastructure.IbgeUfsInfraPort;
import com.github.luiguip.infrastructure.mapper.IbgeUfMapper;
import com.github.luiguip.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IbgeUfsAdapter implements IbgeUfsInfraPort {

    private final IbgeUfMapper mapper;
    private final IbgeUfsClient client;

    public List<IbgeUf> findAll() {
        var ufs = client.findAll();
        return mapper.toModel(ufs);
    }

}
