package com.flower.client.productlist;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.flower.client.MainClass;

@SuppressWarnings("serial")
public class TopProdPane extends JPanel implements ActionListener{
	JButton curation;
	ImageIcon imgCuration;
	MainClass mc;
	
	TopProdPane(MainClass mc){
		this.mc=mc;
		setPreferredSize(new Dimension(550, 220));
		imgCuration = new ImageIcon("imgs/cu.jpg");
		curation =new JButton(imgCuration);
		curation.setBorderPainted(false);
		curation.setContentAreaFilled(false);
		curation.addActionListener(this);
		add(curation,BorderLayout.NORTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mc.changeCardLayout("curationPanel");	}
}
