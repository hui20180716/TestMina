package com.hentian.demo.TestMina.client;

import imix.FieldNotFound;
import imix.field.AccruedInterestTotalAmt;
import imix.field.CheckSum;
import imix.field.ClOrdID;
import imix.field.ContingencyIndicator;
import imix.field.DataCategoryIndicator;
import imix.field.IOIID;
import imix.field.IOIQty;
import imix.field.IOITransType;
import imix.field.MarketIndicator;
import imix.field.PartyID;
import imix.field.PartyRole;
import imix.field.PartySubID;
import imix.field.PartySubIDType;
import imix.field.Price;
import imix.field.QuoteStatus;
import imix.field.QuoteTime;
import imix.field.QuoteType;
import imix.field.RemarkIndicator;
import imix.field.RoutingType;
import imix.field.SecurityID;
import imix.field.SettlCurrAmt2;
import imix.field.SettlType;
import imix.field.Side;
import imix.field.Text;
import imix.field.TradeLimitDays;
import imix.field.TransactTime;
import imix.field.ValidUntilTime;
import imix.imix10.IOI;
import imix.imix10.component.Parties;
import imix.imix10.component.PtysSubGrp;
import imix.imix10.component.RoutingGrp;

public class Generate01{
	public static void main(String[] args) throws FieldNotFound {
		IOI ioi = new IOI();
		//组装报文头
		ioi.getHeader().setString(8, "IMIX.1.0");
		ioi.getHeader().setString(9, "1");
		ioi.getHeader().setString(35, "6");
		ioi.getHeader().setString(34, "24");
		ioi.getHeader().setString(52, "20070820-12:40:00");
		ioi.getHeader().setString(115, "CFETS-RMB");
		ioi.getHeader().setString(49, "CFETS-RMB-CSTP");
		ioi.getHeader().setString(56, "EX-HUB");
		ioi.getHeader().setString(128, "XXXXXX");
		ioi.getHeader().setString(129, "XXXXXX");
		//组装报文体
		ioi.setField(new ClOrdID("378109457943740023"));
		ioi.setField(new TransactTime("20070821-12:40:00.000"));
		ioi.setField(new IOITransType('N'));
		ioi.setField(new IOIID("201308180110000012"));
		ioi.setField(new IOIQty("230000.00"));
		ioi.setField(new Price("0.0500"));
		ioi.setField(new SecurityID("IBO014"));
		ioi.setField(new Side('1'));
		ioi.setField(new QuoteStatus(16));
		ioi.setField(new Text("XXXX"));
		ioi.setField(new ValidUntilTime("20070821-12:40:00.000"));
		ioi.setField(new SettlType("1"));
		ioi.setField(new AccruedInterestTotalAmt("105.00"));
		ioi.setField(new ContingencyIndicator(true));
		ioi.setField(new QuoteType(0));
		ioi.setField(new MarketIndicator("1"));
		ioi.setField(new QuoteTime("20070821-12:33:34.000"));
		ioi.setField(new RemarkIndicator(true));
		ioi.setField(new SettlCurrAmt2("2400000.00"));
		ioi.setField(new TradeLimitDays("22"));
		ioi.setField(new DataCategoryIndicator(0));
		Parties.NoPartyIDs parties = new Parties.NoPartyIDs();
		parties.setField(new PartyID("XXXX"));
		parties.setField(new PartyRole(101));
		PtysSubGrp.NoPartySubIDs ptysSubGrp = new PtysSubGrp.NoPartySubIDs();
		ptysSubGrp.setField(new PartySubID("XXXX"));
		ptysSubGrp.setField(new PartySubIDType(101));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.setField(new PartySubID("XXXX"));
		ptysSubGrp.setField(new PartySubIDType(124));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.setField(new PartySubID("XXXX"));
		ptysSubGrp.setField(new PartySubIDType(125));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.setField(new PartySubID("CFETS"));
		ptysSubGrp.setField(new PartySubIDType(29));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.clear();
		parties.setField(new PartyID("XXXX"));
		parties.setField(new PartyRole(102));
		ptysSubGrp.setField(new PartySubID("XXXX"));
		ptysSubGrp.setField(new PartySubIDType(101));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.setField(new PartySubID("XXXX"));
		ptysSubGrp.setField(new PartySubIDType(125));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.setField(new PartySubID("CFETS"));
		ptysSubGrp.setField(new PartySubIDType(29));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.clear();
		parties.setField(new PartyID("XXXX"));
		parties.setField(new PartyRole(102));
		ptysSubGrp.setField(new PartySubID("XXXX"));
		ptysSubGrp.setField(new PartySubIDType(101));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.setField(new PartySubID("XXXX"));
		ptysSubGrp.setField(new PartySubIDType(125));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.setField(new PartySubID("CFETS"));
		ptysSubGrp.setField(new PartySubIDType(29));
		parties.addGroup(ptysSubGrp);
		ptysSubGrp.clear();
		ioi.addGroup(parties);
		parties.clear();
		RoutingGrp.NoRoutingIDs routingGrp = new RoutingGrp.NoRoutingIDs();
		routingGrp.setField(new RoutingType(2));
		ioi.addGroup(routingGrp);
		routingGrp.clear();
		
		//组装报文尾
		ioi.getTrailer().setField(new CheckSum("50"));
		
		System.out.println(ioi.toString());
	}
}		
		
		
		
		
		
		