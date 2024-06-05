package com.example.micronaut;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

@MicronautTest
class HelloTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void testItWorks() {
        assertTrue(application.isRunning());
    }

    @Test
    void testHello() {
        String response = httpClient.toBlocking().retrieve("/hello/World");
        assertEquals("Hello World", response);
    }

}
