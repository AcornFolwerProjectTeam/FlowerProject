package com.flower.client.config;

import java.awt.Image;

import javax.swing.ImageIcon;

public class EnMethod {
	/**
	 * �̹����� �ش� �ʺ��� ũ��� �ٿ��ִ� �޼���
	 * https://stackoverflow.com/a/34189578
	 * */
	public static ImageIcon scaleImage(ImageIcon icon, int w, int h)
    {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
}
