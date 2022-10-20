package com.github.luiguip.ibge_adapter_multi_module.domain.service;

import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import com.github.luiguip.ibge_adapter_multi_module.domain.port.infrastructure.IbgeUfsPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class IbgeUfsServiceTest {

    @InjectMocks
    private IbgeUfsService service;

    @Mock
    private IbgeUfsPersistencePort infra;

    @Test
    void shouldFindEmptyListWhenDoNotHaveValidUfs() {
        //when
        doReturn(Collections.emptyList())
                .when(infra)
                .findAll();
        var actual = service.findAll();

        //then
        assertThat(actual).isEmpty();
    }

    @Test
    void shouldReturnListWhenItsReceived() {
        //given
        var expected = fixtureIbgeUfs();

        //when
        doReturn(expected)
                .when(infra)
                .findAll();
        var actual = service.findAll();

        //then
        assertThat(expected)
                .isEqualTo(actual);
    }

    @Test
    void shouldThrowPersistenceClientExceptionWhenItsThrownByClient() {
        //given, when
        doThrow(PersistenceClientException.class)
                .when(infra)
                .findAll();

        //then
        assertThatThrownBy(() -> service.findAll())
                .isInstanceOf(PersistenceClientException.class);
    }

    @Test
    void shouldThrowPersistenceServerExceptionWhenItsThrownByClient() {
        //given, when
        doThrow(PersistenceServerException.class)
                .when(infra)
                .findAll();

        //then
        assertThatThrownBy(() -> service.findAll())
                .isInstanceOf(PersistenceServerException.class);
    }

    private List<IbgeUf> fixtureIbgeUfs() {
        return List.of(
                new IbgeUf(1, "São Paulo", "SP"),
                new IbgeUf(2, "Rio de Janeiro", "RJ"));
    }
}