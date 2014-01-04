package com.crg.oe;

import static com.github.tomakehurst.wiremock.client.WireMock.*
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*
import groovyx.net.http.RESTClient

import org.junit.*

import com.github.tomakehurst.wiremock.junit.WireMockRule

class RestClientTest {
    private response
    private client

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().port(8089))

    @Test
    void test() {
        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                .withHeader("Content-Type", "text/plain")
                .withBody("Hello world!")));

        client = new RESTClient("http://localhost:8089/some/")

        response = client.get(path: 'thing')

        assertThat(response.data.text, is("Hello world!"))
    }
}
