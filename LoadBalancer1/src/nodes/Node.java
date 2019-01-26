/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author mikeo_000
 */
public class Node {
     private int serverPort = 4000;
    private String serverHost = "host name";
    private InetAddress serverAddress = null;
    private Socket clientSocket = null;
    private BufferedReader keyboard = null;
    private BufferedReader streamFromServer = null;
    private PrintWriter streamToServer = null;

 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (args.length != 2) {
            System.out.println("Usage: Client <host name> <port on server>");
            System.exit(0);
    }
    
         String host = args[0];
        int destinationPort = Integer.parseInt(args[1]);

        Node node = new Node(host, destinationPort);

        try {
            /*
             * conenct and start client 
             */
            node.resolveServer();
            node.connectToServer();
            node.start();
            
        } catch (UnknownHostException error) {
            System.out.println("Unable to resolve server host: " + host);
        } catch (IOException error ) {
            System.out.println("Unable to connect to the server!");
        }
    }

    /**
     * Constructor
     * @param serverHost
     * @param serverPort 
     */
    public Node(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        keyboard = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * this method resolves the server!
     * @throws UnknownHostException 
     */
    public void resolveServer() throws UnknownHostException {
        serverAddress = InetAddress.getByName(serverHost);
    }

    /**
     * This method connects to the server! It will setup streams to write and receive 
     * input from the server.
     * @throws IOException 
     */
    public void connectToServer() throws IOException {
        clientSocket = new Socket(serverAddress, serverPort);
        streamToServer = new PrintWriter(clientSocket.getOutputStream(), true);
        streamFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Client using: " + clientSocket.toString());
    }

/**
     * method to deal with sending strings from keyboard on client to server 
     */
    public void start() {
        try {
            while (true) {
                System.out.print("> ");
                /*
                 * get text from user
                 */
                String request = keyboard.readLine().trim();
                
                /*
                 * if user has typed in "quit" then need to exit the client
                 */
                if (request.equalsIgnoreCase("quit")) {
                    break;
                }
                
                /*
                 * send what has been typed in to the server
                 */
                streamToServer.println(request);
                
                /*
                 * server will now reply back with how many characters user initially typed in
                 */
                String reply = streamFromServer.readLine();
                
                System.out.println("Server responded by saying the message contained " + reply + " characters.");
            }
            /*
             * shutdown, as quit was typed in by user
             */
            System.out.println("Terminating session with server...");
            
            /* 
             * tell the server to close the thread dealing with this client
             */
            streamToServer.println("quit");
            
        } catch (IOException error) {
            System.out.println("There was an error while communicating with the server!");
        } finally {
            
            /*
             * graceful shutdown
             */
            try {
                streamToServer.close();
                streamFromServer.close();
                clientSocket.close();
            } catch (IOException error) {
            }
        }
    }
    
}
