package com.rosalessw;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.github.sarxos.webcam.Webcam;

public class Main2 {

	static Socket socket;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		
		socket = new Socket("localhost", 123);
		BufferedImage bm = webcam.getImage();
		ObjectOutputStream dout = new ObjectOutputStream(socket.getOutputStream());
		
		ImageIcon im = new ImageIcon(bm);
		JFrame frame = new JFrame("PC 1");
		frame.setSize(640, 360);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		JLabel l = new JLabel();
		l.setVisible(true);
		
		frame.add(l);
		frame.setVisible(true);
		
		
			while(true) {
				bm = webcam.getImage();
				im = new ImageIcon(bm);
				dout.writeObject(im);
				l.setIcon(im);
				dout.flush();
			}
		
		
		
		
		
		
	}
	
	
	
	
}
