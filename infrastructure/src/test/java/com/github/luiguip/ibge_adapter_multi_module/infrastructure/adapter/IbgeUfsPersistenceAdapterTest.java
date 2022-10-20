package com.github.luiguip.ibge_adapter_multi_module.infrastructure.adapter;

import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.response.IbgeUfResponse;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.mapper.IbgeUfMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class IbgeUfsPersistenceAdapterTest {

    @InjectMocks
    private IbgeUfsPersistenceAdapter adapter;

    @Mock
    private IbgeUfsClient client;

    @Spy
    IbgeUfMapper ibgeUfMapper = Mappers.getMapper(IbgeUfMapper.class);

    @Test
    void shouldReturnEmptyListWhenItsReceived() {
        //given
        var response = Collections.emptyList();

        //when
        doReturn(response)
                .when(client)
                .findAll();
        var ufs = adapter.findAll();

        //then
        assertThat(ufs)
                .isEmpty();
    }

    @Test
    void shouldReturnListWhenItsReceived() {
        //given
        var response = fixtureIbgeUfsResponse();
        var expected = fixtureIbgeUfs();

        //when
        doReturn(response)
                .when(client)
                .findAll();
        var actual = adapter.findAll();

        //then
        assertThat(expected)
                .isEqualTo(actual);
    }

    @Test
    void shouldThrowPersistenceClientExceptionWhenItsThrownByClient() {
        //given, when
        doThrow(PersistenceClientException.class)
                .when(client)
                .findAll();

        //then
        assertThatThrownBy(() -> adapter.findAll())
                .isInstanceOf(PersistenceClientException.class);
    }

    @Test
    void shouldThrowPersistenceServerExceptionWhenItsThrownByClient() {
        //given, when
        doThrow(PersistenceServerException.class)
                .when(client)
                .findAll();

        //then
        assertThatThrownBy(() -> adapter.findAll())
                .isInstanceOf(PersistenceServerException.class);
    }

    private List<IbgeUf> fixtureIbgeUfs() {
        return List.of(
                new IbgeUf(1, "São Paulo", "SP"),
                new IbgeUf(2, "Rio de Janeiro", "RJ"));
    }

    private List<IbgeUfResponse> fixtureIbgeUfsResponse() {
        return List.of(
                new IbgeUfResponse(1, "São Paulo", "SP"),
                new IbgeUfResponse(2, "Rio de Janeiro", "RJ"));
    }
}