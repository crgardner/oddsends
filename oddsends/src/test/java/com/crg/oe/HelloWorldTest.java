package com.crg.oe;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import org.junit.*;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class HelloWorldTest {
	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8089); 


	@Test
	public void saysHello() {
		stubFor(get(urlEqualTo("/my/resource"))
	            .withHeader("Accept", equalTo("text/xml"))
	            .willReturn(aResponse()
	                .withStatus(200)
	                .withHeader("Content-Type", "text/xml")
	                .withBody("<response>Some content</response>")));
		
	   verify(postRequestedFor(urlMatching("/my/resource/[a-z0-9]+"))
	            .withRequestBody(matching(".*<message>1234</message>.*"))
	            .withHeader("Content-Type", notMatching("application/json")));
	}

}
