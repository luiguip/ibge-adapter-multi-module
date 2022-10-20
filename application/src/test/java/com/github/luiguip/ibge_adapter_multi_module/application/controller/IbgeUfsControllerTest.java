package com.github.luiguip.ibge_adapter_multi_module.application.controller;

import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDto;
import com.github.luiguip.ibge_adapter_multi_module.application.mapper.IbgeUfDtoMapper;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.application.IbgeUfsServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class IbgeUfsControllerTest {

    @InjectMocks
    private IbgeUfsController controller;

    @Mock
    private IbgeUfsServicePort service;

    @Spy
    private IbgeUfDtoMapper mapper = Mappers.getMapper(IbgeUfDtoMapper.class);

    @Test
    void shouldReturnEmptyListWhenDoNotHaveValidUfs() {
        //when
        doReturn(Collections.emptyList())
                .when(service)
                .findAll();
        var actual = controller.findAll();

        //then
        assertThat(actual).isEmpty();
    }


    @Test
    void shouldReturnListWhenItsReceived() {
        //given
        var expected = fixtureIbgeUfDtos();
        var ufs = fixtureIbgeUfs();

        //when
        doReturn(ufs)
                .when(service)
                .findAll();
        var actual = controller.findAll();

        //then
        assertThat(expected)
                .isEqualTo(actual);
    }

    @Test
    void shouldThrowPersistenceClientExceptionWhenItsThrownByClient() {
        //given, when
        doThrow(PersistenceClientException.class)
                .when(service)
                .findAll();

        //then
        assertThatThrownBy(() -> controller.findAll())
                .isInstanceOf(PersistenceClientException.class);
    }

    @Test
    void shouldThrowPersistenceServerExceptionWhenItsThrownByClient() {
        //given, when
        doThrow(PersistenceServerException.class)
                .when(service)
                .findAll();

        //then
        assertThatThrownBy(() -> controller.findAll())
                .isInstanceOf(PersistenceServerException.class);
    }

    private List<IbgeUf> fixtureIbgeUfs() {
        return List.of(
                new IbgeUf(1, "São Paulo", "SP"),
                new IbgeUf(2, "Rio de Janeiro", "RJ"));
    }

    private List<IbgeUfDto> fixtureIbgeUfDtos() {
        return List.of(
                new IbgeUfDto(1, "São Paulo", "SP"),
                new IbgeUfDto(2, "Rio de Janeiro", "RJ"));
    }
}