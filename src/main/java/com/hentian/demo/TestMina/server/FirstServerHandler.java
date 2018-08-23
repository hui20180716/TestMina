package com.hentian.demo.TestMina.server;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import imix.ConfigError;
import imix.FieldNotFound;
import imix.InvalidMessage;

public class FirstServerHandler extends IoHandlerAdapter{
 //捕获异常
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
       // IoService
    }
 
    private static int message_count = 1;
    //消息接收 处理报文  message :消息
    @Override
    public void messageReceived(IoSession session, Object message) throws InvalidMessage, ConfigError, FieldNotFound {
    	TestAnalysisjava2 ms=new TestAnalysisjava2();
        System.out.println("receive a message.");
        
        String string = message.toString();
        if(string.trim().toLowerCase().equals("quit")) {
            session.close(true);
            return;
        }
        if(string.trim().startsWith("8")) {
        	System.err.println("可能是一条报文");
        	ms.TestTostring(string);
        	
        }
        if(string.startsWith("o")) {
        	System.err.println("可能是 o ");
        }
        System.out.println("received message:" + string);
        session.write("you are the no. " + message_count + " message!!!");
        message_count++;
        System.out.println("send back finished!!!");
    }
 //处理报文
    @Override
    public void messageSent(IoSession session, Object message) throws InvalidMessage, ConfigError, FieldNotFound{
    	
    	String str = message.toString();
        System.err.println("message have been sent :" + str);
        System.out.println();
    }
 
    @Override
    public void sessionClosed(IoSession session) {
        System.out.println("closed Session!");
    }
 
    @Override
    public void sessionCreated(IoSession session) {
        System.out.println("created session!");
    }
 //会话空闲
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) {
        System.out.println("IDLE " + session.getIdleCount(status));
        System.out.println();
    }
 
    @Override
    public void sessionOpened(IoSession session) {
        System.out.println("opened session!(有一个客户接入)");
        System.out.println();
    }
}