package com.jiaoluokeji.games.soccerwinningfans.mode_login;

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

import com.alibaba.fastjson.JSONObject;
import com.jiaoluokeji.games.soccerwinningfans.MainActivity;
import com.jiaoluokeji.games.soccerwinningfans.R;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.ErrorCodeGame;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.MessageId;
import com.jiaoluokeji.games.soccerwinningfans.socket_layer.NettyClient;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2018\3\14 0014.
 */

public class LoginActiviry extends AppCompatActivity {

    private TextView mTextMessage;

    private TextView message;
    private TextView login_name_text;
    private TextView login_psw_text;

    private Button loginBtn;
    private Button registerBtn;
    private EditText login_name;
    private EditText login_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        message = findViewById(R.id.login_message);
        login_name_text = findViewById(R.id.login_name_text);
        login_psw_text = findViewById(R.id.login_psw_text);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);
        login_name = findViewById(R.id.login_name);
        login_psw = findViewById(R.id.login_psw);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                Toast toast = Toast.makeText(activity.getApplicationContext(),"你点击了"+"次"+login_name.getText()+" "+login_psw.getText(), Toast.LENGTH_LONG);//提示被点击了
//
//                toast = Toast.makeText(activity.getApplicationContext(), getHostIP(), Toast.LENGTH_LONG);//提示被点击了
////                loginRequest(login_name.getText().toString(), login_psw.getText().toString());
////                getIPAddress(activity.getApplicationContext());
//                toast.show();

                loginRequest(login_name.getText().toString(), login_psw.getText().toString());


            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            //            boolean isEnabledLoginBtn = false;
            @Override
            public void onClick(View view) {

//                Toast toast = Toast.makeText(getApplicationContext(),"注册", Toast.LENGTH_SHORT);//提示被点击了
//                toast.show();



                MainActivity.switchActivity(LoginActiviry.this, RegisterActivity.class);//


            }
        });




    }

    private void loginRequest(String name, String psw){
        JSONObject json = new JSONObject();
        json.put("msgid", MessageId.LOGIN_REQUEST);
        json.put("name", name);
        json.put("psw", psw);
        json.put("err_code", ErrorCodeGame.SUCCESS);
        NettyClient.send(json.toString());
        GlobalVar.name = name;
    }


    public static String getHostIP() {

        String hostIp = null;
        try {
            Enumeration nis = NetworkInterface.getNetworkInterfaces();
            InetAddress ia = null;
            while (nis.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration<InetAddress> ias = ni.getInetAddresses();
                while (ias.hasMoreElements()) {
                    ia = ias.nextElement();
                    if (ia instanceof Inet6Address) {
                        continue;// skip ipv6
                    }
                    String ip = ia.getHostAddress();
                    if (!"127.0.0.1".equals(ip)) {
                        hostIp = ia.getHostAddress();
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            Log.i("yao", "SocketException");
            e.printStackTrace();
        }
        return hostIp;
    }


}
