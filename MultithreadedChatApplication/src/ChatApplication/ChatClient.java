package ChatApplication;

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private static PrintWriter out;
    private static BufferedReader in;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Start listener thread to receive messages
            Thread listenerThread = new Thread(new Listener());
            listenerThread.start();

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name = consoleInput.readLine();
            out.println(name);

            String message;
            while (true) {
                message = consoleInput.readLine();
                out.println(message);
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Listener implements Runnable {
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
