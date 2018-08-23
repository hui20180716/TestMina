package com.hentian.demo.TestMina.client;

import imix.DataDictionary;
import imix.Group;
import imix.Message;

public class TestGeneratejava2 {
	public String get() {
		String str=null;
		Message m=new Message();
		//报文头
		m.getHeader().setString(8,"IMIX.1.0");
		m.getHeader().setString(9,"1");
		m.getHeader().setString(35,"6");
		m.getHeader().setString(34,"24");
		m.getHeader().setString(52,"20070820-12:40:00");
		m.getHeader().setString(49,"CFETS-RMB-CSTP");
		m.getHeader().setString(56,"EX-HUB");
		//报文体
		m.setString(60,"20070821-12:40:00.000");
		
		Group g_453=new Group(453,448);
		g_453.setString(448,"XXXX");
		g_453.setString(452,"101");		
		Group g_802=new Group(802,523);
		g_802.setString(523,"XXXX");
		g_802.setString(803,"101");
		g_453.addGroup(g_802);
		g_802.setString(523,"XXXX");
		g_802.setString(803,"124");
		g_453.addGroup(g_802);
		g_802.setString(523,"XXXX");
		g_802.setString(803,"125");
		g_453.addGroup(g_802);
		g_802.setString(523,"CFETS");
		g_802.setString(803,"29");
		g_453.addGroup(g_802);
		m.addGroup(g_453);	
		g_453.clear();
		g_802.clear();
		/*********第一组结束*******/
		
		g_453.setString(448,"XXXX");
		g_453.setString(452,"102");
		g_802.setString(523,"XXXX");
		g_802.setString(803,"101");
		g_453.addGroup(g_802);
		g_802.setString(523,"XXXX");
		g_802.setString(803,"125");
		g_453.addGroup(g_802);
		g_802.setString(523,"CFETS");
		g_802.setString(803,"29");
		g_453.addGroup(g_802);
		
		m.addGroup(g_453);
		g_453.clear();
		g_802.clear();
		g_453.setString(448,"XXXX");
		g_453.setString(452,"102");
		g_802.setString(523,"XXXX");
		g_802.setString(803,"101");
		g_453.addGroup(g_802);
		g_802.setString(523,"XXXX");
		g_802.setString(803,"125");
		g_453.addGroup(g_802);
		g_802.setString(523,"CFETS");
		g_802.setString(803,"29");
		g_453.addGroup(g_802);
			
		m.addGroup(g_453);
		g_453.clear();
		g_802.clear();
		/*********第一组结束*******/
		//报文尾
		m.getTrailer().setString(10, "50");
		try {
			m.verify(new DataDictionary("IMIX10.xml"));
			str=m.toString();
			//System.out.println(m.toXML());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	}

