package com.github.luiguip.ibge_adapter_multi_module.application.controller;

import com.github.luiguip.ibge_adapter_multi_module.application.adapter.IbgeUfsApplicationAdapter;
import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.github.luiguip.ibge_adapter_multi_module.application.controller.ApiEndpoints.UFS_ENDPOINT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = UFS_ENDPOINT,
        produces = APPLICATION_JSON_VALUE)
public class IbgeUfsController {

    private final IbgeUfsApplicationAdapter adapter;

    @GetMapping
    List<IbgeUfDto> findAll() {
        return adapter.findAll();
    }
}
