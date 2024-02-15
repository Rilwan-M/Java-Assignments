import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocClient {


    public static void main(String args[]) throws Exception{

        String ip ="localhost";
        int port = 4555; // 0-1023 allocated but 65535 ports available as total


        Socket clientSocket = new Socket(ip,port);

        // String str = " Hi Server, this is from Client\r";


		


		try(
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		//create output stream AND READ INPUT STREAM
		PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true );
		Scanner input = new Scanner(System.in)) {
			

			System.out.println("Connected to server");
            String clientMessage;
			

			while(true){

				System.out.println("Enter the message or (enter \"quit \" to exit) : ");
				clientMessage = input.nextLine();

				//utf-8 encoded
				// writer.write(clientMessage);
				
				
				if(clientMessage.equalsIgnoreCase("quit")){

					clientMessage = "Bye server";
					writer.println(clientMessage);
					clientSocket.close();

					break; // Exit the loop if the user wants to quit

				}

				writer.println(clientMessage);

				
				String serverMessage = reader.readLine();

				System.out.println("From Server : "+ serverMessage);

			}

			
		} catch (Exception e) {
			System.out.println("Connection error");
		}



		
		
		
		//close connections
		// dos.close();
		// s1out.close();
		// clientSocket.close()
   
    }

    
}
