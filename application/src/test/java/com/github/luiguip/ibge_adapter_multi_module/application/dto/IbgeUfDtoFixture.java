package com.github.luiguip.ibge_adapter_multi_module.application.dto;

import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class IbgeUfDtoFixture {

    public static List<IbgeUfDto> fixtureIbgeUfDtos() {
        return List.of(
                new IbgeUfDto(1, "São Paulo", "SP"),
                new IbgeUfDto(2, "Rio de Janeiro", "RJ"));
    }
}
