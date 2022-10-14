package com.github.luiguip.ibge_adapter_multi_module.infrastructure;

import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.IbgeUfsClient;
import com.github.luiguip.ibge_adapter_multi_module.infrastructure.client.IbgeEndpoints;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = IbgeUfsClient.class)
class IbgeUfsClientTest {

    private static WireMockServer wireMockServer;

    @Autowired
    private IbgeUfsClient ibgeUfsClient;

    @BeforeAll
    static void setupAll() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();
    }

    @AfterAll
    static void endAll() {
        wireMockServer.stop();
    }

    @Test
    void getAll() {
        //given
        stubFor(get(urlEqualTo(IbgeEndpoints.UFS_ENDPOINT))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
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
}