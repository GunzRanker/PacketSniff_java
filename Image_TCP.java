package GUI_Package;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Image_TCP extends JDialog{
	private static final long serialVersionUID = 1L;
	ImageIcon tcp_image = new ImageIcon("TCP패킷헤더_blank.jpg");
	JPanel tcp_image_panel=null;
	
	String title=null;
	String s_ip=null;
	String d_ip=null;
	String off=null;
	String sport=null;
	String dport=null;
	String seq=null;
	String win=null;
	String ack=null;
	
	String resv=null;
	String control=null;
	String check=null;
	String urg=null;
	String opt=null;
	String pad=null;
	
	public Image_TCP(String title,String s_ip,String d_ip,String off,String sport,String dport,String seq,String win,String ack)
	{
		this.title = title;
		this.s_ip = s_ip;
		this.d_ip = d_ip;
		this.off = off;
		this.sport = sport;
		this.dport = dport;
		this.seq = seq;
		this.win = win;
		this.ack = ack;
		
		resv="0";
		control="0";
		check="101010110011011";
		urg="0";
		opt="0";
		pad="0";
		
		setTitle(title);
		setSize(650,300);
		setLocation(0,250);
		
		add(new tcp_image_panel(),BorderLayout.CENTER);

		setVisible(true);
	}
	public class tcp_image_panel extends JPanel
	{
		JLabel tcp_icon_sport = null;
		JLabel tcp_icon_dport = null;
		JLabel tcp_icon_seq = null;
		JLabel tcp_icon_ack = null;
		JLabel tcp_icon_off = null;
		JLabel tcp_icon_win = null;
		JLabel tcp_icon_sip = null;
		JLabel tcp_icon_dip = null;
		JLabel term = null;
		
		JLabel tcp_icon_resv = null;
		JLabel tcp_icon_cont = null;
		JLabel tcp_icon_chec = null;
		JLabel tcp_icon_urg = null;
		JLabel tcp_icon_opt = null;
		JLabel tcp_icon_pad = null;
		
		private static final long serialVersionUID = 1L;
		
		public tcp_image_panel()
		{
			setSize(650,300);
			setLayout(null);
			
			tcp_icon_sport = new JLabel(sport);
			tcp_icon_dport = new JLabel(dport);
			tcp_icon_seq = new JLabel(seq);
			tcp_icon_ack = new JLabel(ack);
			tcp_icon_off = new JLabel(off);
			tcp_icon_win = new JLabel(win);
			tcp_icon_sip = new JLabel(s_ip);
			tcp_icon_dip = new JLabel(d_ip);
			term = new JLabel("====>");
			tcp_icon_resv = new JLabel(resv);
			tcp_icon_cont = new JLabel(control);
			tcp_icon_chec = new JLabel(check);
			tcp_icon_urg = new JLabel(urg);
			tcp_icon_opt = new JLabel(opt);
			tcp_icon_pad = new JLabel(pad);
			
			
			
			tcp_icon_sport.setSize(50,50);
			tcp_icon_dport.setSize(50,50);
			tcp_icon_seq.setSize(100,50);
			tcp_icon_ack.setSize(100,50);
			tcp_icon_off.setSize(50,50);
			tcp_icon_win.setSize(50,50);
			tcp_icon_sip.setSize(100,50);
			tcp_icon_dip.setSize(100,50);
			term.setSize(100,50);
			tcp_icon_resv.setSize(50,50);
			tcp_icon_cont.setSize(50,50);
			tcp_icon_chec.setSize(100,50);
			tcp_icon_urg.setSize(50,50);
			tcp_icon_opt.setSize(50,50);
			tcp_icon_pad.setSize(50,50);
			
			
			tcp_icon_sport.setLocation(150,20);
			tcp_icon_dport.setLocation(450,20);
			tcp_icon_seq.setLocation(280,55);
			tcp_icon_ack.setLocation(280,85);
			tcp_icon_off.setLocation(35,120);
			tcp_icon_win.setLocation(450,120);
			tcp_icon_sip.setLocation(150,217);
			tcp_icon_dip.setLocation(400,217);
			term.setLocation(300,217);
			tcp_icon_resv.setLocation(140,120);
			tcp_icon_cont.setLocation(270,120);
			tcp_icon_chec.setLocation(150,150);
			tcp_icon_urg.setLocation(450,150);
			tcp_icon_opt.setLocation(250,185);
			tcp_icon_pad.setLocation(540,185);
			
			
			add(tcp_icon_sport);
			add(tcp_icon_dport);
			add(tcp_icon_seq);
			add(tcp_icon_ack);
			add(tcp_icon_off);
			add(tcp_icon_win);
			add(tcp_icon_sip);
			add(tcp_icon_dip);
			add(term);
			add(tcp_icon_resv);
			add(tcp_icon_cont);
			add(tcp_icon_chec);
			add(tcp_icon_urg);
			add(tcp_icon_opt);
			add(tcp_icon_pad);
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(tcp_image.getImage(), 0,0, getWidth(),getHeight(),this);
	
			setOpaque(false);
			
		}
	}
}
