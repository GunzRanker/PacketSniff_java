/*
package GUI_Package;

import java.awt.FlowLayout;

import javax.swing.JDialog;

import Header_Analyze.PacketPrinter_In;

public class Graph_Circle_FTP extends JDialog{
	int ftp_packet_count=0;
	int tot_p = 0;
	int round = 0;
	
	PacketPrinter_In in=null;
	Dialog_Circle_FTP D_FTP;
	Graph_Circle_FTP()
	{
	
		ftp_packet_count = in.tot_count_ftp; //특정패킷수
		tot_p = in.tot_count_packet; //전체패킷수
		round = in.round_count; //돌린횟수
		D_FTP = new Dialog_Circle_FTP(this,"FTP Circle Graph");
		D_FTP.setVisible(true);
	
	}
	class Dialog_Circle_FTP extends JDialog
	{
		
		Dialog_Circle_FTP(Graph_Circle_FTP graph_Circle_FTP,String title)
		{
			super(graph_Circle_FTP,title);
			setLayout(new FlowLayout());
			setSize(600,600);
			setLocation(500,0);
		}
	}
}
*/