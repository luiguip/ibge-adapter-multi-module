package com.github.luiguip.ibge_adapter_multi_module.infrastructure.client;

import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.configuration.WebClientConfiguration;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.http.HttpStatus.*;

@ContextConfiguration(classes = WebClientConfiguration.class)
@SpringBootTest(classes = IbgeUfsClient.class)
class IbgeUfsClientTest {

    private static final String PATH = String.format("%s%s", IbgeEndpoints.UFS_ENDPOINT, "?orderBy=nome");
    private static WireMockServer wireMockServer;

    @Autowired
    private IbgeUfsClient ibgeUfsClient;

    @BeforeAll
    static void setupAll() {
        var wireMockConfiguration = new WireMockConfiguration().port(8080);
        wireMockServer = new WireMockServer(wireMockConfiguration);
        wireMockServer.start();
    }

    @AfterAll
    static void endAll() {
        wireMockServer.stop();
    }

    @AfterEach
    void endEach() {
        wireMockServer.resetAll();
    }

    @Test
    void getAll() {
        //given
        givenThat(get(urlEqualTo(PATH))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("ufs.json")));

        //when
        var actual = ibgeUfsClient.findAll();

        //then
        assertThat(actual)
                .hasSize(27)
                .allMatch(uf -> Objects.nonNull(uf.id())
                        && Objects.nonNull(uf.name())
                        && Objects.nonNull(uf.abbreviation()));
    }

    @Test
    void shouldThrowExceptionWhenStatusIs5xx() {
        //given
        givenThat(get(urlEqualTo(PATH))
                .willReturn(aResponse()
                        .withStatus(SERVICE_UNAVAILABLE.value())));

        //when, then
        assertThatThrownBy(() -> ibgeUfsClient.findAll())
                .isInstanceOf(PersistenceServerException.class);
    }


    @Test
    void shouldThrowExceptionWhenStatusIs4xx() {
        //given
        givenThat(get(urlEqualTo(PATH))
                .willReturn(aResponse()
                        .withStatus(NOT_FOUND.value())));

        //when, then
        assertThatThrownBy(() -> ibgeUfsClient.findAll())
                .isInstanceOf(PersistenceClientException.class);
    }
}