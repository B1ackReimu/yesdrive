package org.example.yesdrive.test.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SecondHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("SecondHandler:"+Thread.currentThread().getName());
        long l = System.currentTimeMillis();
        for (; ; ) {
            if (System.currentTimeMillis() - l > 20000) {
                break;
            }
        }
        System.out.println("ok!");
    }
}
