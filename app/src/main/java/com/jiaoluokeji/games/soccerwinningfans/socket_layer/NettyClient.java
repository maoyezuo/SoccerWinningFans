package com.jiaoluokeji.games.soccerwinningfans.socket_layer;

import com.alibaba.fastjson.JSONObject;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.MessageId;

import java.io.IOException;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by Administrator on 2018\3\9 0009.
 */

public class NettyClient {
    public static final String host = "192.168.21.51";  //ip地址
    public static final int port = 18080;          //端口
    /// 通过nio方式来接收连接和处理连接
    public static EventLoopGroup group = new NioEventLoopGroup();
    private static  Bootstrap bootstrap = new Bootstrap();
    public static Channel channel;

    public NettyClient() throws Exception{
//        init();
    }

    public void init() throws Exception{
        new Thread(){
            @Override
            public void run() {

                try {
                    EventLoopGroup group = new NioEventLoopGroup();
                    System.out.println("客户端成功启动...");
                    Bootstrap bootstrap = new Bootstrap();
                    bootstrap.group(group);
                    bootstrap.channel(NioSocketChannel.class);
                    bootstrap.handler(new NettyClientFilter());
                    // 连接服务端
                    channel = bootstrap.connect(host, port).sync().channel();



                    channel.closeFuture().sync();
//                    8.优雅释放
                    group.shutdownGracefully();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }

    public static void send(String content){
        int total = 4 + 4 + content.getBytes().length;
        ByteBuf byteBuf = Unpooled.buffer(total);
        byteBuf.writeInt(total);
        byteBuf.writeInt(content.getBytes().length);
        byteBuf.writeBytes(content.getBytes());
        channel.writeAndFlush(new String(byteBuf.array()));


//        String s = "";
//        JSONObject json = new JSONObject();
//        json.put("msgid", MessageId.LOGIN_REQUEST );
//        json.put("msg", "日日日日日日");
//        json.put("numc", 1);
//        s = json.toString();
//        int total = 4 + 4 + s.getBytes().length;
//        ByteBuf byteBuf = Unpooled.buffer(total);
//        byteBuf.writeInt(total);
//        byteBuf.writeInt(s.getBytes().length);
//        byteBuf.writeBytes(s.getBytes());
//        channel.writeAndFlush(new String(byteBuf.array()));
    }

}
