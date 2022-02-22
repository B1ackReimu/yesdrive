package org.example.yesdrive.test.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class StartClient {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {

            NioEventLoopGroup workerGroup = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap
                    // 1.指定线程模型
                    .group(workerGroup)
                    // 2.指定 IO 类型为 NIO
                    .channel(NioSocketChannel.class)
                    // 3.IO 处理逻辑
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });
            // 4.建立连接
            bootstrap.connect("127.0.0.1", 8080).addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("连接成功!");
                } else {
                    System.err.println("连接失败!");
                    //重新连接
                }
            });
        }
    }

}
