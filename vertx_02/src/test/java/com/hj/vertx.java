package com.hj;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class vertx {
    Vertx vertx = Vertx.vertx();

    Vertx vertx1 = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
}
