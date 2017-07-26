package FILE_IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Write_TELNET {

	FileWriter fw = null;
	FileWriter fw_backup = null;
	BufferedWriter bw = null;
	BufferedWriter bw_backup = null;
	String in = null;
	public Write_TELNET(String info)
	{
		in = info;
		try {
			fw = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\onFile\\Packet_telnet.txt",true);
			fw_backup = new FileWriter("C:\\Users\\용수\\Desktop\\용수\\JAVA\\작업장\\JPacket_Pro\\src\\backup\\Packet_telnet_backup.txt",true);
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		bw = new BufferedWriter(fw,1);
		bw_backup = new BufferedWriter(fw_backup,1);
		store(info);
	}
	void store(String info)
	{
		try {
			bw.write(info+"\n");
			bw_backup.write(info+"\n");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				bw.flush();
				bw_backup.flush();
				fw.close();
				fw_backup.close();
				bw.close();
				bw_backup.close();
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
}
