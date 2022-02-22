package org.example.yesdrive.test.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class FirstHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("FirstHandler:" + Thread.currentThread().getName());
        long l = System.currentTimeMillis();
        for (; ; ) {
            if (System.currentTimeMillis() - l > 20000) {
                break;
            }
        }
        super.channelRead(ctx, msg);
    }
}
