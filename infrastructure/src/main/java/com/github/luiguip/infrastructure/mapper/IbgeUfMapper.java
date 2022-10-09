package com.github.luiguip.infrastructure.mapper;

import com.github.luiguip.infrastructure.client.response.IbgeUfResponse;
import com.github.luiguip.domain.model.IbgeUf;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IbgeUfMapper {
    List<IbgeUf> toModel(List<IbgeUfResponse> ibgeUfResponse);
}
