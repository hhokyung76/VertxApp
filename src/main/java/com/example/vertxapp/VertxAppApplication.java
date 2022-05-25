package com.example.vertxapp;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VertxAppApplication implements CommandLineRunner {

    private Vertx vertx;
    public static void main(String[] args) {
        SpringApplication.run(VertxAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        vertx = Vertx.vertx();

        vertx.deployVerticle(new Verticle1());
        vertx.deployVerticle(new Verticle1());
        vertx.deployVerticle(new Verticle1());
        vertx.deployVerticle(new Verticle1());
        vertx.deployVerticle(new Verticle1());
        vertx.deployVerticle(new Verticle1());
    }

}
