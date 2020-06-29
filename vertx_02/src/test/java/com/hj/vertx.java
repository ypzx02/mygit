package com.hj;


import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class vertx {

    public void testNetServerClient1(){
        Vertx vertx = Vertx.vertx();
        NetClient netClient = vertx.createNetClient();
        netClient.connect(9000,"localhost",res -> {
            if (res.succeeded()){
                System.out.println("Connected!");
                NetSocket result = res.result();
                result.write(Buffer.buffer("hello whj02!"));
                result.handler(buffer -> {
                    System.out.println(buffer.toString());
                });
            }else {
                System.out.println("Failed to connect: " + res.cause().getMessage());
            }
        });
    }



    public static void main(String[] args) {
        vertx vertx = new vertx();
        vertx.testNetServerClient1();

    }


}
