package com.hentian.demo.TestMina.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

public class MinaServer {
 
    private static final int Port = 8888;
    public void startMinaServer() {
        IoAcceptor ioAcceptor = new NioSocketAcceptor();//创建连接socket接收器
        System.out.println("server start to start(服务器开始启动)!");
        //创建接受数据的过滤器
        DefaultIoFilterChainBuilder defaultIoFilterChainBuilder = ioAcceptor.getFilterChain();
        defaultIoFilterChainBuilder.addLast("logger", new LoggingFilter());//添加日志记录
      //设定这个过滤器将一行一行的读取数据
        defaultIoFilterChainBuilder.addLast("codec",
        	new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        System.out.println("config the filter chain finished!(配置过滤链完成)");
        // 指定业务逻辑处理器  
        ioAcceptor.setHandler(new FirstServerHandler());
        System.out.println("setting the handler finished(设置处理器完成)!");
        //配置Session
        IoSessionConfig ioSessionConfig = ioAcceptor.getSessionConfig();
      //设置读取数据缓存单位byte  
        ioSessionConfig.setReadBufferSize(2048);
      //设置多长时间后接收器开始空闲
        ioSessionConfig.setIdleTime(IdleStatus.BOTH_IDLE, 10);
        System.out.println("config the session finished(配置会话结束)!");
 
        //绑定端口
        try {
            ioAcceptor.bind(new InetSocketAddress(Port));
            //启动监听  
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        System.out.println("start finish!");
    }
 
    public static void main(String[] args) {
        MinaServer server = new MinaServer();
        server.startMinaServer();
    }
}