package org.example.yesdrive.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread().getName());
        ByteBuf byteBuf = Unpooled.directBuffer(100);
        byteBuf.writeBytes("hahaha".getBytes(StandardCharsets.UTF_8));
        ctx.channel().writeAndFlush(byteBuf);
    }
}
