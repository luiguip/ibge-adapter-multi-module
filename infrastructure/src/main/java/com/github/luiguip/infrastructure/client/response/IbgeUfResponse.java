package com.github.luiguip.infrastructure.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IbgeUfResponse(Integer id,
                             @JsonProperty("nome") String name,
                             @JsonProperty("sigla") String abbreviation) {
}
