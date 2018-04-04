package com.jiaoluokeji.games.soccerwinningfans.socket_layer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by Administrator on 2018\3\9 0009.
 */

public class NettyClientFilter extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline ph = ch.pipeline();
        /*
         * 解码和编码，应和服务端一致
         * */
        ph.addLast("framer", new DecoderByLengthFieldBasedFrameDecoder(1024*1024, 4, 4, 4, 8));
        ph.addLast("decoder", new StringDecoder());
        ph.addLast("encoder", new StringEncoder());
        ph.addLast("handler", new MyBusinessLogicHandler()); //客户端的逻辑



//        ch.pipeline().addLast(workerGroup,"codec",new DecoderByLengthFieldBasedFrameDecoder(1024*1024, 4, 4, 4, 8));
//        ch.pipeline().addLast(workerGroup,"handle", new MyBusinessLogicHandler());

    }
}
