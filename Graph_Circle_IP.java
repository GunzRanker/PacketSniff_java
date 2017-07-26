/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_IP extends JDialog{
	int ip_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_IP D_IP;
	Graph_Circle_IP()
	{
	
		ip_packet_count = in.tot_count_ip; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_IP = new Dialog_Circle_IP(this,"IP Circle Graph");
		D_IP.setVisible(true);
	
	}
	class Dialog_Circle_IP extends JDialog
	{
		
		Dialog_Circle_IP(Graph_Circle_IP graph_Circle_IP,String title)
		{
			super(graph_Circle_IP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/