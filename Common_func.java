
package Header_Analyze;

import java.net.InetAddress;
import java.util.StringTokenizer;

import FILE_IO.*;
import jpcap.*;

public class Common_func {
		 String dev_name=null;
		 String dev_description=null;
		 String dev_datalink_name=null;
		 String datalink_description=null;
		 String mac_addr=null;
		 String tot=null;
		 String test=null;
		 String subnet=null;
		 String protocol_check=null;
		 StringTokenizer st=null;
		 
		 NetworkInterface[] devices=null;
		 JpcapCaptor captor=null; 
		
		 L2_ARP l2_arp=null;
		 L2_ICMP l2_icmp=null;
		 L2_IGMP l2_igmp=null;
		 L2_IP l2_ip=null;
		 L3_TCP l3_tcp=null;
		 L3_UDP l3_udp=null;
		 L4_FTP l4_ftp=null;
		 L4_HTTP l4_http=null;
		 L4_SMTP l4_smtp=null;
		 L4_TELNET l4_telnet=null;
		 
		 Write_ARP w_arp = null;
		 Write_ICMP w_icmp = null;
		 Write_IGMP w_igmp = null;
		 Write_IP w_ip = null;
		 Write_TCP w_tcp = null;
		 Write_UDP w_udp = null;
		 Write_FTP w_ftp = null;
		 Write_HTTP w_http = null;
		 Write_SMTP w_smtp = null;
		 Write_TELNET w_telnet = null;
		 
		 PacketPrinter_Out print=null;

		 
		 public Common_func()
		 {
			devices = JpcapCaptor.getDeviceList(); //현재 연결된 네트워크장비목록 받아옴
		 }
	
		public String get_network_info(){
			for (int i = 0; i < devices.length; i++) 
			{
				dev_name=devices[i].name; //네트워크 랜카드
				dev_description=devices[i].description; //랜카드상세설명
				dev_datalink_name=devices[i].datalink_name; //이더넷상세설명(속도)
				datalink_description=devices[i].datalink_description;
				
				tot = dev_name.concat(dev_description+"\n"+dev_datalink_name+"("+datalink_description+")"+"\n");
				
				
				for (byte b : devices[i].mac_address)
				{
					tot = tot.concat(Integer.toHexString(b & 0xff) + ":"); //맥주소
				}
				
				tot = tot.concat("\n");
				
				
				byte[] myIP = new byte[4];
				
			
				for (NetworkInterfaceAddress a : devices[i].addresses)
				{
					InetAddress myAddr = a.address;
					myIP = myAddr.getAddress(); 
					
					 subnet = a.subnet.toString();
					/*
					System.out.println(" address:" + a.address);
					System.out.println(" Subnet Mask:" + a.subnet);
					System.out.println(" BroadCast address:" + a.broadcast);
					*/
					 tot = tot.concat(subnet+"\n"); //서브넷주소
				}
				int a;
				for(int j=0;j<4;j++)
				{
					if(myIP[j]<0)
						a = myIP[j] + 256;
					else
						a = myIP[j];
					tot = tot.concat(Integer.toString(a)) + ":"; //아이피주소
				}
				
			}
			return tot;
		}


		public void check(String info_textArea) { //패킷의 형태구분후, 프로토콜당 서브루틴처리
			
			st = new StringTokenizer(info_textArea," ");
			
			while(st.hasMoreTokens())
			{
				protocol_check = st.nextToken();
				
				if(protocol_check.equals("TCP")||protocol_check.equals("protocol(6)"))
				{
					w_tcp = new Write_TCP(info_textArea);
					l3_tcp = new L3_TCP(info_textArea);
					l2_ip = new L2_IP(info_textArea);
					break;
				}
				
				if(protocol_check.equals("UDP")||protocol_check.equals("protocol(17)"))
				{
					w_udp = new Write_UDP(info_textArea);
					l3_udp = new L3_UDP(info_textArea);
					l2_ip = new L2_IP(info_textArea);
					break;
				}
				if(protocol_check.equals("IP")||protocol_check.equals("protocol(4)"))
				{
					w_ip = new Write_IP(info_textArea);
					l2_ip = new L2_IP(info_textArea);
					break;
				}
				if(protocol_check.equals("ARP"))
				{ 
					w_arp = new Write_ARP(info_textArea);
					 l2_arp = new L2_ARP(info_textArea);
					 l2_ip = new L2_IP(info_textArea);
					break;
				}	
				
				if(protocol_check.equals("ICMP")||protocol_check.equals("protocol(1)"))
				{
					w_icmp = new Write_ICMP(info_textArea);
					l2_icmp = new L2_ICMP(info_textArea);
					break;
				}	
				if(protocol_check.equals("IGMP")||protocol_check.equals("protocol(2)"))
				{
					w_igmp = new Write_IGMP(info_textArea);
					l2_igmp = new L2_IGMP(info_textArea);
					break;
				}	
				if(protocol_check.equals("HTTP")||protocol_check.equals("80"))
				{
					w_http = new Write_HTTP(info_textArea);
					l4_http = new L4_HTTP(info_textArea);
					break;
				}	
				if(protocol_check.equals("SMTP")||protocol_check.equals("25"))
				{
					w_smtp = new Write_SMTP(info_textArea);
					l4_smtp = new L4_SMTP(info_textArea);
					break;
				}	
				if(protocol_check.equals("TELNET")||protocol_check.equals("23"))
				{
					w_telnet = new Write_TELNET(info_textArea);
					l4_telnet = new L4_TELNET(info_textArea);
					break;
				}	
				if(protocol_check.equals("FTP")||protocol_check.equals("20")||protocol_check.equals("21"))
				{
					w_ftp = new Write_FTP(info_textArea);
					l4_ftp = new L4_FTP(info_textArea);
					break;
				}	
				
			}
		
		}

}



	


