package com.github.luiguip.domain.port.application;

import com.github.luiguip.domain.model.IbgeUf;

import java.util.List;

public interface IbgeUfsServicePort {
    List<IbgeUf> findAll();
}
