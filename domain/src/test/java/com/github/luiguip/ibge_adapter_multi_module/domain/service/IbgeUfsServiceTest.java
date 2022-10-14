package com.github.luiguip.ibge_adapter_multi_module.domain.service;

import com.github.luiguip.ibge_adapter_multi_module.domain.port.infrastructure.IbgeUfsInfraPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class IbgeUfsServiceTest {

    @InjectMocks
    private IbgeUfsService service;

    @Mock
    private IbgeUfsInfraPort infra;

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
}