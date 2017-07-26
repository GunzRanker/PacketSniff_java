/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_IGMP extends JDialog{
	int igmp_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_IGMP D_IGMP;
	Graph_Circle_IGMP()
	{
	
		igmp_packet_count = in.tot_count_igmp; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_IGMP = new Dialog_Circle_IGMP(this,"IGMP Circle Graph");
		D_IGMP.setVisible(true);
	
	}
	class Dialog_Circle_IGMP extends JDialog
	{
		
		Dialog_Circle_IGMP(Graph_Circle_IGMP graph_Circle_IGMP,String title)
		{
			super(graph_Circle_IGMP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/