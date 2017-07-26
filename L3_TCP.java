package Header_Analyze;

import java.util.StringTokenizer;

import GUI_Package.Image_TCP;
import GUI_Package.Window_GUI;

public class L3_TCP{
	
	StringTokenizer st;
	String info;
	String temp;
	String no_s=null;
    Image_TCP I_tcp=null;
    
	public static int no = 1;
	int row_c = 1;
	
	/*
	String sec=null;
	String usec=null;
	String s_ip=null;
	String d_ip=null;
	String protocol=null;
	String priority=null;
	String hop=null;
	String offset=null;
	String identification=null;
	String protocol_2=null;
	String s_port=null;
	String d_port=null;
	String seq=null;
	String win_size=null;
	String ack=null;
	String etc=null;
	*/
	
	String[] l_row ;
	Window_GUI g;
	public L3_TCP(String info_textArea)
	{
		info = info_textArea;
		l_row = new String[17];
		toke(info);
		delay();
	}
	void toke(String info)
	{
		no_s = Integer.toString(no++);
		l_row[0] = no_s;
		st = new StringTokenizer(info," :/->()protocolpriorityhffsedenqwak");
		while(st.hasMoreTokens())
		{

			temp = st.nextToken();
		
			l_row[row_c] = temp;
			++row_c;
		
		}
		for(int i=0;i<l_row.length;i++)
		{
			Window_GUI.row.addElement(l_row[i]);
		}
		Window_GUI.P2_model_up.addRow(Window_GUI.row);
		
	}
	void delay()
	{
		I_tcp = new Image_TCP("TCP Packet Header",l_row[3],l_row[4],l_row[8],l_row[11],l_row[12],l_row[13],l_row[14],l_row[15]);
		I_tcp.setVisible(true);
	}
}
