package com.jiaoluokeji.games.soccerwinningfans.mode_message;

import com.alibaba.fastjson.JSONObject;
import com.jiaoluokeji.games.soccerwinningfans.mode_login.Login;
import com.jiaoluokeji.games.soccerwinningfans.mode_login.Register;
import com.jiaoluokeji.games.soccerwinningfans.socket_layer.NettyClient;

import io.netty.channel.Channel;

/**
 * Created by Administrator on 2018\3\13 0013.
 */

public class Protocol {
    Protocol protocol;
    private static Channel channel ;

    public Protocol(){
        channel = NettyClient.channel;
    }



    public static Protocol getInstance(){
        return new Protocol();
    }

    public void responseProtocol(int messageId, JSONObject responseInfo){

        switch (messageId){
            case MessageId.LOGIN_RESPONSE:
                new Login().loginResponse(responseInfo);
                break;
            case MessageId.REGISTER_RESPONSE:
                new Register().registerResponse(responseInfo);
                break;
            case MessageId.HEART_REQUEST:
                JSONObject json = new JSONObject();
                json.put("msgid", MessageId.HEART_REQUEST);
                NettyClient.send(json.toString());
                break;





            default:
                break;

        }
//        NettyClient.send(responseInfo.toString());

    }



}
