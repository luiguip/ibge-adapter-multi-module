package com.github.luiguip.client;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IbgeUfResponse(Integer id,
                             @JsonProperty("nome") String name,
                             @JsonProperty("sigla") String abbreviation) {
}
