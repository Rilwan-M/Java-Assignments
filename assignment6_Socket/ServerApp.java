package com.arjuna.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) throws IOException {
		int port = 4555;
		
		//ip 192.168.1.5
		//create server socket
		ServerSocket serverSocket = new ServerSocket(port);
		
		Socket socket = serverSocket.accept();
		
		//create output stream
		OutputStream s1out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(s1out);
		
		//utf-8 encoded
		dos.writeUTF("Hello from server!");
		
		
		//close connections
		dos.close();
		s1out.close();
		socket.close();
		

	} 

}
