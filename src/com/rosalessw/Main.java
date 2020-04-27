package com.rosalessw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket server = new ServerSocket(123);
		
		System.out.println("wainting .... ");
		
		Socket socket = server.accept();
		System.out.println("connect");
		
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		JLabel label = new JLabel();
		
		JFrame frame = new JFrame();
		frame.setSize(640,360);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		label = new JLabel();
		label.setSize(640, 360);
		label.setVisible(true);
		
		
		
		frame.add(label);
		frame.setVisible(true);
		
		while (true) {
			label.setIcon((ImageIcon)in.readObject());
			
		}
		
		
		
	}
	
	
	
}
