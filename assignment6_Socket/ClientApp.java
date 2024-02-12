package com.arjuna.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//server ip and port
		
		String serverName = "localhost";
		int port = 4555;
		
		Socket clientSocket = new Socket(serverName,port);
		
		//read inputstream
		InputStream s1In = clientSocket.getInputStream();
		DataInputStream dis = new DataInputStream(s1In);
		
		String st = new String(dis.readUTF());
		
		System.out.println(st);
		
		//close connections
		dis.close();
		s1In.close();
		clientSocket.close();
		

	}

}
