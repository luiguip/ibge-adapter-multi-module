package com.github.luiguip.application.controller;

import com.github.luiguip.application.mapper.IbgeUfDtoMapper;
import com.github.luiguip.domain.port.application.IbgeUfsServicePort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class IbgeUfsControllerTest {

    @InjectMocks
    private IbgeUfsController controller;

    @Mock
    private IbgeUfsServicePort service;

    @Spy
    private IbgeUfDtoMapper mapper;

    @Test
    void shouldReturnEmptyListWhenDoesntHaveValidUfs() {
        //when
        doReturn(Collections.emptyList())
                .when(service)
                .findAll();
        var actual = controller.findAll();

        //then
        assertThat(actual).isEmpty();
    }
}