package GUI_Package;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Image_UDP extends JDialog{
	private static final long serialVersionUID = 1L;
	ImageIcon udp_image = new ImageIcon("UDP패킷헤더_blank.jpg");
	JPanel udp_image_panel=null;
	
	String title=null;

	String sport=null;
	String dport=null;
	String total_l=null;
	String check=null;
	String sip=null;
	String term=null;
	String dip=null;

	public Image_UDP(String title,String sip,String dip,String sport,String dport)
	{
		this.sip = sip;
		this.dip = dip;
		this.sport = sport;
		this.dport = dport;
		total_l = "4";
		check = "10111001111";
		term = "====>";
		setTitle(title);
		setSize(650,300);
		setLocation(0,250);
		
		add(new udp_image_panel(),BorderLayout.CENTER);

		setVisible(true);
	}
	public class udp_image_panel extends JPanel
	{
		JLabel udp_icon_sip = null;
		JLabel udp_icon_dip = null;
		JLabel udp_icon_sport = null;
		JLabel udp_icon_dport = null;
		JLabel udp_icon_total_l = null;
		JLabel udp_icon_check = null;
		JLabel udp_icon_term = null;
		private static final long serialVersionUID = 1L;
		
		public udp_image_panel()
		{
			setSize(650,300);
			setLayout(null);

			udp_icon_sport = new JLabel(sport);
			udp_icon_dport = new JLabel(dport);
			udp_icon_total_l = new JLabel(total_l);
			udp_icon_check = new JLabel(check);
			udp_icon_sip = new JLabel(sip);
			udp_icon_term = new JLabel(term);
			udp_icon_dip = new JLabel(dip);
	
			udp_icon_sport.setSize(50,50);
			udp_icon_dport.setSize(50,50);
			udp_icon_total_l.setSize(50,50);
			udp_icon_check.setSize(100,50);
			udp_icon_sip.setSize(100,50);
			udp_icon_term.setSize(80,50);
			udp_icon_dip.setSize(100,50);
		
			udp_icon_sport.setLocation(150,40);
			udp_icon_dport.setLocation(450,40);
			udp_icon_total_l.setLocation(150,80);
			udp_icon_check.setLocation(450,80);
			udp_icon_sip.setLocation(150,115);
			udp_icon_term.setLocation(310,115);
			udp_icon_dip.setLocation(450,115);
			
			add(udp_icon_sport);
			add(udp_icon_dport);
			add(udp_icon_total_l);
			add(udp_icon_check);
			add(udp_icon_sip);
			add(udp_icon_term);
			add(udp_icon_dip);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(udp_image.getImage(), 0,0, getWidth(),getHeight(),this);
	
			setOpaque(false);
			
		}
	}
}
