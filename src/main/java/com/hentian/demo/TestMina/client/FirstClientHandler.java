package com.hentian.demo.TestMina.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class FirstClientHandler extends IoHandlerAdapter {
 //客户端发生异常
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        System.out.println("here got a exception!!!");
        super.exceptionCaught(session, cause);
    }
 //客户端接收到的信息为
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        System.out.println("received a message: " + message.toString());
        super.messageReceived(session, message);
    }
 //发送的信息为
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        System.out.println("sent a message: " + message.toString());
        super.messageSent(session, message);
    }
 //会话建立
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        System.out.println("session created!!!");
        super.sessionCreated(session);
    }
}