package demo;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class DemoControllerTest {
    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testWithString() {
        String response = client.toBlocking().retrieve("/plain");
        Assertions.assertEquals("some body", response);
    }

    @Test
    void testWithResponse() {
        String response = client.toBlocking().retrieve("/");
        Assertions.assertEquals("some body", response);
    }

}
