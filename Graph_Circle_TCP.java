/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_TCP extends JDialog{
	int tcp_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_TCP D_TCP;
	Graph_Circle_TCP()
	{
	
		tcp_packet_count = in.tot_count_tcp; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_TCP = new Dialog_Circle_TCP(this,"TCP Circle Graph");
		D_TCP.setVisible(true);
	
	}
	class Dialog_Circle_TCP extends JDialog
	{
		
		Dialog_Circle_TCP(Graph_Circle_TCP graph_Circle_TCP,String title)
		{
			super(graph_Circle_TCP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/