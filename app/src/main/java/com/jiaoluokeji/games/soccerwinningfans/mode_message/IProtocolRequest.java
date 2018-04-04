package com.jiaoluokeji.games.soccerwinningfans.mode_message;

/**
 * Created by Administrator on 2018\3\30 0030.
 */

public interface IProtocolRequest {


    void favoritePlayer(String uuid);
    void todayMatchList();
    void transferTop3();
    void transferSearch();
    void transferLatest();
    void playerInfo();
    void myPokect();
    void transferBorrow();
    void setting();
    void heart();



}
