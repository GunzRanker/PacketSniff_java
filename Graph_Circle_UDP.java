/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_UDP extends JDialog{
	int udp_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_UDP D_UDP;
	Graph_Circle_UDP()
	{
	
		udp_packet_count = in.tot_count_udp; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_UDP = new Dialog_Circle_UDP(this,"UDP Circle Graph");
		D_UDP.setVisible(true);
	
	}
	class Dialog_Circle_UDP extends JDialog
	{
		
		Dialog_Circle_UDP(Graph_Circle_UDP graph_Circle_UDP,String title)
		{
			super(graph_Circle_UDP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/