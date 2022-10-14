package com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IbgeUfResponse(Integer id,
                             @JsonProperty("nome") String name,
                             @JsonProperty("sigla") String abbreviation) {
}
