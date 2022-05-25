package com.example.vertxapp.webclient.test;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VertxClientTest {

    public static void main(String[] args) {
        VertxClientTest tester = new VertxClientTest();

        Vertx vertx = Vertx.vertx();
        tester.simpleGetAndHead(vertx);
    }

    public void simpleGetAndHead(Vertx vertx) {

        WebClient client = WebClient.create(vertx);

        // Send a GET request
        for (int ii = 0; ii < 3000; ii++) {
            client
                    .get(80, "localhost", "/products")
                    .send()
                    .onSuccess(response -> log.info("Received message: " + response.statusCode()+" "+OpenStringUtils.getCurrentTimeOfLog()))
                    .onFailure(err ->
                            log.info("Something went wrong " + err.getMessage()));
        }
        // Send a HEAD request
//        client
//                .head(8080, "myserver.mycompany.com", "/some-uri")
//                .send()
//                .onSuccess(response -> System.out
//                        .println("Received response with status code" + response.statusCode()))
//                .onFailure(err ->
//                        System.out.println("Something went wrong " + err.getMessage()));
    }

}
