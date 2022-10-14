package com.github.luiguip.ibge_adapter_multi_module.domain.port.application;

import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;

import java.util.List;

public interface IbgeUfsServicePort {
    List<IbgeUf> findAll();
}
