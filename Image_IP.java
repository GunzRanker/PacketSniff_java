package GUI_Package;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Image_IP extends JDialog{
	private static final long serialVersionUID = 1L;
	ImageIcon ip_image = new ImageIcon("IP패킷헤더_blank.jpg");
	JPanel ip_image_panel=null;
	
	String ver=null;
	String hlen=null;
	String tos=null;
	String tot_l=null;
	String iden=null;
	String flag=null;
	String flag_off=null;
	String hop=null;
	String pro=null;
	String check=null;
	String sip=null;
	String dip=null;
	String opt=null;
	String sec=null;
	String usec=null;

	
	

	public Image_IP(String title,String sec,String usec,String sip,String dip,String pro,String flag,String hop,String off,String iden)
	{
		ver = "4";
		hlen = "6";
		tos = "0";
		tot_l = "5";
		this.iden = iden;
		this.flag = flag;
		this.flag_off = off;
		this.hop = hop;
		this.pro = pro;
		check = "101011100";
		this.sip = sip;
		this.dip = dip;
		opt = "0";
		this.sec = sec;
		this.usec = usec;
		
		setTitle(title);
		setSize(650,300);
		setLocation(0,550);
		
		add(new ip_image_panel(),BorderLayout.CENTER);

		setVisible(true);
	}
	public class ip_image_panel extends JPanel
	{
		JLabel ip_icon_ver = null;
		JLabel ip_icon_hlen = null;
		JLabel ip_icon_tos = null;
		JLabel ip_icon_tot_l = null;
		JLabel ip_icon_iden = null;
		JLabel ip_icon_flag = null;
		JLabel ip_icon_flag_off = null;
		JLabel ip_icon_hop = null;
		JLabel ip_icon_pro = null;
		JLabel ip_icon_check = null;
		JLabel ip_icon_sip = null;
		JLabel ip_icon_dip = null;
		JLabel ip_icon_opt = null;
		JLabel ip_icon_sec = null;
		JLabel ip_icon_usec = null;
		
		private static final long serialVersionUID = 1L;
		
		public ip_image_panel()
		{
			setSize(650,300);
			setLayout(null);
			ip_icon_ver = new JLabel(ver);
			ip_icon_hlen = new JLabel(hlen);
			ip_icon_tos = new JLabel(tos);
			ip_icon_tot_l = new JLabel(tot_l);
			ip_icon_iden = new JLabel(iden);
			ip_icon_flag = new JLabel(flag);
			ip_icon_flag_off = new JLabel(flag_off);
			ip_icon_hop = new JLabel(hop);
			ip_icon_pro = new JLabel(pro);
			ip_icon_check = new JLabel(check);
			ip_icon_sip = new JLabel(sip);
			ip_icon_dip = new JLabel(dip);
			ip_icon_opt = new JLabel(opt);
			ip_icon_sec = new JLabel(sec);
			ip_icon_usec = new JLabel(usec);
			
			
			ip_icon_ver.setSize(50,50);
			ip_icon_hlen.setSize(50,50);
			ip_icon_tos.setSize(50,50);
			ip_icon_tot_l.setSize(50,50);
			ip_icon_iden.setSize(50,50);
			ip_icon_flag.setSize(50,50);
			ip_icon_flag_off.setSize(50,50);
			ip_icon_hop.setSize(50,50);
			ip_icon_pro.setSize(50,50);
			ip_icon_check.setSize(150,50);
			ip_icon_sip.setSize(100,50);
			ip_icon_dip.setSize(100,50);
			ip_icon_opt.setSize(50,50);
			ip_icon_sec.setSize(80,50);
			ip_icon_usec.setSize(80,50);
			
			ip_icon_ver.setLocation(40,22);
			ip_icon_hlen.setLocation(120,22);
			ip_icon_tos.setLocation(240,22);
			ip_icon_tot_l.setLocation(460,22);
			ip_icon_iden.setLocation(160,55);
			ip_icon_flag.setLocation(350,55);
			ip_icon_flag_off.setLocation(500,55);
			ip_icon_hop.setLocation(80,88);
			ip_icon_pro.setLocation(240,88);
			ip_icon_check.setLocation(450,88);
			ip_icon_sip.setLocation(280,121);
			ip_icon_dip.setLocation(280,154);
			ip_icon_opt.setLocation(310,187);
			ip_icon_sec.setLocation(180,220);
			ip_icon_usec.setLocation(400,220);
			
			add(ip_icon_ver);
			add(ip_icon_hlen);
			add(ip_icon_tos);
			add(ip_icon_tot_l);
			add(ip_icon_iden);
			add(ip_icon_flag);
			add(ip_icon_flag_off);
			add(ip_icon_hop);
			add(ip_icon_pro);
			add(ip_icon_check);
			add(ip_icon_sip);
			add(ip_icon_dip);
			add(ip_icon_opt);
			add(ip_icon_sec);
			add(ip_icon_usec);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(ip_image.getImage(), 0,0, getWidth(),getHeight(),this);
	
			setOpaque(false);
			
		}
	}
}
