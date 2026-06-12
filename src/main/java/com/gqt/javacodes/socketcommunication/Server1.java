package com.gqt.javacodes.socketcommunication;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(3000);
		System.out.println("server is ready to accept the msg!");
		Socket ssoc = listener.accept();
		InputStream is = ssoc.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		OutputStream os = ssoc.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		Scanner sc = new Scanner(System.in);
		for(int i=1; i<=5; i++) {
			String msg = dis.readUTF();
			System.out.println(msg);
			System.out.println("-------------");
			System.out.println("Enter response: ");
			String resp = sc.nextLine();
			dos.writeUTF(resp);
		}
		
		dos.close();
		dis.close();
		ssoc.close();
		listener.close();
		sc.close();
		
	}
}

