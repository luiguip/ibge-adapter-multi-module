package com.github.luiguip.domain.service;

import com.github.luiguip.domain.model.IbgeUf;
import com.github.luiguip.domain.port.application.IbgeUfsServicePort;
import com.github.luiguip.domain.port.infrastructure.IbgeUfsInfraPort;

import java.util.List;

public class IbgeUfsService implements IbgeUfsServicePort {

    private final IbgeUfsInfraPort infra;

    public IbgeUfsService(IbgeUfsInfraPort infra) {
        this.infra = infra;
    }

    @Override
    public List<IbgeUf> findAll() {
        return infra.findAll();
    }
}
