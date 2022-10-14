package com.github.luiguip.ibge_adapter_multi_module.infrastructure.mapper;

import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.response.IbgeUfResponse;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IbgeUfMapper {
    List<IbgeUf> toModel(List<IbgeUfResponse> ibgeUfResponse);
}
