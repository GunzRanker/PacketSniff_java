/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_SMTP extends JDialog{
	int smtp_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_SMTP D_SMTP;
	Graph_Circle_SMTP()
	{
	
		smtp_packet_count = in.tot_count_smtp; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_SMTP = new Dialog_Circle_SMTP(this,"SMTP Circle Graph");
		D_SMTP.setVisible(true);
	
	}
	class Dialog_Circle_SMTP extends JDialog
	{
		
		Dialog_Circle_SMTP(Graph_Circle_SMTP graph_Circle_SMTP,String title)
		{
			super(graph_Circle_SMTP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/