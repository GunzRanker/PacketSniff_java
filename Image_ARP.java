package GUI_Package;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Image_ARP extends JDialog{
	private static final long serialVersionUID = 1L;
	ImageIcon arp_image = new ImageIcon("ARP패킷헤더_blank.jpg");
	JPanel arp_image_panel=null;
	
	String hType=null;
	String pType=null;
	String h_len=null;
	String p_len=null;
	String opcode=null;
	String s_hw=null;
	String s_ip=null;
	String d_hw=null;
	String d_ip=null;

	public Image_ARP(String title,String opcode,String s_hw,String s_ip,String d_hw,String d_ip)
	{
		hType="1"; //이더넷
		pType="ox0800"; //ipv4
		h_len="6";
		p_len="4";
		this.opcode=opcode;
		this.s_hw = s_hw;
		this.s_ip = s_ip;
		this.d_hw = d_hw;
		this.d_ip = d_ip;
		
		setTitle(title);
		setSize(650,300);
		setLocation(0,500);
		
		add(new arp_image_panel(),BorderLayout.CENTER);

		setVisible(true);
	}
	public class arp_image_panel extends JPanel
	{
		JLabel arp_icon_ht = null;
		JLabel arp_icon_pt = null;
		JLabel arp_icon_hl = null;
		JLabel arp_icon_pl = null;
		JLabel arp_icon_op = null;
		JLabel arp_icon_sh = null;
		JLabel arp_icon_si = null;
		JLabel arp_icon_dh = null;
		JLabel arp_icon_di = null;
		
		private static final long serialVersionUID = 1L;
		
		public arp_image_panel()
		{
			setSize(650,300);
			setLayout(null);
			arp_icon_ht = new JLabel(hType);
			arp_icon_pt = new JLabel(pType);
			arp_icon_hl = new JLabel(h_len);
			arp_icon_pl = new JLabel(p_len);
			arp_icon_op = new JLabel(opcode);
			arp_icon_sh = new JLabel(s_hw);
			arp_icon_si = new JLabel(s_ip);
			arp_icon_dh = new JLabel(d_hw);
			arp_icon_di = new JLabel(d_ip);
			
			
			arp_icon_ht.setSize(50,50);
			arp_icon_pt.setSize(80,50);
			arp_icon_hl.setSize(50,50);
			arp_icon_pl.setSize(50,50);
			arp_icon_op.setSize(50,50);
			arp_icon_sh.setSize(100,50);
			arp_icon_si.setSize(100,50);
			arp_icon_dh.setSize(100,50);
			arp_icon_di.setSize(100,50);
			
			
			arp_icon_ht.setLocation(150,40);
			arp_icon_pt.setLocation(450,40);
			arp_icon_hl.setLocation(75,80);
			arp_icon_pl.setLocation(225,80);
			arp_icon_op.setLocation(450,80);
			arp_icon_sh.setLocation(300,115);
			arp_icon_si.setLocation(300,150);
			arp_icon_dh.setLocation(300,185);
			arp_icon_di.setLocation(300,210);
			
			add(arp_icon_ht);
			add(arp_icon_pt);
			add(arp_icon_hl);
			add(arp_icon_pl);
			add(arp_icon_op);
			add(arp_icon_sh);
			add(arp_icon_si);
			add(arp_icon_dh);
			add(arp_icon_di);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(arp_image.getImage(), 0,0, getWidth(),getHeight(),this);
	
			setOpaque(false);
			
		}
	}
}
