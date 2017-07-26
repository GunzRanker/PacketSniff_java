/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_TELNET extends JDialog{
	int telnet_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_TELNET D_TELNET;
	Graph_Circle_TELNET()
	{
		
		telnet_packet_count = in.tot_count_telnet; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_TELNET = new Dialog_Circle_TELNET(this,"TELNET Circle Graph");
		D_TELNET.setVisible(true);
	
	}
	class Dialog_Circle_TELNET extends JDialog
	{
		
		Dialog_Circle_TELNET(Graph_Circle_TELNET graph_Circle_TELNET,String title)
		{
			super(graph_Circle_TELNET,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/