import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MultiClientServer implements Runnable {

    private static ServerSocket serverSocket;
    private int port;
    Socket connectionSocket;

    MultiClientServer(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    MultiClientServer(Socket socket) {
       
      this.connectionSocket = socket;
    }


    // method for server with multithreading
    public void server() throws IOException {
        System.out.println("Server started....Waiting for connections.....");

        // Thread for handling user input
        Thread userInputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter message to send to clients (or 'quit' to stop server): ");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("quit")) {
                    System.out.println("Server is shutting down...");
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                // Broadcast message to all connected clients
                broadcastMessage(userInput);
            }
            scanner.close();
        });
        userInputThread.start();

        // Accept client connections
        while (true) {
            Socket socket = serverSocket.accept();
            Thread clientThread = new Thread(new MultiClientServer(socket));
            clientThread.start();
        }
    }

    // Broadcast message to all connected clients
    private static void broadcastMessage(String message) {
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            if (thread.getState() == Thread.State.RUNNABLE && thread.getName().startsWith("Thread-")) {
                try {
                    Socket clientSocket = ((MultiThreadServer) thread.getRunnable()).connectionSocket;
                    PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                    outputToClient.println(message);
                    outputToClient.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // run method
    public void run() {
        try (
            Socket connectionSocket = this.connectionSocket;
            BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            PrintWriter outputFromServer = new PrintWriter(connectionSocket.getOutputStream(), true);
        ) {
            System.out.println("Client connected");
            String clientMessage;

            while ((clientMessage = inputFromClient.readLine()) != null) {
                if (clientMessage.equalsIgnoreCase("Bye server")) {
                    System.out.println("From Client : " + clientMessage);
                    outputFromServer.println("Server received disconnect request. Bye!");
                    outputFromServer.flush();
                    break;
                }
                System.out.println("From Client : " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // main method
    public static void main(String[] args) throws IOException {
        MultiClientServer obj = new MultiClientServer(4555);
        obj.server();
    }
}
