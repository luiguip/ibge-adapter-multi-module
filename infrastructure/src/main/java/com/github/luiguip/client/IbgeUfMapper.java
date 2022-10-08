package com.github.luiguip.client;

import com.github.luiguip.model.IbgeUf;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IbgeUfMapper {
    List<IbgeUf> toModel(List<IbgeUfResponse> ibgeUfResponse);
}
