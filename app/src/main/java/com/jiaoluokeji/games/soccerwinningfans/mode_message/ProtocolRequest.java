package com.jiaoluokeji.games.soccerwinningfans.mode_message;

import com.alibaba.fastjson.JSONObject;
import com.jiaoluokeji.games.soccerwinningfans.mode_login.GlobalVar;
import com.jiaoluokeji.games.soccerwinningfans.socket_layer.NettyClient;

/**
 * Created by Administrator on 2018\3\30 0030.
 */

public class ProtocolRequest implements IProtocolRequest{
    public static ProtocolRequest getInstance(){
        return new ProtocolRequest();
    }



    @Override
    public void favoritePlayer(String uuid) {
        JSONObject json = new JSONObject();
        json.put("msgid", MessageId.TODAY_MATCH_LIST_REQUEST);
        json.put("uuid", uuid);
        json.put("err_code", ErrorCodeGame.SUCCESS);
        NettyClient.send(json.toString());
    }

    @Override
    public void todayMatchList() {

    }

    @Override
    public void transferTop3() {

    }

    @Override
    public void transferSearch() {

    }

    @Override
    public void transferLatest() {

    }

    @Override
    public void playerInfo() {

    }

    @Override
    public void myPokect() {

    }

    @Override
    public void transferBorrow() {

    }

    @Override
    public void setting() {

    }

    @Override
    public void heart() {

    }
}
