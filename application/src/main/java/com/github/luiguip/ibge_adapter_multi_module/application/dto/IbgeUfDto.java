package com.github.luiguip.ibge_adapter_multi_module.application.dto;

import java.io.Serializable;

public record IbgeUfDto(Integer id, String name, String abbreviation) implements Serializable {
}
