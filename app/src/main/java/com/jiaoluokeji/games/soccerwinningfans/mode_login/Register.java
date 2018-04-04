package com.jiaoluokeji.games.soccerwinningfans.mode_login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.jiaoluokeji.games.soccerwinningfans.MainActivity;
import com.jiaoluokeji.games.soccerwinningfans.R;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.ErrorCodeGame;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.MessageId;
import com.jiaoluokeji.games.soccerwinningfans.socket_layer.NettyClient;

/**
 * Created by Administrator on 2018\3\14 0014.
 */

public class Register {

    public void registerResponse(JSONObject responseInfo){
//        responseInfo.put("")
//        JSONObject json = new JSONObject();
        int err_code = responseInfo.getIntValue("err_code");
        if(ErrorCodeGame.SUCCESS != err_code){
            Log.e("registerResponse: ", ErrorCodeGame.SUCCESS+"");
            return;
        }
        String uuid = responseInfo.getString("uuid");
        responseInfo.put("msgid", MessageId.LOGIN_REQUEST );
        responseInfo.put("uuid", uuid);
        responseInfo.put("name", GlobalVar.name);

    }


//    private TextView register_name_text;
//    private TextView register_psw_text;
//    private Button register_loginBtn;
//    private Button register_registerBtn;
//    private EditText register_name;
//    private EditText register_psw;
//
//    public void onClickListener(final MainActivity activity) {
//        register_name_text = activity.findViewById(R.id.register_name_text);
//        register_psw_text = activity.findViewById(R.id.register_psw_text);
//        register_loginBtn = activity.findViewById(R.id.register_loginBtn);
//        register_registerBtn = activity.findViewById(R.id.register_registerBtn);
//        register_name = activity.findViewById(R.id.register_name);
//        register_psw = activity.findViewById(R.id.register_psw);
//        //修改button的名字
////        loginBtn.setText("点我咯");
//
//        register_registerBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                registerRequest(register_name_text.getText().toString(), register_psw_text.getText().toString());
//            }
//        });
//
//        //绑定点击事件监听（这里用的是匿名内部类创建监听）
//        register_loginBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Toast toast = Toast.makeText(activity.getApplicationContext(),"你", Toast.LENGTH_LONG);//提示被点击了
//                toast.show();
////                activity.setContentView(R.layout.activity_login);
//
//            }
//        });
//
//    }
//
//    private void registerRequest(String name, String psw){
//        JSONObject json = new JSONObject();
//        json.put("msgid", MessageId.REGISTER_REQUEST );
//        json.put("id", name);
//        json.put("psw", psw);
//        NettyClient.send(json.toString());
//    }

}
