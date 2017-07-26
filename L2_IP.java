package Header_Analyze;

import java.util.StringTokenizer;

import GUI_Package.Image_IP;

public class L2_IP{
	
	StringTokenizer st;
	String info;
	String temp;
	String no_s=null;
    Image_IP I_ip=null;
    

	int row_c = 0;
	
	/*
	String sec=null; 0
	String usec=null; 1 
	String s_ip=null; 2
	String d_ip=null; 3 
	String protocol=null; 4
	String priority=null; 5
	String hop=null; 6
	String offset=null; 7 
	String identification=null; 8
	String protocol_2=null; 9
	String s_port=null; 10
	String d_port=null; 11
	String seq=null; 12
	String win_size=null; 13
	String ack=null; 14 
	String etc=null; 15 
	*/
	
	String[] l_row ;

	public L2_IP(String info_textArea)
	{
		info = info_textArea;
		l_row = new String[16];
		toke(info);
		delay();
	}
	void toke(String info)
	{
		st = new StringTokenizer(info," :/->()protocolpriorityhffsedenqwak");
		while(st.hasMoreTokens())
		{

			temp = st.nextToken();
		
			l_row[row_c] = temp;
			++row_c;
		
		}

		
	}
	void delay()
	{
		I_ip = new Image_IP("IP Packet Header",l_row[0],l_row[1],l_row[2],l_row[3],l_row[4],l_row[5],l_row[6],l_row[7],l_row[8]);
		I_ip.setVisible(true);
	}
}
