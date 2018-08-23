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
    //消息接收 处理报文  message :消息 Received:收到
    @Override
    public void messageReceived(IoSession session, Object message) throws InvalidMessage, ConfigError, FieldNotFound {
    	TestAnalysisjava2 ms=new TestAnalysisjava2();
        System.out.println("receive a message.(收到一条报文)");
        
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
        System.out.println("received message:（收到的消息是：）" + string);
        session.write("you are the no. （这是服务端端你是第）" + message_count + "（条信息） message!!!");
        message_count++;
        System.out.println("send back finished（送回完成）!!!");
    }
 //处理报文 Sent ：发送
    @Override
    public void messageSent(IoSession session, Object message) throws InvalidMessage, ConfigError, FieldNotFound{
    	
    	String str = message.toString();
    	//session.write("ok.>>>>>>>>>>>>>>>>>"); 自己调用自己 死循环了
        System.err.println("message have been sent（消息已发送） :" + str);
        System.out.println();
    }
 //会话关闭
    @Override
    public void sessionClosed(IoSession session) {
    	session.write("ok2>>>>>>>>>>>>>>");//应该是发不出去，因为会话已经关闭了
        System.out.println("closed Session（关闭会话）!");
    }
 //会话创建
    @Override
    public void sessionCreated(IoSession session) {
        System.out.println("created session（创建会话）!");
    }
 //会话空闲
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) {
    	session.write("你都不和我说话，，，，，，，");
        System.out.println("IDLE （不懂是啥？）" + session.getIdleCount(status));
        System.out.println();
    }
 //会话接入
    @Override
    public void sessionOpened(IoSession session) {
        System.out.println("opened session!(有一个客户接入)");
        session.write("恭喜你介入成功》》》》》》》》》》》》》》");
        System.out.println();
    }
}