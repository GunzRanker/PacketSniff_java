package Header_Analyze;

import java.util.StringTokenizer;

import GUI_Package.Image_UDP;

public class L3_UDP{
	
	StringTokenizer st;
	String info;
	String temp;
	String no_s=null;
    Image_UDP I_udp=null;
    

	int row_c = 0;
	
	/*
	String sec=null; 1
	String usec=null; 2
	String s_ip=null; 3
	String d_ip=null; 4
	String protocol=null; 5
	String priority=null; 6
	String hop=null; 7
	String offset=null; 8
	String identification=null; 9
	String protocol_2=null; 10
	String s_port=null; 11
	String d_port=null; 12

	*/
	
	String[] l_row ;

	public L3_UDP(String info_textArea)
	{
		info = info_textArea;
		l_row = new String[13];
		toke(info);
		delay();
	}
	void toke(String info)
	{
		st = new StringTokenizer(info," :/>->()protocolpriorityhffsedenqwak");
		while(st.hasMoreTokens())
		{
			temp = st.nextToken();
		
			l_row[row_c] = temp;
			++row_c;
		
		}
		
		
	}
	void delay()
	{
		I_udp = new Image_UDP("UDP Packet Header",l_row[2],l_row[3],l_row[10],l_row[11]);
		I_udp.setVisible(true);
	}
}
