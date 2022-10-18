package com.github.luiguip.ibge_adapter_multi_module.domain.service;

import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.application.IbgeUfsServicePort;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.infrastructure.IbgeUfsPersistencePort;

import java.util.List;

public class IbgeUfsService implements IbgeUfsServicePort {

    private final IbgeUfsPersistencePort persistencePort;

    public IbgeUfsService(IbgeUfsPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    public List<IbgeUf> findAll() {
        return persistencePort.findAll();
    }
}
