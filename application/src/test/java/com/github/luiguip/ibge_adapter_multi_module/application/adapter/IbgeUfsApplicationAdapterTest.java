package com.github.luiguip.ibge_adapter_multi_module.application.adapter;

import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDtoFixture;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.BadGatewayException;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.InternalServerErrorException;
import com.github.luiguip.ibge_adapter_multi_module.application.mapper.IbgeUfDtoMapper;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUfFixture;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.application.IbgeUfsServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class IbgeUfsApplicationAdapterTest {

    @InjectMocks
    private IbgeUfsApplicationAdapter adapter;

    @Mock
    private IbgeUfsServicePort service;

    @Spy
    private IbgeUfDtoMapper mapper = Mappers.getMapper(IbgeUfDtoMapper.class);

    @Test
    void shouldReturnEmptyListWhenServiceReturnsEmptyList() {
        //given
        var ufs = Collections.emptyList();
        var expected = Collections.emptyList();

        //when
        doReturn(ufs)
                .when(service)
                .findAll();
        var actual = adapter.findAll();

        //then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    void shouldReturnListWhenServiceReturnsList() {
        //given
        var ufs = IbgeUfFixture.fixtureIbgeUfs();
        var expected = IbgeUfDtoFixture.fixtureIbgeUfDtos();

        //when
        doReturn(ufs)
                .when(service)
                .findAll();
        var actual = adapter.findAll();

        //then
        assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    void shouldThrowBadGatewayExceptionWhenServicethrowsPersistenseServerException() {
        //given
        var persistenceExceptionClazz = PersistenceServerException.class;
        var expected = BadGatewayException.class;

        //when
        doThrow(persistenceExceptionClazz)
                .when(service)
                .findAll();

        //then
        assertThatThrownBy(() -> adapter.findAll())
                .isInstanceOf(expected);
    }

    @Test
    void shouldThrowInternalServerErrorExceptionWhenServicethrowsPersistenseClientException() {
        //given
        var persistenceExceptionClazz = PersistenceClientException.class;
        var expected = InternalServerErrorException.class;

        //when
        doThrow(persistenceExceptionClazz)
                .when(service)
                .findAll();

        //then
        assertThatThrownBy(() -> adapter.findAll())
                .isInstanceOf(expected);
    }
}