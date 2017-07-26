/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_ICMP extends JDialog{
	int icmp_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_ICMP D_ICMP;
	Graph_Circle_ICMP()
	{
	
		icmp_packet_count = in.tot_count_icmp; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_ICMP = new Dialog_Circle_ICMP(this,"ICMP Circle Graph");
		D_ICMP.setVisible(true);
	
	}
	class Dialog_Circle_ICMP extends JDialog
	{
		
		Dialog_Circle_ICMP(Graph_Circle_ICMP graph_Circle_ICMP,String title)
		{
			super(graph_Circle_ICMP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/