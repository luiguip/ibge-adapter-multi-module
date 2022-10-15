package com.github.luiguip.ibge_adapter_multi_module.domain.port.infrastructure;

import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;

import java.util.List;

public interface IbgeUfsPersistencePort {
    List<IbgeUf> findAll();
}
