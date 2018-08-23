package com.hentian.demo.TestMina.server;

import java.util.List;
import imix.ConfigError;
import imix.DataDictionary;
import imix.FieldNotFound;
import imix.Group;
import imix.InvalidMessage;
import imix.Message;
import imix.field.BeginString;
import imix.field.BodyLength;
import imix.field.CheckSum;
import imix.field.MsgSeqNum;
import imix.field.MsgType;
import imix.field.NoPartyIDs;
import imix.field.NoPartySubIDs;
import imix.field.PartyID;
import imix.field.PartyRole;
import imix.field.PartySubID;
import imix.field.PartySubIDType;
import imix.field.SenderCompID;
import imix.field.SendingTime;
import imix.field.TargetCompID;
import imix.field.TransactTime;

/*import java.util.List;

import com.sun.jdmk.trace.Trace;

import imix.ConfigError;
import imix.DataDictionary;
import imix.FieldNotFound;
import imix.Group;
import imix.InvalidMessage;
import imix.Message;
import imix.common.field.BeginString;
import imix.common.field.BodyLength;
import imix.common.field.CheckSum;
import imix.common.field.MsgSeqNum;
import imix.common.field.NoPartyIDs;
import imix.common.field.NoPartySubIDs;
import imix.common.field.PartyID;
import imix.common.field.PartyRole;
import imix.common.field.PartySubID;
import imix.common.field.PartySubIDType;
import imix.common.field.SenderCompID;
import imix.common.field.SendingTime;
import imix.common.field.TargetCompID;
import imix.common.field.TransactTime;*/

public class TestAnalysisjava2 {

	public  void TestTostring(String msgStr) throws InvalidMessage, ConfigError, FieldNotFound {
		
		Message msg=new Message();
		msg.fromString(msgStr,new DataDictionary("IMIX10.xml") ,true);//将msgStr普通字符串转化为报文报文
		//解析报文头
		StringBuffer sb=new StringBuffer();
		String beginStr=msg.getHeader().getString(BeginString.FIELD);
		String bodyLenStr=msg.getHeader().getString(BodyLength.FIELD);
		String msgTypeStr=msg.getHeader().getString(MsgType.FIELD);
		String msgSeqNumStr=msg.getHeader().getString(MsgSeqNum.FIELD);
		String sendingTimeStr=msg.getHeader().getString(SendingTime.FIELD);
		String senderCompIDStr=msg.getHeader().getString(SenderCompID.FIELD);
		String targetCompIDStr=msg.getHeader().getString(TargetCompID.FIELD);
		
		sb.append("--beginStr:").append(beginStr+"\n");
		sb.append("--bodyLenStr:").append(bodyLenStr+"\n");
		sb.append("--msgTypeStr:").append(msgTypeStr+"\n");
		sb.append("--msgSeqNumStr:").append(msgSeqNumStr+"\n");
		sb.append("--sendingTimeStr:").append(sendingTimeStr+"\n");
		sb.append("--senderCompIDStr:").append(senderCompIDStr+"\n");
		sb.append("--targetCompIDStr:").append(targetCompIDStr+"\n");
		System.out.println("++++++++++++++message header++++++++++++");
		System.out.println(sb.toString());
		sb.delete(0,sb.length()-1);
		//解析报文体
		String transactTimeStr=msg.getString(TransactTime.FIELD);
		sb.append("--transactTimeStr:").append(transactTimeStr+"\n");
		List<Group>topGroups=msg.getGroups(NoPartyIDs.FIELD);
		for(Group topGroup:topGroups){
			String partyIDStr=topGroup.getString(PartyID.FIELD);
			String partyRoleStr=topGroup.getString(PartyRole.FIELD);
			sb.append("----partyIDStr:").append(partyIDStr+"\n");
			sb.append("----partyRoleStr:").append(partyRoleStr+"\n");
			
			List<Group>subGroups=topGroup.getGroups(NoPartySubIDs.FIELD);
			for(Group subGroup:subGroups){
				String partySubIDStr=subGroup.getString(PartySubID.FIELD);
				String partySubIDTypeStr=subGroup.getString(PartySubIDType.FIELD);
				sb.append("----partySubIDStr:").append(partySubIDStr+"\n");
				sb.append("----partySubIDTypeStr:").append(partySubIDTypeStr+"\n");
			}
		}
		System.out.println("++++++++message body++++++++++");
		System.out.println(sb.toString().trim());
		sb.delete(0,sb.length()-1);
		//解析报文尾
		String trailerStr=msg.getTrailer().getString(CheckSum.FIELD);
		System.out.println("+++++++++message trailer+++++++++++++++");
		sb.append("--trailerStr:").append(trailerStr+"\n");
		System.out.println(sb.toString().trim());
	}

	
}