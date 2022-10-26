package com.github.luiguip.ibge_adapter_multi_module.domain.model;

import java.util.List;

public class IbgeUfFixture {

    private IbgeUfFixture() {

    }

    public static List<IbgeUf> fixtureIbgeUfs() {
        return List.of(
                new IbgeUf(1, "São Paulo", "SP"),
                new IbgeUf(2, "Rio de Janeiro", "RJ"));
    }
}