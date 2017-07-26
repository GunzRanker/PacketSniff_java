package Header_Analyze;

import java.io.FileReader;
import java.io.LineNumberReader;

public class PacketPrinter_Out {
	LineNumberReader reader=null;
	PacketPrinter_In Writer=null;

	String str=null;
	int lineNo=0;
	String lineNo_s=null;
	String send=null;
	String temp=null;

	public String receive()
	{
		F_Out();
		return send;
	
	}
	
	void F_Out()
	{
		try
		{
			reader = new LineNumberReader(new FileReader("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\Packet_info.txt")); //울집 신형
			//reader = new LineNumberReader(new FileReader("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\Packet_info.txt")); //울집 구형
			//reader = new LineNumberReader(new FileReader("C:\\Users\\101\\Desktop\\용수\\졸업작업\\프로젝트들\\JPacket_Pro\\Packet_info.txt")); //피방꺼
			
			while(true)
			{
				str = reader.readLine();
				lineNo = reader.getLineNumber();
				if(str == null)
					break;
				
				
				lineNo_s = Integer.toString(lineNo);
				
				temp = lineNo_s+"> "+str+"\n";

				send = send+temp;
				
			}
			
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("파일존재 x");
		}
		
		finally
		{
			
			try
			{
				reader.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Close Exception");
			}
			
		}
	}

	public String get_packet(String no) {
		
		try
		{
			reader = new LineNumberReader(new FileReader("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\Packet_info.txt")); //울집 신형
			//reader = new LineNumberReader(new FileReader("C:\\Users\\1\\Desktop\\용수\\졸업작업\\자바\\작업장\\JPacket_Pro\\Packet_info.txt")); //울집 구형
			//reader = new LineNumberReader(new FileReader("C:\\Users\\101\\Desktop\\용수\\졸업작업\\프로젝트들\\JPacket_Pro\\Packet_info.txt")); //피방꺼
			
			while(true)
			{
				str = reader.readLine();
				lineNo = reader.getLineNumber();
				if(str == null)
					break;
		
				int num = Integer.parseInt(no);
				
				if(lineNo == num%11)
				{
					return str;
				}
			}
			
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("파일존재 x");
		}
		
		finally
		{
			
			try
			{
				reader.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Close Exception");
			}
			
		}
		return null;
	}
	
}
