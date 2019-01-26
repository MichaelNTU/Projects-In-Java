/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadbalancer;
import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
//import java.util.Scanner;
/**
 *
 * @author mikeo_000
 */

public class Loadbalancer {

    /**
     * @param args the command line arguments
     */
  /*
     * private data
     */
    private int listeningPort = 5060;
    ServerSocket serverSocket ;
    int connectionQueueSize;
    LinkedList <String> nNodeList = new LinkedList <String>() ;
    NodeDetail node = new NodeDetail();
    byte[]buffer;
    InetAddress serverAddress;
    int SendAjob;
    public static void main(String[] args) {
        // TODO code application logic here

         Loadbalancer loadb = new Loadbalancer();
            loadb.Loadbalancer();
    
    }
    /**
     * Server constructor method.
     * @param listeningPort 
     */

    private void Loadbalancer() {
        try{
            DatagramSocket socket = null;
            try{
                socket = new DatagramSocket(5060);
                byte[] buffer = new byte[1024];
                //System.out.println("Send a Job to Nodes by Input Number:");
                //Scanner inputJob = new Scanner(System.in);
                //SendAjob = inputJob.nextInt();
                System.out.println("LoadBalancer Listtening:");
                
                
                while (true)
                {
                    int serverSocket = 5060;
                    DatagramPacket jobRequest = new DatagramPacket(buffer,buffer.length);
                    socket.setSoTimeout(500000);
                    socket.receive(jobRequest);
                    String message = new String( buffer );
                    System.out.println("Got message: " + message.trim());
                    socket.send(jobRequest);
                    InetAddress serverAddress = jobRequest.getAddress();
                    int listeninGPort = jobRequest.getPort();
                    int iniTiator = jobRequest.getPort();
                    String []nMessage = (new String(jobRequest.getData())).split(",");
                    nMessageConpleted(nMessage,serverAddress,listeninGPort,iniTiator);
                    
                }
                
            }
            catch(Exception error){
                System.out.println("It's has found error" + error);
            }
            socket.close();
            ServerSocket serverSocket = new ServerSocket(6000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Got message: " + clientSocket);
               System.out.println(clientSocket);
                
            }
        }
        catch(IOException ex){
            //Logger.getLogger(Loadbalancer.class.getName()).log(Level.SEVERE, null, ex);
       }
      
    }
    

    private void nMessageConpleted(String[] nMessage, InetAddress serverAddress, int listeninGPort,int iniTiator) {
        
        String counter = nMessage[0];
        
        
        switch(counter){
        
            case "Register":
                
                String nNodeName = nMessage[1];
                node.GenerateAnode(nNodeName,serverAddress,listeninGPort,iniTiator);
                nNodeList.add(nNodeName +","+serverAddress +","+listeninGPort+","+iniTiator);
                System.out.println(nNodeName+ "  "+ "Node been added to NodeList");
                System.out.println(nNodeList);
                for(String nNodeList: nNodeList)
                {
                System.out.println(nNodeList);
                System.out.println(",");
                }
                
                
                
                break;
                
            case "JOB":
                
                String nRequestJob1 = nMessage[0];
                String nRequestJob2 = nMessage[0];
                String nRequestJob3 = nMessage[0];
                String nextNode = nNodeList.removeLast();
                System.out.println(nRequestJob1+ nRequestJob2);
                nNodeList.addFirst(nextNode);
                
                String nNodes[] = nextNode.split(",");
                String nOfAdded = nNodes[0];
                
                int port = Integer.parseInt(nNodes[2]);
                node.SendToNodes(nRequestJob1, nRequestJob2,nOfAdded,port);
                node.jobTosend(nRequestJob3,nOfAdded,port);
                
                
                break;
                
            case "CONFIRM":
                
                String nJobConpleted = nMessage[1];
                System.out.println(nJobConpleted);
                
                break;
                
            case "Job":
                String nJobInitiated = nMessage[1];
                System.out.println(nJobInitiated);
                
                break;
            default:
                System.out.println("Error");
                
                break;
                
          }
      }

 }