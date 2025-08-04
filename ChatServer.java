import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected.");
            ClientHandler handler = new ClientHandler(socket);
            clientHandlers.add(handler);
            handler.start();
        }
    }

    // Broadcasts message to all clients
    static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clientHandlers) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Removes a client from the handler list
    static void removeClient(ClientHandler client) {
        clientHandlers.remove(client);
    }

    // Inner class for handling clients
    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Enter your name: ");
                name = in.readLine();
                System.out.println(name + " has joined.");

                broadcast(name + " has joined the chat!", this);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(name + ": " + message);
                    broadcast(name + ": " + message, this);
                }

            } catch (IOException e) {
                System.out.println("Connection with " + name + " lost.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {}
                removeClient(this);
                broadcast(name + " has left the chat.", this);
                System.out.println(name + " disconnected.");
            }
        }

        void sendMessage(String message) {
            out.println(message);
        }
    }
}
