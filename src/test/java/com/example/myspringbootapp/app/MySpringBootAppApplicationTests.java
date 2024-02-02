package com.example.myspringbootapp.app;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.myspringbootapp.app.controller.WebController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
// @ActiveProfiles(value = "test")
class MySpringBootAppApplicationTests {

    @Autowired
    private WebController webController;

    @Test
    void contextLoads() throws Exception {
        assertThat(webController).isNotNull();
    }
    /*@BeforeEach
    public void createClient() {
        WebTestClient
            .bindToServer()
            .baseUrl("http://localhost:8080/")
            .build();
    }*/

    @Test
    void postRequest_returnsStatus200() {
        /*WebClient client = createClient();
        UriSpec<WebClient.RequestBodySpec> uriSpec = client.post();
        RequestBodySpec bodySpec = uriSpec.uri("/calculation");
        RequestHeadersSpec<?> headersSpec = bodySpec.bodyValue("data");

        ResponseSpec responseSpec = headersSpec.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();

        // It’s important to pay attention to the ResponseSpec.bodyToMono method,
        // which will throw a WebClientException if the status code is 4xx (client error) or 5xx (server error).
        try {
            Mono<String> response = headersSpec.retrieve()
                    .bodyToMono(String.class);
        } catch (WebClientException ex) {
            ex.getMessage();
        }*/
    }
}
