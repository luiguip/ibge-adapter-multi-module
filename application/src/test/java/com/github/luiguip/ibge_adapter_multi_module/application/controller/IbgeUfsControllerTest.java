package com.github.luiguip.ibge_adapter_multi_module.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.luiguip.ibge_adapter_multi_module.application.adapter.IbgeUfsApplicationAdapter;
import com.github.luiguip.ibge_adapter_multi_module.application.dto.IbgeUfDto;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.BadGatewayException;
import com.github.luiguip.ibge_adapter_multi_module.application.exception.InternalServerErrorException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IbgeUfsController.class)
class IbgeUfsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IbgeUfsController controller;

    @MockBean
    private IbgeUfsApplicationAdapter adapter;

    private static ObjectMapper objectMapper;

    @BeforeAll
    private static void setupAll() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldReturnEmptyListWhenDoNotHaveValidUfs() throws Exception {
        //given
        var ufs = Collections.emptyList();
        var expected = "[]";

        //when, then
        doReturn(ufs)
                .when(adapter)
                .findAll();

        mockMvc.perform(get(ApiEndpoints.UFS_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(adapter).findAll();
    }


    @Test
    void shouldReturnListWhenItsReceived() throws Exception {
        //given
        var ufs = fixtureIbgeUfDtos();
        var expected = objectMapper.writeValueAsString(ufs);

        //when, then
        doReturn(fixtureIbgeUfDtos())
                .when(adapter)
                .findAll();

        mockMvc.perform(get(ApiEndpoints.UFS_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));

        verify(adapter).findAll();
    }

    @Test
    void shouldThrowPersistenceClientExceptionWhenItsThrownByClient() throws Exception {
        //givem
        var exceptionClazz = InternalServerErrorException.class;

        //when, then
        doThrow(exceptionClazz)
                .when(adapter)
                .findAll();

        mockMvc.perform(get(ApiEndpoints.UFS_ENDPOINT))
                .andExpect(status().isInternalServerError());

        verify(adapter).findAll();
    }

    @Test
    void shouldThrowPersistenceServerExceptionWhenItsThrownByClient() throws Exception {
        //given
        var exceptionClazz = BadGatewayException.class;

        //when, then
        doThrow(exceptionClazz)
                .when(adapter)
                .findAll();

        mockMvc.perform(get(ApiEndpoints.UFS_ENDPOINT))
                .andExpect(status().isBadGateway());

        verify(adapter).findAll();
    }

    private List<IbgeUfDto> fixtureIbgeUfDtos() {
        return List.of(
                new IbgeUfDto(1, "São Paulo", "SP"),
                new IbgeUfDto(2, "Rio de Janeiro", "RJ"));
    }
}