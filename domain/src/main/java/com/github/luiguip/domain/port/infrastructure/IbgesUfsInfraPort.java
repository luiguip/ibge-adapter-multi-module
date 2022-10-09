package com.github.luiguip.domain.port.infrastructure;

import com.github.luiguip.domain.model.IbgeUf;

import java.util.List;

public interface IbgesUfsInfraPort {
    List<IbgeUf> findAll();
}
