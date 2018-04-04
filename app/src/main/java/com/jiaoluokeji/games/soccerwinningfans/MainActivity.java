package com.jiaoluokeji.games.soccerwinningfans;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jiaoluokeji.games.soccerwinningfans.mode_login.GlobalVar;
import com.jiaoluokeji.games.soccerwinningfans.mode_login.Login;
import com.jiaoluokeji.games.soccerwinningfans.mode_login.LoginActiviry;
import com.jiaoluokeji.games.soccerwinningfans.mode_login.Register;
import com.jiaoluokeji.games.soccerwinningfans.mode_login.RegisterActivity;
import com.jiaoluokeji.games.soccerwinningfans.socket_layer.NettyClient;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {
    /** 初始化状态 */
    private static boolean is_init = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_login);

        init();


        MainActivity.switchActivity(MainActivity.this, LoginActiviry.class);

    }

    private void init() {
        try {
            if(!is_init){
                is_init = true;
//            new Login().onClickListener(this);
//            new Register().onClickListener(this);

                new NettyClient().init();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void switchActivity(AppCompatActivity packageContext, Class<?> cls){
        if(null == GlobalVar.currentContext){
            GlobalVar.currentContext = packageContext;
        }
        //新建一个Intent对象
        Intent intent = new Intent();
        //指定intent要启动的类
        intent.setClass(GlobalVar.currentContext, cls);
        GlobalVar.currentContext.startActivity(intent);
        //关闭当前Activity
        GlobalVar.currentContext.finish();


    }

}
