package com.github.luiguip.ibge_adapter_multi_module.application.adapter;

import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class IbgeUfFixture {

    private IbgeUfFixture() {

    }

    public static List<IbgeUf> fixtureIbgeUfs() {
        return List.of(
                new IbgeUf(1, "São Paulo", "SP"),
                new IbgeUf(2, "Rio de Janeiro", "RJ"));
    }
}