package com.hentian.demo.TestMina.client;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class MinaClient {
    private SocketConnector connector;
    private ConnectFuture future;
    private IoSession session; 
    private String server_address = "127.0.0.1";
    private int server_port = 8888;
    //建立lianjie
    public boolean connect() {
        connector = new NioSocketConnector();//创立连接 
        DefaultIoFilterChainBuilder defaultIoFilterChainBuilder = connector.getFilterChain(); 
        defaultIoFilterChainBuilder.addLast("logger", new LoggingFilter());
      //添加消息过滤器
        defaultIoFilterChainBuilder.addLast("codec", 
        		new ProtocolCodecFilter(
        		new TextLineCodecFactory(Charset.forName("UTF-8"))
        		));
        connector.setHandler(new FirstClientHandler());//添加业务处理
        future = connector.connect(new InetSocketAddress(server_address, server_port));
        future.awaitUninterruptibly();
        session = future.getSession();
        session.getConfig().setUseReadOperation(true);
        return future.isConnected();
    }
 //传送内容
    public void sendMssageToServer(String message) {
        session.write(message);//通信内容传过去
    }
 //关闭连接
    public boolean close() {
        CloseFuture closeFuture = session.getCloseFuture();
        closeFuture.awaitUninterruptibly(1000);
        connector.dispose();
        return true;
    }
 
    public static void main(String[] args) {
        MinaClient client = new MinaClient();
        client.connect();
 
        String readLine = "";
        Scanner in = new Scanner(System.in);
        do {
            readLine = in.nextLine();
            if(readLine.equals("hui")) {
            	TestGeneratejava2 t=new TestGeneratejava2();
            	readLine=t.get();
            }
            client.sendMssageToServer(readLine);
            
        }while(!readLine.toLowerCase().equals("quit"));
        client.close();
    }
}