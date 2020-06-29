package com.hj.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;

/**
 * @author whj
 * @create 2020-05-26 16:21
 */
public class TcpTest {

    private Vertx vertx = Vertx.vertx();

    public void testNetServer(){
       // Vertx vertx = Vertx.vertx();
        NetServer netServer = vertx.createNetServer();
        netServer.connectHandler(socket -> {
            socket.handler(buffer -> {
                // 在这里应该解析报文，封装为协议对象，并找到响应的处理类，得到处理结果，并响应
                System.out.println("接收到的数据为：" + buffer.toString());
                // 按照协议响应给客户端
                socket.write(Buffer.buffer("Server Received"));
            });
            socket.closeHandler(close -> {
                System.out.println("客户端退出连接");
            });
        });

        netServer.listen(9000,"localhost",res -> {
            if (res.succeeded()){
                System.out.println("Server is now listening!");
            }else {
                System.out.println("Failed to bind!");
            }
        });



    }

    public void testNetServerClient(){
        Vertx vertx = Vertx.vertx();
        NetClient netClient = vertx.createNetClient();
        netClient.connect(9000,"localhost",res -> {
           if (res.succeeded()){
               System.out.println("Connected!");
               NetSocket result = res.result();
               result.write(Buffer.buffer("hello whj01!"));
               result.handler(buffer -> {
                   System.out.println(buffer.toString());
               });
           }else {
               System.out.println("Failed to connect: " + res.cause().getMessage());
           }
        });
    }


    public static void main(String[] args) {
        TcpTest test = new TcpTest();
        test.testNetServer();
        test.testNetServerClient();
    }
}
