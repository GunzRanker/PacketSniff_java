package Header_Analyze;

import java.io.*;
import java.util.StringTokenizer;

import jpcap.JpcapCaptor;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;

public class PacketPrinter_In implements PacketReceiver{
	
	StringTokenizer st=null;
	String name=null;
	String temp=null;
	

	static int tot_count=0; //파일입출력 횟수
	public static int count_packet=0; //패킷의 총수
	
	public static int tot_count_arp=0; //실질적인 ftp패킷개수
	public static int tot_count_ftp=0;
	public static int tot_count_http=0;
	public static int tot_count_icmp=0;
	public static int tot_count_igmp=0;
	public static int tot_count_ip=0;
	public static int tot_count_smtp=0;
	public static int tot_count_tcp=0;
	public static int tot_count_telnet=0;
	public static int tot_count_udp=0;
	
	public static int tot_count_arp_=0; //총그래프용
	public static int tot_count_ftp_=0;
	public static int tot_count_http_=0;
	public static int tot_count_icmp_=0;
	public static int tot_count_igmp_=0;
	public static int tot_count_ip_=0;
	public static int tot_count_smtp_=0;
	public static int tot_count_tcp_=0;
	public static int tot_count_telnet_=0;
	public static int tot_count_udp_=0;
	
	
	
	
	public static int arp[]=null;
	public static int ftp[]=null;
	public static int http[]=null;
	public static int icmp[]=null;
	public static int igmp[]=null;
	public static int ip[]=null;
	public static int smtp[]=null;
	public static int tcp[]=null;
	public static int telnet[]=null;
	public static int udp[]=null;
	
	
	public static int a = -1;
	public static int round_count=0; //start버튼 누른횟수
	
	private FileWriter fw=null;
	private FileWriter backup=null;

	
	private BufferedWriter bw=null;
	private BufferedWriter bw2=null;

	
	public PacketPrinter_In()
	{
		try 
		{
			ftp = new int[20];
			telnet = new int[20];
			smtp = new int[20];
			http = new int[20];
			tcp = new int[20];
			udp = new int[20];
			icmp = new int[20];
			ip = new int[20];
			igmp = new int[20];
			arp = new int[20];
			
			fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\Packet_info.txt",true); //울집 신형컴
			backup = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\Packet_info_backup.txt",true); //울집 신형컴
			
			
			/*
			fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\Packet_info.txt",true); //울집 구형컴
			backup = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\Packet_info_backup.txt",true); //울집 구형컴
			*/
			
			/*
			fw = new FileWriter("C:\\Users\\101\\Desktop\\용수\\졸업작업\\프로젝트들\\JPacket_Pro\\Packet_info.txt",true); //피방
			backup = new FileWriter("C:\\Users\\101\\Desktop\\용수\\졸업작업\\프로젝트들\\JPacket_Pro\\Packet_info_backup.txt",true); //피방
			*/
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally{
			bw = new BufferedWriter(fw,1);
			bw2 = new BufferedWriter(backup,1);
		
		}
		
	}
	public void ini()
	 {
		 round_count++;
		 a++;
		 try
			{	
				jpcap.NetworkInterface[] devices= JpcapCaptor.getDeviceList();
				JpcapCaptor captor= JpcapCaptor.openDevice(devices[0],1,false,20);
							
				for(int i=0;i<10;i++)
					captor.loopPacket(1,new PacketPrinter_In());
					//captor.processPacket(1, new PacketPrinter());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			} 
		 finally{
			 tot_count_ftp=0;
				tot_count_telnet=0;
				tot_count_smtp=0;
				tot_count_http=0;
				tot_count_tcp=0;
				tot_count_udp=0;
				tot_count_icmp=0;
				tot_count_ip=0;
				tot_count_arp=0;
				tot_count_tcp=0;
		 }
	 }

	public void receivePacket(Packet packet){
		try
		{
			tot_count++;
			count_packet++;
			name =name+packet.toString()+"\n";
			name = name.substring(4);
			
			check(name);
			print_packet();
			
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally
		{	
			
		}
		/*
		System.out.println("Header="+packet.header);
		System.out.println("Caplen="+packet.caplen);
		System.out.println("len="+packet.len);
		System.out.println("sec="+packet.sec);
		System.out.println("usec="+packet.usec);
		System.out.println("data="+packet.data);
		System.out.println("datalink="+packet.datalink);
		System.out.println("EOF="+packet.EOF);
		*/
		
	}
	
	  void check(String name) {
		st = new StringTokenizer(name," ");
	
		
		while(st.hasMoreTokens())
		{
			temp = st.nextToken();
			if(temp.equals("protocol(6)")||temp.equals("TCP"))
			{
				tot_count_tcp++;
				tot_count_tcp_++;
				tcp[a] = tcp[a]+tot_count_tcp;
				break;
			}
			if(temp.equals("protocol(23)")||temp.equals("TELNET"))
			{
				tot_count_telnet++;
				tot_count_telnet_++;
				telnet[a] = telnet[a]+tot_count_telnet;
				break;
			}
			if(temp.equals("protocol(25)")||temp.equals("SMTP"))
			{
				tot_count_smtp++;
				tot_count_smtp_++;
				smtp[a] = smtp[a]+tot_count_smtp;
				break;
			}
			if(temp.equals("protocol(80)")||temp.equals("HTTP"))
			{
				tot_count_http++;
				tot_count_http_++;
				http[a] = http[a]+tot_count_http;
				break;
			}
			if((temp.equals("protocol(21)"))||(temp.equals("protocol(20)"))||temp.equals("FTP"))
			{
				tot_count_ftp++;
				tot_count_ftp_++;
				ftp[a] = ftp[a]+tot_count_ftp;
				break;
			}
			if(temp.equals("protocol(17)")||temp.equals("UDP"))
			{
				tot_count_udp++;
				tot_count_udp_++;
				udp[a] = udp[a]+tot_count_udp;
				break;
			}
			if(temp.equals("protocol(1)")||temp.equals("ICMP"))
			{
				tot_count_icmp++;
				tot_count_icmp_++;
				icmp[a] = icmp[a]+tot_count_icmp;
				break;
			}
			if(temp.equals("protocol(4)")||temp.equals("IP"))
			{
				tot_count_ip++;
				tot_count_ip_++;
				ip[a] = ip[a]+tot_count_ip;
				break;
			}
			if(temp.equals("protocol(2)")||temp.equals("IGMP"))
			{
				tot_count_igmp++;
				tot_count_igmp_++;
				igmp[a] = igmp[a]+tot_count_igmp;
				break;
			}
			if(temp.equals("ARP")||temp.equals("REQUEST"))
			{
				tot_count_arp++;
				tot_count_arp_++;
				arp[a] = arp[a]+tot_count_arp;
				break;
			}
			
		}
	  
	  }
	void print_packet() 
	{		
		while(tot_count>0)
		{
			try 
			{	
				bw.write(name);
				bw2.write(name);
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}	
			tot_count--;
		}
		try
		{
			bw.flush();
			bw2.flush();
			fw.close();
			backup.close();
			bw.close();
			bw2.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
		}
		
	}
	 public void clear()
	 {

		 try
			{
			 /*
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\Packet_info.txt"); //울집 구형
			 
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_arp.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_ftp.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_http.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_icmp.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_igmp.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_ip.txt"); //울집 구형 
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_smtp.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_tcp.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_telnet.txt"); //울집 구형
			 fw = new FileWriter("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\src\\onFile\\Packet_udp.txt"); //울집 구형
			 */
			 
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\Packet_info.txt"); //울집 신형
			 
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_arp.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_ftp.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_http.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_icmp.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_igmp.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_ip.txt"); //울집 신형 
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_smtp.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_tcp.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_telnet.txt"); //울집 신형
			 fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_udp.txt"); //울집 신형
			
			}
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 round_count=0;
			 try{
			 fw.close();
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 finally
			 {
				 
			 }
			 }
			 
	 }
	
}
