package org.example.yesdrive.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class TestHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof ByteBuf){
            System.out.println(((ByteBuf)msg).toString(Charset.defaultCharset()));
        }
        ctx.channel().writeAndFlush(Thread.currentThread().getName());
    }
}
