package com.jiaoluokeji.games.soccerwinningfans.mode_login;

import android.util.Log;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.jiaoluokeji.games.soccerwinningfans.MainActivity;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.ErrorCodeGame;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.MessageId;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.ProtocolRequest;
import com.jiaoluokeji.games.soccerwinningfans.socket_layer.NettyClient;

/**
 * Created by Administrator on 2018\3\9 0009.
 */

public class Login {

    public void loginResponse(JSONObject responseInfo){
        responseInfo.put("msgid", MessageId.LOGIN_REQUEST );
        int err_code = responseInfo.getIntValue("err_code");
        if(ErrorCodeGame.SUCCESS != err_code){
            Log.e("loginResponse: ", ErrorCodeGame.SYSTEM_ERROR+"");
            return;
        }
        String uuid = responseInfo.getString("uuid");
        if(StringUtils.isEmpty(uuid) ) {
            Log.e("loginResponse: ", ErrorCodeGame.SYSTEM_ERROR+"");
            return;
        }
        GlobalVar.uuid = uuid;


        ProtocolRequest.getInstance().favoritePlayer(GlobalVar.uuid);
        //下面转移到登录后response的接口去切换界面
        MainActivity.switchActivity(null, GameStartActivity.class);
        Log.i("loginResponse: ","登录成功");





    }



//    private TextView message;
//    private TextView login_name_text;
//    private TextView login_psw_text;
//
//    private Button loginBtn;
//    private Button registerBtn;
//    private EditText login_name;
//    private EditText login_psw;
//
//    public Login(){
//
//    }
//
//    public void onClickListener(final MainActivity activity){
//        message = activity.findViewById(R.id.login_message);
//        login_name_text = activity.findViewById(R.id.login_name_text);
//        login_psw_text = activity.findViewById(R.id.login_psw_text);
//        loginBtn = activity.findViewById(R.id.loginBtn);
//        registerBtn = activity.findViewById(R.id.registerBtn);
//        login_name = activity.findViewById(R.id.login_name);
//        login_psw = activity.findViewById(R.id.login_psw);
//        //修改button的名字
////        loginBtn.setText("点我咯");
//        //绑定点击事件监听（这里用的是匿名内部类创建监听）
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Toast toast = Toast.makeText(activity.getApplicationContext(),"你点击了"+"次"+login_name.getText()+" "+login_psw.getText(), Toast.LENGTH_LONG);//提示被点击了
//
//                toast = Toast.makeText(activity.getApplicationContext(), getHostIP(), Toast.LENGTH_LONG);//提示被点击了
//                loginRequest(login_name.getText().toString(), login_psw.getText().toString());
////                getIPAddress(activity.getApplicationContext());
//                toast.show();
//
//
//            }
//        });
//
//        registerBtn.setOnClickListener(new View.OnClickListener() {
////            boolean isEnabledLoginBtn = false;
//            @Override
//            public void onClick(View view) {
//
////                Toast toast = Toast.makeText(activity.getApplicationContext(),"你点击了"+"次"+login_name.getText()+" "+login_psw.getText(), Toast.LENGTH_LONG);//提示被点击了
////                boolean isEnabledLoginBtn = loginBtn.isEnabled();
////                loginBtn.setEnabled(!isEnabledLoginBtn);
////                isEnabledLoginBtn = loginBtn.isEnabled();
////                if(isEnabledLoginBtn){
////                    loginBtn.offsetLeftAndRight(1000);
////                    registerBtn.offsetLeftAndRight(100);
//////                    loginBtn.offsetTopAndBottom(-200);
////                    message.setText("Login");
//////                    registerBtn.setText("REGISTER");
////
//////                    registerBtn.offsetTopAndBottom(-200);
////                }else{
////                    loginBtn.offsetLeftAndRight(-1000);
////                    registerBtn.offsetLeftAndRight(-100);
////                    message.setText("REGISTER");
//////                    registerBtn.setText("SUBMIT REGISTER");
////
//////                    loginBtn.offsetTopAndBottom(200);
//////                    registerBtn.offsetTopAndBottom(200);
////                }
////                toast = Toast.makeText(activity.getApplicationContext(), loginBtn.getText().toString(), Toast.LENGTH_LONG);//提示被点击了
////                toast.show();
//
//
////                activity.setContentView(R.layout.activity_register);
//
//
//                Toast toast = Toast.makeText(activity.getApplicationContext(),"你", Toast.LENGTH_LONG);//提示被点击了
//                toast.show();
//
////                    //新建一个Intent对象
////                     Intent intent =new Intent();
////                     //指定intent要启动的类
////                     intent.setClass(activity, RegisterActivity.class);
////                    activity.startActivity(intent);
////                     //关闭当前Activity
////                    activity.finish();
//
//
//            }
//        });
//
//    }
//
//    private void loginRequest(String name, String psw){
//        JSONObject json = new JSONObject();
//        json.put("msgid", MessageId.LOGIN_REQUEST );
//        json.put("name", name);
//        json.put("psw", psw);
//        NettyClient.send(json.toString());
//    }
//
//    public void loginResponse(JSONObject requestInfo, JSONObject responseInfo){
//
//
//    }
//
//
//    public static String getHostIP() {
//
//        String hostIp = null;
//        try {
//            Enumeration nis = NetworkInterface.getNetworkInterfaces();
//            InetAddress ia = null;
//            while (nis.hasMoreElements()) {
//                NetworkInterface ni = (NetworkInterface) nis.nextElement();
//                Enumeration<InetAddress> ias = ni.getInetAddresses();
//                while (ias.hasMoreElements()) {
//                    ia = ias.nextElement();
//                    if (ia instanceof Inet6Address) {
//                        continue;// skip ipv6
//                    }
//                    String ip = ia.getHostAddress();
//                    if (!"127.0.0.1".equals(ip)) {
//                        hostIp = ia.getHostAddress();
//                        break;
//                    }
//                }
//            }
//        } catch (SocketException e) {
//            Log.i("yao", "SocketException");
//            e.printStackTrace();
//        }
//        return hostIp;
//    }

}
