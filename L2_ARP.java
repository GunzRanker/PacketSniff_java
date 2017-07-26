package Header_Analyze;

import java.util.StringTokenizer;

import GUI_Package.Image_ARP;

public class L2_ARP{
	
	StringTokenizer st;
	String info;
	String temp;
	String no_s=null;
    Image_ARP I_arp=null;
    

	int row_c = 0;
	
	/*
	REQUEST =0
	00:07:70:db:dd:46 =1
	59.15.28.126 = 2
	00:00:00:00:00:00 = 3
	59.15.28.54 = 4
	*/
	
	String[] l_row ;

	public L2_ARP(String info_textArea)
	{
		info = info_textArea;
		l_row = new String[5];
		toke(info);
		delay();
	}
	void toke(String info)
	{
		st = new StringTokenizer(info," (/)->=ARP");
		while(st.hasMoreTokens())
		{
			temp = st.nextToken();
		
			l_row[row_c] = temp;
			++row_c;
		
		}
		
		
	}
	void delay()
	{
		I_arp = new Image_ARP("ARP Packet Header",l_row[0],l_row[1],l_row[2],l_row[3],l_row[4]);
		I_arp.setVisible(true);
	}
}
