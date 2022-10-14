package com.github.luiguip.application.mapper;

import com.github.luiguip.application.dto.IbgeUfDto;
import com.github.luiguip.domain.model.IbgeUf;
import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IbgeUfDtoMapper {
    List<IbgeUfDto> toDto(List<IbgeUf> ufs);
}
