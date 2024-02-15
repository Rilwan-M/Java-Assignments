import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocClient {


    public static void main(String args[]) throws Exception{

        String ip ="localhost";
        int port = 4555; // 0-1023 allocated but 65535 ports available as total


        Socket clientSocket = new Socket(ip,port);

        String str = " Hi Server, this is from Client\r";


        
		//create output stream
		OutputStream s1out = clientSocket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(s1out);


        	//utf-8 encoded
		dos.writeUTF(str);


        //read inputstream
		InputStream s1In = clientSocket.getInputStream();
		DataInputStream dis = new DataInputStream(s1In);
		
		String st = new String(dis.readUTF());
		
		System.out.println("From Server : "+ st);
		
		
		
		//close connections
		// dos.close();
		// s1out.close();
		// clientSocket.close();
		while(true){}

       



        
    }




    
}
