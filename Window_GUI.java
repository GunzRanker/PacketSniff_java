package GUI_Package;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import Header_Analyze.Common_func;
import Header_Analyze.PacketPrinter_In;
import Header_Analyze.PacketPrinter_Out;
import Header_Analyze.Sorting_protocol;

public class Window_GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	Container contentPane = null;
	
	//Header_Analyze 객체
	Common_func Common_f = null;
	PacketPrinter_Out PacketPrint_O= new PacketPrinter_Out();
	PacketPrinter_In PacketPrint_I=null;
	
	//다이얼로그 객체
	Dialog_FTP D_ftp=null;
	Dialog_TELNET D_telnet=null;
	Dialog_SMTP D_smtp=null;
	Dialog_HTTP D_http=null;
	Dialog_TCP D_tcp=null;
	Dialog_UDP D_udp=null;
	Dialog_ICMP D_icmp=null;
	Dialog_IP D_ip=null;
	Dialog_IGMP D_igmp=null;
	Dialog_ARP D_arp=null;
	Dialog_SELECT D_select=null;

	//패널1 객체
	JPanel p1=null;
	
	JButton P1_b1=null;
	JButton P1_b2=null;
	JButton P1_b3=null;
	JButton P1_b4=null;
	JButton P1_b5=null;
	JButton P1_b6=null;
	JButton P1_b7=null;
	JButton P1_b8=null;
	JButton P1_b9=null;
	JButton P1_b10=null;
	
	//패널2 객체
	Sorting_protocol P2_so=null;
	JPanel p2=null;
	
	Object[][] P2_obj_up=null ;
	Object[][] P2_obj_down = {{"5","5"}};
	
	String P2_columnName_up[] = {"No.","Sec","Usec","S_IP","D_IP","Pro","PRI","HOP","OFF_S","IDEN","PRO","S_PT","D_PT","SEQ","WIN","ACK","ETC"};
	String P2_menu[] = {"Device Name","Data Link","Mac Address","Subnet Mask","IP Address"};
	String P2_pro[]= {"FTP","Telnet","SMTP","HTTP","TCP","UDP","ICMP","IP","IGMP","ARP"};
	
	JComboBox<Object> P2_box=null;
			
	public static  DefaultTableModel P2_model_up=null;
	JTable P2_table_up=null;
	public static Vector<String> row=null;
	
	JTextArea P2_t1=null;
	JTextArea P2_t2=null;
	
	JScrollPane P2_list_up=null;
	JScrollPane P2_Text_up=null;
	JScrollPane P2_Text_down=null;
	
	JButton P2_b1=null;
	JButton P2_b2=null;
	JButton P2_b3=null;
	JButton P2_b4=null;
	JButton P2_b5=null;
	
	JLabel P2_l1=null;
	JLabel P2_l2=null;
	
	
	
	JList<Object> P2_list_side=null;
	
	//패널3 객체
	JPanel p3=null;
	ImageIcon TCP_icon=null;
	ImageIcon UDP_icon=null;
	ImageIcon IP_icon=null;
	ImageIcon ARP_icon=null;
	
	JLabel p3_icon_l1=null;
	JLabel p3_icon_l2=null;
	JLabel p3_icon_l3=null;
	JLabel p3_icon_l4=null;
	
	JLabel P3_l1=null;
	JLabel P3_l2=null;
	JLabel P3_l3=null;
	JLabel P3_l4=null;
	//Menu 객체
	JMenuBar mb=null;
	JMenu fileMenu=null;
	JMenu CaptureMenu=null;
	JMenu OptionMenu=null;
	JMenu AboutMenu=null;
	
	JMenuItem[] File_item=null;
	JMenuItem[] Capture_item=null;
	JMenuItem[] About_item=null;
	
	
	Window_GUI()
	{
		contentPane = getContentPane();
		setTitle("Visual Packet Sniffer");
		setBackground(Color.white);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0,0);

		new panel1();
		new panel2();
		new panel3();

		createMenu();
			
		setSize(1475,900);
		setVisible(true);
		this.addWindowListener(new WindowListener(){
			public void windowOpened(WindowEvent e) {	
			}
			public void windowClosing(WindowEvent e) {		
				JFrame frame = (JFrame)e.getWindow();
				frame.dispose();
				PacketPrint_I = new PacketPrinter_In();
				PacketPrint_I.clear();
			}
			public void windowClosed(WindowEvent e) {
			}
			public void windowIconified(WindowEvent e) {		
			}
			public void windowDeiconified(WindowEvent e) {	
			}
			public void windowActivated(WindowEvent e) {	
			}
			public void windowDeactivated(WindowEvent e) {	
			}
			
			});
	}
	
	void createMenu()
	{
		mb = new JMenuBar();
		fileMenu = new JMenu("File");
		CaptureMenu = new JMenu("Capture");
		OptionMenu = new JMenu("Option");
		AboutMenu = new JMenu("About");
		
		File_item = new JMenuItem[2];
		Capture_item = new JMenuItem[9];
		About_item = new JMenuItem[1];
		
		
		File_item[0] = new JMenuItem("open");
		File_item[1] = new JMenuItem("save");
		
		Capture_item[0] = new JMenuItem("FTP");
		Capture_item[1] = new JMenuItem("HTTP");
		Capture_item[2] = new JMenuItem("ICMP");
		Capture_item[3] = new JMenuItem("IGMP");
		Capture_item[4] = new JMenuItem("IP");
		Capture_item[5] = new JMenuItem("SMTP");
		Capture_item[6] = new JMenuItem("TCP");
		Capture_item[7] = new JMenuItem("TELNET");
		Capture_item[8] = new JMenuItem("UDP");
		
		About_item[0] = new JMenuItem("Program");
		/*
		//open 이벤트
		File_item[0].addActionListener(new OpenActionListener());
		File_item[1].addActionListener(new SaveActionListener());
		
	
		
		//FTP 이벤트
		Capture_item[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//HTTP이벤트
		Capture_item[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//ICMP이벤트
		Capture_item[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//IGMP이벤트
		Capture_item[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//IP이벤트
		Capture_item[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//SMTP이벤트
		Capture_item[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//TCP이벤트
		Capture_item[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//TELNET이벤트
		Capture_item[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//UDP이벤트
		Capture_item[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		//Program 이벤트
		About_item[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				
			}
			
		});
		*/
		for(int i=0;i<File_item.length;i++)
		{
			fileMenu.add(File_item[i]);
		}
		for(int i=0;i<Capture_item.length;i++)
		{
			CaptureMenu.add(Capture_item[i]);
		}
		for(int i=0;i<About_item.length;i++)
		{
			AboutMenu.add(About_item[i]);
		}
		
		mb.add(fileMenu);
		mb.add(CaptureMenu);
		mb.add(OptionMenu);
		mb.add(AboutMenu);
		
		setJMenuBar(mb);
	}
	/*
	class OpenActionListener implements ActionListener{
		JFileChooser chooser;
		
		
		String filePath;
		
		OpenActionListener()
		{
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showOpenDialog(null);
			
			if(ret!=JFileChooser.APPROVE_OPTION)
			{
				JOptionPane.showMessageDialog(null, "파일을 선택하세요.","경고",JOptionPane.WARNING_MESSAGE);
				return;
			}
			filePath = chooser.getSelectedFile().getPath();
			
			
		}
		
	}
	class SaveActionListener implements ActionListener{
		JFileChooser chooser;
		
		
		String filePath;
		
		SaveActionListener()
		{
			chooser = new JFileChooser();
		}
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showOpenDialog(null);
			
			if(ret!=JFileChooser.APPROVE_OPTION)
			{
				JOptionPane.showMessageDialog(null, "파일을 선택하세요.","경고",JOptionPane.WARNING_MESSAGE);
				return;
			}
			filePath = chooser.getSelectedFile().getPath();
			
			
		}
		
	}
	*/
	
	class Dialog_FTP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  
		
		Graph_Bar_FTP G_B_FTP=null;
		Graph_Polygon_FTP G_P_FTP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_FTP(String title)
		{
			explain = new JLabel("FTP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Circle_FTP();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_FTP = new Graph_Bar_FTP();
					chart = G_B_FTP.getChart();
					 frame=new ChartFrame("FTP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					G_P_FTP = new Graph_Polygon_FTP();
					chart = G_P_FTP.getChart();
					frame=new ChartFrame("FTP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);	
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_TELNET extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  
		
		Graph_Bar_TELNET G_B_TELNET=null;
		Graph_Polygon_TELNET G_P_TELNET=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_TELNET(String title)
		{
			explain = new JLabel("TELNET그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Circle_TELNET();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_TELNET = new Graph_Bar_TELNET();
					chart = G_B_TELNET.getChart();
					 frame=new ChartFrame("TELNET Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_TELNET = new Graph_Polygon_TELNET();
					chart = G_P_TELNET.getChart();
					frame=new ChartFrame("TELNET Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_SMTP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  
		
		Graph_Bar_SMTP G_B_SMTP=null;
		Graph_Polygon_SMTP G_P_SMTP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_SMTP(String title)
		{
			explain = new JLabel("SMTP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Circle_SMTP();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_SMTP = new Graph_Bar_SMTP();
					chart = G_B_SMTP.getChart();
					 frame=new ChartFrame("SMTP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_SMTP = new Graph_Polygon_SMTP();
					chart = G_P_SMTP.getChart();
					frame=new ChartFrame("SMTP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_HTTP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  

		Graph_Bar_HTTP G_B_HTTP=null;
		Graph_Polygon_HTTP G_P_HTTP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_HTTP(String title)
		{
			explain = new JLabel("HTTP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_HTTP = new Graph_Bar_HTTP();
					chart = G_B_HTTP.getChart();
					 frame=new ChartFrame("HTTP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_HTTP = new Graph_Polygon_HTTP();
					chart = G_P_HTTP.getChart();
					frame=new ChartFrame("HTTP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_TCP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  
		
		Graph_Bar_TCP G_B_TCP=null;
		Graph_Polygon_TCP G_P_TCP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_TCP(String title)
		{
			explain = new JLabel("TCP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			//원형그래프 리스너
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				//	new Graph_Circle_TCP();
					
				}
				
			});
			
			//막대그래프 리스너
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				G_B_TCP = new Graph_Bar_TCP();
				chart = G_B_TCP.getChart();
				 frame=new ChartFrame("TCP Bar Chart",chart);
				 frame.setSize(800,400);
				 frame.setLocation(500,0);
				 frame.setVisible(true);

				}
				
			});
			//꺽은선그래프 리스너
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Polygon_TCP();
					G_P_TCP = new Graph_Polygon_TCP();
					chart = G_P_TCP.getChart();
					frame=new ChartFrame("TCP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			
			add(explain);
			add(b1);
			add(b2);
			add(b3);
			
			
		}
	}
	class Dialog_UDP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  

		Graph_Bar_UDP G_B_UDP=null;
		Graph_Polygon_UDP G_P_UDP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_UDP(String title)
		{
			explain = new JLabel("UDP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Circle_UDP();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_UDP = new Graph_Bar_UDP();
					chart = G_B_UDP.getChart();
					 frame=new ChartFrame("UDP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_UDP = new Graph_Polygon_UDP();
					chart = G_P_UDP.getChart();
					frame=new ChartFrame("UDP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_ICMP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  

		Graph_Bar_ICMP G_B_ICMP=null;
		Graph_Polygon_ICMP G_P_ICMP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_ICMP(String title)
		{
			explain = new JLabel("ICMP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				//	new Graph_Circle_ICMP();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_ICMP = new Graph_Bar_ICMP();
					chart = G_B_ICMP.getChart();
					 frame=new ChartFrame("ICMP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_ICMP = new Graph_Polygon_ICMP();
					chart = G_P_ICMP.getChart();
					frame=new ChartFrame("ICMP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_IP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  

		Graph_Bar_IP G_B_IP;
		Graph_Polygon_IP G_P_IP;
		JFreeChart chart;
		ChartFrame frame;
		
		public Dialog_IP(String title)
		{
			explain = new JLabel("IP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150,50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Circle_IP();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_IP = new Graph_Bar_IP();
					chart = G_B_IP.getChart();
					 frame=new ChartFrame("IP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_IP = new Graph_Polygon_IP();
					chart = G_P_IP.getChart();
					frame=new ChartFrame("IP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_IGMP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  
	
		Graph_Bar_IGMP G_B_IGMP=null;
		Graph_Polygon_IGMP G_P_IGMP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_IGMP(String title)
		{
			explain = new JLabel("IGMP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Circle_IGMP();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_IGMP = new Graph_Bar_IGMP();
					chart = G_B_IGMP.getChart();
					 frame=new ChartFrame("IGMP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_IGMP = new Graph_Polygon_IGMP();
					chart = G_P_IGMP.getChart();
					frame=new ChartFrame("IGMP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_ARP extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;  
		JButton b1=null; 
		JButton b2=null;
		JButton b3=null;  
	
		Graph_Bar_ARP G_B_ARP=null;
		Graph_Polygon_ARP G_P_ARP=null;
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		public Dialog_ARP(String title)
		{
			explain = new JLabel("ARP그래프 종류를 선택하세요!");
			b1 = new JButton("원형그래프보기");
			b2 = new JButton("막대그래프보기");
			b3 = new JButton("꺾은선그래프보기");
			
			setTitle(title);
			setSize(500,500);
			setLayout(null);
			
			explain.setSize(200,20);
			b1.setSize(200,40);
			b2.setSize(200,40);
			b3.setSize(200,40);
			
			explain.setLocation(150, 50);
			b1.setLocation(150,150);
			b2.setLocation(150,250);
			b3.setLocation(150,350);
			
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//new Graph_Circle_ARP();
				}
				
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_B_ARP = new Graph_Bar_ARP();
					chart = G_B_ARP.getChart();
					 frame=new ChartFrame("ARP Bar Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			b3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					G_P_ARP = new Graph_Polygon_ARP();
					chart = G_P_ARP.getChart();
					frame=new ChartFrame("ARP Polygon Chart",chart);
					 frame.setSize(800,400);
					 frame.setLocation(500,0);
					 frame.setVisible(true);
				}
				
			});
			add(explain);
			add(b1);
			add(b2);
			add(b3);
		}
	}
	class Dialog_SELECT extends JDialog
	{
		private static final long serialVersionUID = 1L;
		JLabel explain=null;
		JButton s1=null;
		JButton s2=null;
		JButton s3=null;
		JButton s4=null;
		JButton s5=null;
		JButton s6=null;
		JButton s7=null;
		JButton s8=null;
		JButton s9=null;
		JButton s10=null;
		
		
		
		public Dialog_SELECT(String title)
		{
			setTitle(title);
			setSize(250,300);
			setLocation(1000,310);
			setLayout(null);
			
			row = new Vector<String>();
			
			
			explain = new JLabel("캡쳐할 번호를 선택하세요!!");
			s1 = new JButton("1");
			s2 = new JButton("2");
			s3 = new JButton("3");
			s4 = new JButton("4");
			s5 = new JButton("5");
			s6 = new JButton("6");
			s7 = new JButton("7");
			s8 = new JButton("8");
			s9 = new JButton("9");
			s10 = new JButton("10");
			
			
			
			s1.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("1");
			
					Common_f.check(info_textArea);
			
				}
			});
			s2.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("2");
					
					Common_f.check(info_textArea);
				
				}
			});
			s3.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("3");
					Common_f.check(info_textArea);
					
				}
			});
			s4.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("4");
					Common_f.check(info_textArea);
					
				}
			});
			s5.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("5");
					Common_f.check(info_textArea);
					
				}
			});
			s6.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("6");
					Common_f.check(info_textArea);
					
				}
			});
			s7.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("7");
					Common_f.check(info_textArea);
					
				}
			});
			s8.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("8");
					Common_f.check(info_textArea);
					
				}
			});
			s9.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("9");
					Common_f.check(info_textArea);
					
				}
			});
			s10.addActionListener(new ActionListener(){	
				public void actionPerformed(ActionEvent e) {
					String info_textArea = PacketPrint_O.get_packet("10");
					Common_f.check(info_textArea);
					
				}
			});
			
			
			explain.setSize(200,20);
			s1.setSize(50,40);
			s2.setSize(50,40);
			s3.setSize(50,40);
			s4.setSize(50,40);
			s5.setSize(50,40);
			s6.setSize(50,40);
			s7.setSize(50,40);
			s8.setSize(50,40);
			s9.setSize(50,40);
			s10.setSize(50,40);
			
			explain.setLocation(50, 10);
			s1.setLocation(50,50);
			s2.setLocation(100,50);
			s3.setLocation(150,50);
			s4.setLocation(50,100);
			s5.setLocation(100,100);
			s6.setLocation(150,100);
			s7.setLocation(50,150);
			s8.setLocation(100,150);
			s9.setLocation(150,150);
			s10.setLocation(100,200);
			
			add(explain);
			add(s1);
			add(s2);
			add(s3);
			add(s4);
			add(s5);
			add(s6);
			add(s7);
			add(s8);
			add(s9);
			add(s10);
			
		}
	}
	class panel1 extends JPanel{
		private static final long serialVersionUID = 1L;
		
		panel1()
		{
			p1 = new JPanel();
			
			p1.setLocation(0,0);
			p1.setSize(590,800);
			p1.setBackground(Color.GRAY);
			p1.setLayout(null);
			
			P1_b1=new JButton("FTP");
			P1_b2=new JButton("Telnet");
			P1_b3=new JButton("SMTP");
			P1_b4=new JButton("HTTP");
			P1_b5=new JButton("TCP");
			P1_b6=new JButton("UDP");
			P1_b7=new JButton("ICMP");
			P1_b8=new JButton("IP");
			P1_b9=new JButton("IGMP");
			P1_b10=new JButton("ARP");
			
			P1_b1.setLocation(50,50);
			P1_b2.setLocation(170,50);
			P1_b3.setLocation(290,50);
			P1_b4.setLocation(410,50);
			P1_b5.setLocation(170,170);
			P1_b6.setLocation(290,170);
			P1_b7.setLocation(50,290);
			P1_b8.setLocation(170,290);
			P1_b9.setLocation(290,290);
			P1_b10.setLocation(410,290);
			
			
			P1_b1.setSize(90, 60);
			P1_b2.setSize(90, 60);
			P1_b3.setSize(90, 60);
			P1_b4.setSize(90, 60);
			P1_b5.setSize(90, 60);
			P1_b6.setSize(90, 60);
			P1_b7.setSize(90, 60);
			P1_b8.setSize(90, 60);
			P1_b9.setSize(90, 60);
			P1_b10.setSize(90,60);
			
			
			D_ftp = new Dialog_FTP("FTP Dialog");
			D_telnet = new Dialog_TELNET("TELNET Dialog");
			D_smtp = new Dialog_SMTP("SMTP Dialog");
			D_http = new Dialog_HTTP("HTTP Dialog");
			D_tcp = new Dialog_TCP("TCP Dialog");
			D_udp = new Dialog_UDP("UDP Dialog");
			D_icmp = new Dialog_ICMP("ICMP Dialog");
			D_ip = new Dialog_IP("IP Dialog");
			D_igmp = new Dialog_IGMP("IGMO Dialog");
			D_arp = new Dialog_ARP("ARP Dialog");
			//FTP 핸들러
			P1_b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_ftp.setVisible(true);
					
					
				}
				
			});
			//Telnet핸들러
			P1_b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_telnet.setVisible(true);
					
					
				}
				
			});
			//SMTP핸들러
			P1_b3.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_smtp.setVisible(true);
					
					
				}
				
			});
			//HTTP핸들러
			P1_b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_http.setVisible(true);
					
					
				}
				
			});
			//TCP핸들러
			P1_b5.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_tcp.setVisible(true);
					
					
				}
				
			});
			//UDP핸들러
			P1_b6.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_udp.setVisible(true);
					
					
				}
				
			});
			//ICMP핸들러
			P1_b7.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_icmp.setVisible(true);
					
					
				}
				
			});
			//IP핸들러
			P1_b8.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_ip.setVisible(true);
					
					
				}
				
			});
			//IGMP핸들러
			P1_b9.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_igmp.setVisible(true);
					
		
				}
				
			});
			//ARP핸들러
			P1_b10.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_arp.setVisible(true);
					
		
				}
				
			});
			p1.add(P1_b1);
			p1.add(P1_b2);
			p1.add(P1_b3);
			p1.add(P1_b4);
			p1.add(P1_b5);
			p1.add(P1_b6);
			p1.add(P1_b7);
			p1.add(P1_b8);
			p1.add(P1_b9);
			p1.add(P1_b10);
			
			contentPane.add(p1);
			
		}
	
	}
	
	class panel2 extends JPanel{
		private static final long serialVersionUID = 1L;
		Graph_Bar_TOT G_B_TOT=null;
		
		JFreeChart chart=null;
		ChartFrame frame=null;
		
		panel2()
		{
			Common_f = new Common_func();
			P2_so = new Sorting_protocol();
			p2 = new JPanel();
			p2.setSize(860,500); 
			p2.setLocation(600,0);
			
			p2.setLayout(null);
			
			P2_box = new JComboBox<Object>(P2_pro);

			
			P2_model_up= new DefaultTableModel(P2_obj_up,P2_columnName_up);
			P2_table_up = new JTable(P2_model_up);
		
			P2_t1 = new JTextArea(" ",8,107); //아래테이블
			P2_t2 = new JTextArea(" ",4,50); //중가테이블
			
			P2_list_up = new JScrollPane(P2_table_up);
		
			P2_Text_up = new JScrollPane(P2_t2);
			P2_Text_down = new JScrollPane(P2_t1);
			
			P2_b1 = new JButton("Start");
			P2_b2 = new JButton("Select");
			P2_b3 = new JButton("Sort");
			P2_b4 = new JButton("Clear");
			P2_b5 = new JButton("Apply");
			
			P2_l1 = new JLabel("Protocol:");
			P2_l2 = new JLabel("네트워크 패킷정보");
				
			P2_list_side = new JList<Object>(P2_menu);
			
			D_select = new Dialog_SELECT("SELECT Dialog");
			
			//start핸들러
			P2_b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					
		
					P2_t2.setText(Common_f.get_network_info());
					PacketPrint_I = new PacketPrinter_In();
					PacketPrint_I.ini();
					P2_t1.setText(PacketPrint_O.receive());
					
					
					
					
				}
			});
			//select핸들러
			P2_b2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					D_select.setVisible(true);
							
				}
				
			});
	
			//clear핸들러
			P2_b4.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					PacketPrint_I = new PacketPrinter_In();
					PacketPrint_I.clear();
					P2_t1.setText(" ");
					P2_t2.setText(" ");
					
					int row = P2_model_up.getRowCount();	
					for(int i=0;i<row;i++)
						P2_model_up.removeRow(0);
					
					G_B_TOT = new Graph_Bar_TOT();
					chart = G_B_TOT.getChart();
					 frame=new ChartFrame("Total Bar Chart",chart);
					 frame.setSize(820,450);
					 frame.setLocation(0,450);
					 frame.setVisible(true);
					 
					 
				}
				
			});
			//Apply 핸들러
			P2_b5.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
				
				}
				
			});
			P2_box.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					JComboBox<?> cb = (JComboBox<?>)e.getSource();
					int idx = cb.getSelectedIndex();
					
					switch(idx)
					{
						case 0:
							P2_so.Sorting(P2_pro[0]);
							break;
						case 1:
							P2_so.Sorting(P2_pro[1]);
							break;
						case 2:
							P2_so.Sorting(P2_pro[2]);
							break;
						case 3:
							P2_so.Sorting(P2_pro[3]);
							break;
						case 4:
							P2_so.Sorting(P2_pro[4]);
							break;
						case 5:
							P2_so.Sorting(P2_pro[5]);
							break;
						case 6:
							P2_so.Sorting(P2_pro[6]);
							break;
						case 7:
							P2_so.Sorting(P2_pro[7]);
							break;
						case 8:
							P2_so.Sorting(P2_pro[8]);
							break;

						default:
								break;
					}
					
				}
		
			});
			
			P2_list_up.setSize(780, 160);
		
			P2_list_side.setSize(120,100);
			P2_b1.setSize(80,40);
			P2_b2.setSize(80,40);
			P2_b3.setSize(80,40);
			P2_b4.setSize(80,40);
			P2_b5.setSize(80,40);
			P2_l1.setSize(80,40);
			P2_l2.setSize(120,50);
			P2_box.setSize(80,30);
			P2_Text_down.setSize(860,210);
			P2_Text_up.setSize(480,120);
			
			P2_list_up.setLocation(0, 0);
		
			P2_list_side.setLocation(260, 160);
			P2_b1.setLocation(780, 0);
			P2_b2.setLocation(780, 40);
			P2_b3.setLocation(780, 80);
			P2_b4.setLocation(780, 120);
			P2_b5.setLocation(150,205);
			P2_l1.setLocation(0,205);
			P2_l2.setLocation(10,240);
			P2_box.setLocation(58,210);
			
			P2_Text_down.setLocation(0, 280);
			P2_Text_up.setLocation(381, 160);
			
			p2.add(P2_list_up);
			
			p2.add(P2_list_side);
			p2.add(P2_b1);
			p2.add(P2_b2);
			p2.add(P2_b3);
			p2.add(P2_b4);
			p2.add(P2_b5);
			p2.add(P2_l1);
			p2.add(P2_l2);
			p2.add(P2_box);
			p2.add(P2_Text_up);
			p2.add(P2_Text_down);
			

			contentPane.add(p2);
		}
	}
	//TCP헤더추가
	class panel3 extends JPanel
	{
		private static final long serialVersionUID = 1L;

		panel3()
		{
			TCP_icon = new ImageIcon("TCP패킷헤더_proto.jpg"); 
			UDP_icon = new ImageIcon("UDP패킷헤더_proto.jpg");
			IP_icon = new ImageIcon("IP패킷헤더_proto.jpg"); 
			ARP_icon = new ImageIcon("ARP패킷헤더_proto.jpg");
			
			p3 = new JPanel();
			p3.setSize(860,400);
			p3.setLocation(600,500);
			p3.setLayout(null);
			//p3.setLayout(new FlowLayout());
			//p3.setBackground(Color.blue);
			p3_icon_l1 = new JLabel(TCP_icon);
			p3_icon_l2 = new JLabel(UDP_icon);
			p3_icon_l3 = new JLabel(IP_icon);
			p3_icon_l4 = new JLabel(ARP_icon);
			
			P3_l1= new JLabel("TCP Header Proto");
			P3_l2= new JLabel("UDP Header Proto");
			P3_l3= new JLabel("IP Header Proto");
			P3_l4= new JLabel("ARP Header Proto");
			
			P3_l1.setSize(120,40);
			P3_l2.setSize(120,40);
			P3_l3.setSize(120,40);
			P3_l4.setSize(120,40);
			
			p3_icon_l1.setSize(400,200);
			p3_icon_l2.setSize(400,200);
			p3_icon_l3.setSize(400,200);
			p3_icon_l4.setSize(400,200);
			
			P3_l1.setLocation(0,0);
			P3_l2.setLocation(410,0);
			P3_l3.setLocation(0,170);
			P3_l4.setLocation(410,130);
			
			p3_icon_l1.setLocation(0,0);
			p3_icon_l2.setLocation(410,-20);
			p3_icon_l3.setLocation(0,170);
			p3_icon_l4.setLocation(380,140);
			
			
			
			p3.add(P3_l1);
			p3.add(P3_l2);
			p3.add(P3_l3);
			p3.add(P3_l4);
			
			p3.add(p3_icon_l1);
			p3.add(p3_icon_l2);
			p3.add(p3_icon_l3);
			p3.add(p3_icon_l4);
			
			contentPane.add(p3);
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					new Window_GUI();
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}
}
