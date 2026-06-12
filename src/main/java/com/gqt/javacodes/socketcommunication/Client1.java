package com.gqt.javacodes.socketcommunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
	public static void main(String[] args) throws IOException {
		Socket cosc =  new Socket("localhost",3000);
		OutputStream os = cosc.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Scanner sc = new Scanner(System.in);
		InputStream is = cosc.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		for(int i=1; i<=5; i++) {
			System.out.println("Enter msg from client: ");
			String msg = sc.nextLine();
			dos.writeUTF(msg);
			System.out.println("----------------");
			String server_resp = dis.readUTF();
			System.out.println(server_resp);
		}
		
		
		dos.close();
		dis.close();
		cosc.close();
		sc.close();
	
	}
}

