package com.github.luiguip.ibge_adapter_multi_module.application.controller;

import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDto;
import com.github.luiguip.ibge_adapter_multi_module.application.mapper.IbgeUfDtoMapper;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.application.IbgeUfsServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github.luiguip.ibge_adapter_multi_module.application.controller.ApiEndpoints.UFS_ENDPOINT;

@RequiredArgsConstructor
@RestController
@RequestMapping(UFS_ENDPOINT)
public class IbgeUfsController {

    private final IbgeUfsServicePort service;

    private final IbgeUfDtoMapper mapper;

    @GetMapping
    List<IbgeUfDto> findAll() {
        var ufs = service.findAll();
        return mapper.toDto(ufs);
    }
}