package com.jiaoluokeji.games.soccerwinningfans.mode_login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * Created by Administrator on 2018\3\14 0014.
 */

public class RegisterActivity extends AppCompatActivity {
    private TextView register_name_text;
    private TextView register_psw_text;
    private Button register_loginBtn;
    private Button register_registerBtn;
    private EditText register_name;
    private EditText register_psw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_name_text = findViewById(R.id.register_name_text);
        register_psw_text = findViewById(R.id.register_psw_text);
        register_loginBtn = findViewById(R.id.register_loginBtn);
        register_registerBtn = findViewById(R.id.register_registerBtn);
        register_name = findViewById(R.id.register_name);
        register_psw = findViewById(R.id.register_psw);


        register_registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerRequest(register_name.getText().toString(), register_psw.getText().toString());
            }
        });

        //绑定点击事件监听（这里用的是匿名内部类创建监听）
        register_loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

//                Toast toast = Toast.makeText(getApplicationContext(),"登录", Toast.LENGTH_SHORT);//提示被点击了
//                toast.show();
//                activity.setContentView(R.layout.activity_login);


                MainActivity.switchActivity(RegisterActivity.this, LoginActiviry.class);



            }
        });
    }

    private void registerRequest(String name, String psw){
        JSONObject json = new JSONObject();
        json.put("msgid", MessageId.REGISTER_REQUEST );
        json.put("name", name);
        json.put("psw", psw);
        json.put("err_code", ErrorCodeGame.SUCCESS);
        NettyClient.send(json.toString());

        GlobalVar.name = name;
    }
}
