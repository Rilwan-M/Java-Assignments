import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

    public static void main(String[] args) {
        String ip = "localhost";
        int port = 4555;

        try (Socket clientSocket = new Socket(ip, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server");
            String clientMessage;
            while (true) {
                System.out.println("Enter a message (type 'quit' to exit): ");
                clientMessage = scanner.nextLine();
                writer.println(clientMessage);

                if ("quit".equalsIgnoreCase(clientMessage)) {
                    break;
                }

                // Receive response from the server
                String response = reader.readLine();
                System.out.println("From Server: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
