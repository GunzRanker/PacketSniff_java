/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_HTTP extends JDialog{
	int http_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_HTTP D_HTTP;
	Graph_Circle_HTTP()
	{
	
		http_packet_count = in.tot_count_http; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_HTTP = new Dialog_Circle_HTTP(this,"HTTP Circle Graph");
		D_HTTP.setVisible(true);
	
	}
	class Dialog_Circle_HTTP extends JDialog
	{
		
		Dialog_Circle_HTTP(Graph_Circle_HTTP graph_Circle_HTTP,String title)
		{
			super(graph_Circle_HTTP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/