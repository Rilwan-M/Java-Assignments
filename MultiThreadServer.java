import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {

    private static ServerSocket serverSocket;
    private int port;
    private ExecutorService executor;

    public MultiThreadServer(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(port);
        this.executor = Executors.newCachedThreadPool(); // Use a cached thread pool
    }

    public void start() {
        System.out.println("Server started....Waiting for connections.....");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
                executor.submit(new ClientHandler(socket)); // Handle client in a new thread
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket connectionSocket;

        public ClientHandler(Socket socket) {
            this.connectionSocket = socket;
        }

        @Override
        public void run() {
            try (
                BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                Scanner scanner = new Scanner(System.in);
                PrintWriter outputFromServer = new PrintWriter(connectionSocket.getOutputStream(), true);
            ) {
                String clientMessage;
                String serverMessage;

                while (true) {
                    clientMessage = inputFromClient.readLine();
                    if (clientMessage == null || clientMessage.equalsIgnoreCase("Bye server")) {
                        System.out.println("Client disconnected: " + connectionSocket.getInetAddress().getHostAddress());
                        break;
                    }
                    System.out.println("From Client (" + connectionSocket.getInetAddress().getHostAddress() + "): " + clientMessage);
                    System.out.print("Enter Server's message: ");
                    serverMessage = scanner.nextLine();
                    outputFromServer.println(serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connectionSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MultiThreadServer server = new MultiThreadServer(4555);
        server.start();
    }
}
