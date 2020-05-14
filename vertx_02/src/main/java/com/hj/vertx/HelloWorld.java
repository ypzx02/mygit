package com.hj.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.util.function.Consumer;

/**
 * @author cursor
 */
public class HelloWorld extends AbstractVerticle {


    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello from Vert.x! 王鸿杰");
        }).listen(8080,http -> {
            if (http.succeeded()){
                System.out.println("success");
            }else if (http.failed()){
                System.out.println("faild");
            }
        });
    }

    public static void main(String[] args) {
        String name = HelloWorld.class.getName();
        VertxOptions vertxOptions = new VertxOptions();
        Consumer<Vertx> runner = vertx1 -> {
            vertx1.deployVerticle(name);
        };
        Vertx vertx = Vertx.vertx(vertxOptions);
        runner.accept(vertx);
    }
}
