package org.example.yesdrive.file.read.serv.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.Arrays;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        try {
            while (in.isReadable()){
                System.out.println(in.toString(CharsetUtil.UTF_8));
                System.out.println(Arrays.toString(this.getClass().getDeclaredMethods()));
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }


}
