package com.hentian.demo.TestMina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class FirstClientHandler extends IoHandlerAdapter {
 //客户端发生异常
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("here got a exception(有一个异常)!!!");
        super.exceptionCaught(session, cause);
    }
 //客户端接收到的信息为
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("received a message（接收到的消息是：）: " + message.toString());
        super.messageReceived(session, message);
    }
 //发送的信息为
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("sent a message（发送一个信息）: " + message.toString());
        super.messageSent(session, message);
    }
 //会话建立
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("session created（通话创建成功）!!!");
        super.sessionCreated(session);
    }
    //会话连接成功
    @Override
    	public void sessionOpened(IoSession session) throws Exception {
    		// TODO Auto-generated method stub
    		super.sessionOpened(session);
    		System.out.println("会话连接成功");
    	}
}