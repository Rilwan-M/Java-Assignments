import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.print.event.PrintEvent;


public class SocServer {
    
    
    public static void main(String args[]) throws Exception{

        String ip ="localhost";
        int port = 4555; // 0-1023 allocated but 65535 ports available as total


        System.out.println("Server is started");
        ServerSocket ss = new ServerSocket(port);

        
        System.out.println("Server is waiting for client request");

        while(true)    {
            Socket socket = ss.accept(); 
            handle(socket);
            }
       

        System.out.println("Client connected");

        //read inputstream
		// InputStream s1In = s.getInputStream();
		// DataInputStream dis = new DataInputStream(s1In);

        // InputStreamReader inStream = new InputStreamReader(s.getInputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		// String st = new String(dis.readUTF());
		// String clientMessage = in.readLine();
		System.out.println("From Client : "+ in.readLine());


        //create output stream
		OutputStream s1out = s.getOutputStream();
		DataOutputStream dos = new DataOutputStream(s1out);


        	//utf-8 encoded
		dos.writeUTF("Hi Client, this is from Server");
		
        
		//close connections
		in.close();
		// s1In.close();
		s.close();
		


       }

    private static void handle(Socket socket) {


        for(line = in.readLine();
        )
        
      
    }
}
