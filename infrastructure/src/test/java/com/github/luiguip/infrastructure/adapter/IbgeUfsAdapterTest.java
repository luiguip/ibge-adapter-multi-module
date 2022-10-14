package com.github.luiguip.infrastructure.adapter;

import com.github.luiguip.infrastructure.mapper.IbgeUfMapper;
import com.github.luiguip.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.ibge_adapter_multi_module.domain.model.IbgeUf;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class IbgeUfsAdapterTest {

    @InjectMocks
    private IbgeUfsAdapter adapter;

    @Mock
    private IbgeUfsClient client;

    @Spy
    IbgeUfMapper ibgeUfMapper;

    @Test
    void shouldReturnEmptyListWhenItsReceived() {
        //given

        //when
        Mockito.doReturn(fixture())
                .when(client)
                .findAll();
        var ufs = adapter.findAll();

        //then
        Assertions.assertThat(ufs)
                .isEmpty();
    }

    private List<IbgeUf> fixture() {
        return Collections.emptyList();
    }
}