/**
 * 
 */
package com.jiaoluokeji.games.soccerwinningfans.socket_layer;

import android.util.Log;



import com.alibaba.fastjson.JSONObject;
import com.jiaoluokeji.games.soccerwinningfans.mode_message.Protocol;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * @author wangyu
 *
 */
public class MyBusinessLogicHandler extends SimpleChannelInboundHandler<String>  {
//	private final static Logger logger = LoggerFactory.getLogger(MyBusinessLogicHandler.class);
	private int a;
//	private User user;
//	private Team team;
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg)throws Exception {
		a++;
//		if(0 == a%30){
//			ToString.println(msg, ctx.channel().remoteAddress(),ctx.pipeline().channel().hashCode());
//		}
		Log.e("channelRead0: ", msg);


		JSONObject json = JSONObject.parseObject(msg);
		int msgid = json.getIntValue("msgid");
		Protocol.getInstance().responseProtocol(msgid, json);




//		String msgid = json.getString("msgid");
//		MessageId messageId = MessageId.valueOf(msgid);
//		switch (messageId) {
//		case login:
//			Login.getInstance().login(json);
//			break;
//		case register:
//			Login.getInstance().register(json);
//			ctx.write(3);
//			break;
//		case createClub:
//			ClubImpl.getInstance().creatClub(json);
//			break;
//		case getYMDTime:
//			TimeImpl.getInstance().getTime();
//			break;
//
//
//		default:
//			break;
//		}
		
		
	}



	


}
