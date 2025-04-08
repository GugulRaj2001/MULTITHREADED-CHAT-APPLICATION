package ChatApplication;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<PrintWriter> clientWriters = new HashSet<>();
    private static Map<String, PrintWriter> clientNames = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Chat Server is running...");
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Request client name
                out.println("Enter your name: ");
                clientName = in.readLine();

                // Ensure unique username
                synchronized (clientNames) {
                    while (clientNames.containsKey(clientName)) {
                        out.println("Name already taken, choose another: ");
                        clientName = in.readLine();
                    }
                    clientNames.put(clientName, out);
                }

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                broadcast(clientName + " has joined the chat!");

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    }
                    broadcast(clientName + ": " + message);
                }

                // Clean up and notify other users
                synchronized (clientWriters) {
                    clientWriters.remove(out);
                }
                synchronized (clientNames) {
                    clientNames.remove(clientName);
                }

                socket.close();
                broadcast(clientName + " has left the chat.");
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
            }
        }
    }
}
